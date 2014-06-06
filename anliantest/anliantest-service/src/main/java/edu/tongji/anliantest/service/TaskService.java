package edu.tongji.anliantest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.tongji.anliantest.dao.ContractReviewItemDao;
import edu.tongji.anliantest.dao.ContractReviewTableDao;
import edu.tongji.anliantest.dao.DepartmentDao;
import edu.tongji.anliantest.dao.EmployeeDao;
import edu.tongji.anliantest.dao.ProjectDao;
import edu.tongji.anliantest.dao.TaskDao;
import edu.tongji.anliantest.model.ContractReviewRecordTable;
import edu.tongji.anliantest.model.DepartmentInfo;
import edu.tongji.anliantest.model.EmployeeInfo;
import edu.tongji.anliantest.model.ProjectInfo;
import edu.tongji.anliantest.model.TaskInfo;
import edu.tongji.anliantest.utils.DepartmentType;
import edu.tongji.anliantest.utils.EmployeeTitle;
import edu.tongji.anliantest.utils.ProjectStatus;
import edu.tongji.anliantest.utils.TaskType;

@Service
public class TaskService {
	@Autowired
	private TaskDao taskDao;
	@Autowired
	private DepartmentDao departmentDao;
	@Autowired
	private ProjectDao projectDao;
	@Autowired
	private EmployeeDao employeeDao;
	@Autowired
	private ContractReviewTableDao contractReviewTableDao;
	@Autowired
	private ContractReviewItemDao contractReviewItemDao;
	
	public TaskInfo getTaskById(int taskId){
		return taskDao.load(taskId);
	}
	
	public List<TaskInfo> getTaskListByEmployeeId(int employeeId){
		return taskDao.getTaskListByEmployeeId(employeeId);
	}
	
	public void finishTask(int taskId){
		TaskInfo taskInfo = taskDao.load(taskId);
		
		if(taskInfo.getTaskType().equals(TaskType.SIGN_CONTRACT_REVIEW.toString())){
			String employeeTitle = taskInfo.getEmployeeInfo().getEmployeeTitle();
			ContractReviewRecordTable table = contractReviewTableDao.getContractReviewTableByProjectId(
					taskInfo.getProjectInfo().getProjectId());
			int departmentId = 0;
			if(employeeTitle.equals(EmployeeTitle.DETECT_MANAGER.toString())){
				departmentId = DepartmentType.DETECT.getDepartmentId();
				DepartmentInfo departmentInfo = departmentDao.load(departmentId);
				contractReviewItemDao.signContractReviewItem(table,departmentInfo);
			}else if(employeeTitle.equals(EmployeeTitle.EVALUATE_MANAGER.toString())){
				departmentId = DepartmentType.EVALUATE.getDepartmentId();
				DepartmentInfo departmentInfo = departmentDao.load(departmentId);
				contractReviewItemDao.signContractReviewItem(table,departmentInfo);
			}else if(employeeTitle.equals(EmployeeTitle.GENERAL_MANAGER.toString())){
				departmentId = DepartmentType.GENERAL_MANAGER.getDepartmentId();
				DepartmentInfo departmentInfo = departmentDao.load(departmentId);
				contractReviewItemDao.signContractReviewItem(table,departmentInfo);
			}else if(employeeTitle.equals(EmployeeTitle.QUALITY_MANAGER.toString())){
				departmentId = DepartmentType.QUALITY.getDepartmentId();
				DepartmentInfo departmentInfo = departmentDao.load(departmentId);
				contractReviewItemDao.signContractReviewItem(table,departmentInfo);
			}else if(employeeTitle.equals(EmployeeTitle.TECH_DIRECTOR.toString())){
				//技术负责人签字
				departmentId = DepartmentType.TECH_DIRECTOR.getDepartmentId();
				contractReviewTableDao.signContractReviewTable(table.getTableId());
			}else if(employeeTitle.equals(EmployeeTitle.ADMIN_MANAGER.toString())){
				departmentId = DepartmentType.ADMIN.getDepartmentId();
				DepartmentInfo departmentInfo = departmentDao.load(departmentId);
				contractReviewItemDao.signContractReviewItem(table,departmentInfo);
			}
			if(contractReviewTableDao.checkContractReviewTable(table.getTableId())){
				ProjectInfo projectInfo = taskInfo.getProjectInfo();
				projectInfo.setProjectStatus(new ProjectStatus(
						ProjectStatus.ProjectStep.PROJECT_ISSUE,
						ProjectStatus.StepStatus.CREATE_WORK_TASK).toString());
				projectDao.update(projectInfo);
				EmployeeInfo techDirector = employeeDao.getEmployeeByEmployeeTitle(EmployeeTitle.TECH_DIRECTOR);
				TaskInfo newTask = new TaskInfo();
				newTask.setProjectInfo(projectInfo);
				newTask.setEmployeeInfo(techDirector);
				newTask.setTaskType(TaskType.CREATE_WORK_TASK.toString());
				newTask.setTaskStatus(0);
				taskDao.save(newTask);
			}
		}else if(taskInfo.getTaskType().equals(TaskType.CREATE_WORK_TASK.toString())){
			ProjectInfo projectInfo = taskInfo.getProjectInfo();
			projectInfo.setProjectStatus(new ProjectStatus(
					ProjectStatus.ProjectStep.PROJECT_ISSUE,
					ProjectStatus.StepStatus.ASSIGN_PROJECT_EMPLOYEE).toString());
			projectDao.update(projectInfo);
			EmployeeInfo adminManager = employeeDao.getEmployeeByEmployeeTitle(EmployeeTitle.ADMIN_MANAGER);
			TaskInfo newTask = new TaskInfo();
			newTask.setProjectInfo(projectInfo);
			newTask.setEmployeeInfo(adminManager);
			newTask.setTaskType(TaskType.ASSIGN_PROJECT_EMPLOYEE.toString());
			newTask.setTaskStatus(0);
			taskDao.save(newTask);
		}else if(taskInfo.getTaskType().equals(TaskType.ASSIGN_PROJECT_EMPLOYEE.toString())){
			ProjectInfo projectInfo = taskInfo.getProjectInfo();
			projectInfo.setProjectStatus(new ProjectStatus(
					ProjectStatus.ProjectStep.PROJECT_PREPARE,
					ProjectStatus.StepStatus.CREATE_CONSUMER_RESOURCE).toString());
			projectDao.update(projectInfo);
			EmployeeInfo projectEmployee = projectInfo.getEmployeeInfoByProjectEmployeeId();
			TaskInfo newTask = new TaskInfo();
			newTask.setProjectInfo(projectInfo);
			newTask.setEmployeeInfo(projectEmployee);
			newTask.setTaskType(TaskType.CREATE_CONSUMER_RESOURCE.toString());
			newTask.setTaskStatus(0);
			taskDao.save(newTask);
		}else if(taskInfo.getTaskType().equals(TaskType.CREATE_CONSUMER_RESOURCE.toString())){
			ProjectInfo projectInfo = taskInfo.getProjectInfo();
			updateProjectStatus(projectInfo, 
					new ProjectStatus(
							ProjectStatus.ProjectStep.PROJECT_PREPARE,
							ProjectStatus.StepStatus.CREATE_FIELD_SURVEY));
			EmployeeInfo projectEmployee = projectInfo.getEmployeeInfoByProjectEmployeeId();
			createNewTask(projectInfo, projectEmployee, TaskType.CREATE_FIELD_SURVEY);
		}
		taskDao.finishTask(taskId);
	}
	
	private void updateProjectStatus(ProjectInfo projectInfo, ProjectStatus projectStatus){
		projectInfo.setProjectStatus(projectStatus.toString());
		projectDao.save(projectInfo);
	}
	
	private void createNewTask(
			ProjectInfo projectInfo,
			EmployeeInfo employeeInfo,
			TaskType taskType){
		TaskInfo newTask = new TaskInfo();
		newTask.setProjectInfo(projectInfo);
		newTask.setEmployeeInfo(employeeInfo);
		newTask.setTaskType(taskType.toString());
		newTask.setTaskStatus(0);
		taskDao.save(newTask);
	}

	public int createContractReviewTask(ProjectInfo projectInfo,
			EmployeeInfo businessEmployee) {
		
		TaskInfo newTask = new TaskInfo();
		newTask.setProjectInfo(projectInfo);
		newTask.setEmployeeInfo(businessEmployee);
		newTask.setTaskType(TaskType.CREATE_CONTRACT_REVIEW.toString());
		newTask.setTaskStatus(0);
		taskDao.save(newTask);
		
		int taskId = newTask.getTaskId();
		System.out.println("taskId: "+taskId);
		return taskId;
	}
}

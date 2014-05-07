package edu.tongji.anliantest.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.tongji.anliantest.dao.ContractReviewItemDao;
import edu.tongji.anliantest.dao.ContractReviewTableDao;
import edu.tongji.anliantest.dao.DepartmentDao;
import edu.tongji.anliantest.dao.EmployeeDao;
import edu.tongji.anliantest.dao.ProjectDao;
import edu.tongji.anliantest.dao.TaskDao;
import edu.tongji.anliantest.dao.WorkTaskItemDao;
import edu.tongji.anliantest.dao.WorkTaskTableDao;
import edu.tongji.anliantest.model.ContractReviewRecordItem;
import edu.tongji.anliantest.model.ContractReviewRecordTable;
import edu.tongji.anliantest.model.EmployeeInfo;
import edu.tongji.anliantest.model.ProjectInfo;
import edu.tongji.anliantest.model.TaskInfo;
import edu.tongji.anliantest.model.WorkTaskItem;
import edu.tongji.anliantest.model.WorkTaskTable;
import edu.tongji.anliantest.utils.ContractReviewForm;
import edu.tongji.anliantest.utils.DepartmentType;
import edu.tongji.anliantest.utils.EmployeeTitle;
import edu.tongji.anliantest.utils.ProjectStatus;
import edu.tongji.anliantest.utils.TaskType;
import edu.tongji.anliantest.utils.WorkTaskForm;
import edu.tongji.anliantest.utils.WorkTaskForm.TableType;

@Service
public class ProjectService {
	@Autowired
	private ProjectDao projectDao;
	@Autowired
	private EmployeeDao employeeDao;
	@Autowired
	private DepartmentDao departmentDao;
	@Autowired
	private TaskDao taskDao;
	@Autowired
	private ContractReviewTableDao contractReviewTableDao;
	@Autowired
	private ContractReviewItemDao contractReviewItemDao;
	@Autowired
	private WorkTaskTableDao workTaskTableDao;
	@Autowired
	private WorkTaskItemDao workTaskItemDao;
	
	public ProjectInfo createProject(ProjectInfo projectInfo){
		return projectDao.get(projectDao.save(projectInfo));
	}
	
	public List<ProjectInfo> listProject(){
		return projectDao.loadAll();
	}
	
	public ProjectInfo getProjectByProjectId(String projectId){
		return projectDao.get(Integer.parseInt(projectId));
	}
	
	public void editProject(ProjectInfo projectInfo){
		ProjectInfo projectInfoDB = getProjectByProjectId(projectInfo.getProjectId().toString());
		projectInfoDB.setProjectNum(projectInfo.getProjectNum());
		projectInfoDB.setProjectName(projectInfo.getProjectName());
		projectInfoDB.setCompanyName(projectInfo.getCompanyName());
		projectInfoDB.setCompanyAddress(projectInfo.getCompanyAddress());
		projectInfoDB.setContactPerson(projectInfo.getContactPerson());
		projectInfoDB.setContactTel(projectInfo.getContactTel());
		projectInfoDB.setContractAmount(projectInfo.getContractAmount());
		projectDao.update(projectInfoDB);
	}
	
	public void assignProject(int projectId, int employeeId){
		ProjectInfo projectInfo = projectDao.load(projectId);
		EmployeeInfo employeeInfo = employeeDao.load(employeeId);
		projectInfo.setEmployeeInfoByBusinessEmployeeId(employeeInfo);
		projectDao.update(projectInfo);
	}

	public void createContractReview(int projectId, ContractReviewForm contractReviewForm){
		//Fill data for contract_review_record_table
		ProjectInfo projectInfo = projectDao.get(projectId);
		EmployeeInfo techDirector = employeeDao.getEmployeeByEmployeeTitle(EmployeeTitle.TECH_DIRECTOR);
		ContractReviewRecordTable table = new ContractReviewRecordTable();
		table.setProjectInfo(projectInfo);
		table.setEmployeeInfo(techDirector);
		table.setTableNum(ContractReviewForm.CONTRACT_REVIEW_TABLE_NUM);
		table.setTableStatus(ContractReviewForm.Status.unsigned.toString());
		table.setTableTime(new Date());
		table = contractReviewTableDao.get(contractReviewTableDao.save(table));
		
		TaskInfo tTaskInfo = new TaskInfo();
		tTaskInfo.setEmployeeInfo(techDirector);
		tTaskInfo.setProjectInfo(projectInfo);
		tTaskInfo.setTaskType(TaskType.SIGN_CONTRACT_REVIEW.toString());
		tTaskInfo.setTaskStatus(0);
		taskDao.save(tTaskInfo);
		
		
		//Fill data for contract_review_record_item
		//Evaluate Department
		ContractReviewRecordItem eItem = new ContractReviewRecordItem();
		eItem.setContractReviewRecordTable(table);
		eItem.setDepartmentInfo(departmentDao.get(DepartmentType.EVALUATE.getDepartmentId()));
		eItem.setReviewContent(contractReviewForm.getEvaluateReviewContent());
		eItem.setReviewComment(contractReviewForm.getEvaluateReviewComment());
		eItem.setItemStatus(ContractReviewForm.ItemStatus.unsigned.toString());
		eItem.setItemTime(new Date());
		contractReviewItemDao.save(eItem);
		
		EmployeeInfo evaluateManager = employeeDao.getEmployeeByEmployeeTitle(EmployeeTitle.EVALUATE_MANAGER);
		TaskInfo eTaskInfo = new TaskInfo();
		eTaskInfo.setEmployeeInfo(evaluateManager);
		eTaskInfo.setProjectInfo(projectInfo);
		eTaskInfo.setTaskType(TaskType.SIGN_CONTRACT_REVIEW.toString());
		eTaskInfo.setTaskStatus(0);
		taskDao.save(eTaskInfo);
		
		//Detect Department
		ContractReviewRecordItem dItem = new ContractReviewRecordItem();
		dItem.setContractReviewRecordTable(table);
		dItem.setDepartmentInfo(departmentDao.get(DepartmentType.DETECT.getDepartmentId()));
		dItem.setReviewContent(contractReviewForm.getDetectReviewContent());
		dItem.setReviewComment(contractReviewForm.getDetectReviewComment());
		dItem.setItemStatus(ContractReviewForm.ItemStatus.unsigned.toString());
		dItem.setItemTime(new Date());
		contractReviewItemDao.save(dItem);
		
		EmployeeInfo detectManager = employeeDao.getEmployeeByEmployeeTitle(EmployeeTitle.DETECT_MANAGER);
		TaskInfo dTaskInfo = new TaskInfo();
		dTaskInfo.setEmployeeInfo(detectManager);
		dTaskInfo.setProjectInfo(projectInfo);
		dTaskInfo.setTaskType(TaskType.SIGN_CONTRACT_REVIEW.toString());
		dTaskInfo.setTaskStatus(0);
		taskDao.save(dTaskInfo);
		
		//Amin Department
		ContractReviewRecordItem aItem = new ContractReviewRecordItem();
		aItem.setContractReviewRecordTable(table);
		aItem.setDepartmentInfo(departmentDao.get(DepartmentType.ADMIN.getDepartmentId()));
		aItem.setReviewContent(contractReviewForm.getAdminReviewContent());
		aItem.setReviewComment(contractReviewForm.getAdminReviewComment());
		aItem.setItemStatus(ContractReviewForm.ItemStatus.unsigned.toString());
		aItem.setItemTime(new Date());
		contractReviewItemDao.save(aItem);
		
		EmployeeInfo adminManager = employeeDao.getEmployeeByEmployeeTitle(EmployeeTitle.ADMIN_MANAGER);
		TaskInfo aTaskInfo = new TaskInfo();
		aTaskInfo.setEmployeeInfo(adminManager);
		aTaskInfo.setProjectInfo(projectInfo);
		aTaskInfo.setTaskType(TaskType.SIGN_CONTRACT_REVIEW.toString());
		aTaskInfo.setTaskStatus(0);
		taskDao.save(aTaskInfo);
		
		//Quality Department
		ContractReviewRecordItem qItem = new ContractReviewRecordItem();
		qItem.setContractReviewRecordTable(table);
		qItem.setDepartmentInfo(departmentDao.get(DepartmentType.QUALITY.getDepartmentId()));
		qItem.setReviewContent(contractReviewForm.getQualityReviewContent());
		qItem.setReviewComment(contractReviewForm.getQualityReviewComment());
		qItem.setItemStatus(ContractReviewForm.ItemStatus.unsigned.toString());
		qItem.setItemTime(new Date());
		contractReviewItemDao.save(qItem);
		
		EmployeeInfo qualityManager = employeeDao.getEmployeeByEmployeeTitle(EmployeeTitle.QUALITY_MANAGER);
		TaskInfo qTaskInfo = new TaskInfo();
		qTaskInfo.setEmployeeInfo(qualityManager);
		qTaskInfo.setProjectInfo(projectInfo);
		qTaskInfo.setTaskType(TaskType.SIGN_CONTRACT_REVIEW.toString());
		qTaskInfo.setTaskStatus(0);
		taskDao.save(qTaskInfo);
		
		//General Manager
		ContractReviewRecordItem gItem = new ContractReviewRecordItem();
		gItem.setContractReviewRecordTable(table);
		gItem.setDepartmentInfo(departmentDao.get(DepartmentType.GENERAL_MANAGER.getDepartmentId()));
		gItem.setReviewContent(contractReviewForm.getGeneralManagerReviewContent());
		gItem.setReviewComment(contractReviewForm.getGeneralManagerReviewComment());
		gItem.setItemStatus(ContractReviewForm.ItemStatus.unsigned.toString());
		gItem.setItemTime(new Date());
		contractReviewItemDao.save(gItem);
		
		EmployeeInfo generalManager = employeeDao.getEmployeeByEmployeeTitle(EmployeeTitle.GENERAL_MANAGER);
		TaskInfo gTaskInfo = new TaskInfo();
		gTaskInfo.setEmployeeInfo(generalManager);
		gTaskInfo.setProjectInfo(projectInfo);
		gTaskInfo.setTaskType(TaskType.SIGN_CONTRACT_REVIEW.toString());
		gTaskInfo.setTaskStatus(0);
		taskDao.save(gTaskInfo);
		
		projectInfo.setProjectStatus(new ProjectStatus(ProjectStatus.ProjectStep.PROJECT_INPUT,
				ProjectStatus.StepStatus.SIGN_CONTRACT_REVIEW).toString());
		projectDao.update(projectInfo);
	}
	
	public void createWorkTask(int projectId, WorkTaskForm workTaskForm){
		ProjectInfo projectInfo = projectDao.get(projectId);
		EmployeeInfo employeeInfo = employeeDao.get(workTaskForm.getTaskIssuedEmployeeId());
		WorkTaskTable table = new WorkTaskTable();
		table.setTableNum(WorkTaskForm.WORK_TASK_TABLE_NUM);
		table.setTableType(TableType.CONTROL_EVAL.toString());
		table.setEmployeeInfo(employeeInfo);
		table.setProjectInfo(projectInfo);
		table.setTaskTime(new Date());
		table = workTaskTableDao.get(workTaskTableDao.save(table));
		
		WorkTaskItem item = new WorkTaskItem();
		item.setWorkTaskTable(table);
		item.setDepartmentInfo(departmentDao.get(DepartmentType.EVALUATE.getDepartmentId()));
		item.setWorkContent(workTaskForm.getEvaluateWorkContent());
		item.setWorkTimeLimit(workTaskForm.getEvaluateWorkTimeLimit());
		workTaskItemDao.save(item);
		
		item = new WorkTaskItem();
		item.setWorkTaskTable(table);
		item.setDepartmentInfo(departmentDao.get(DepartmentType.DETECT.getDepartmentId()));
		item.setWorkContent(workTaskForm.getDetectWorkContent());
		item.setWorkTimeLimit(workTaskForm.getDetectWorkTimeLimit());
		workTaskItemDao.save(item);
		
		item = new WorkTaskItem();
		item.setWorkTaskTable(table);
		item.setDepartmentInfo(departmentDao.get(DepartmentType.QUALITY.getDepartmentId()));
		item.setWorkContent(workTaskForm.getQualityWorkContent());
		item.setWorkTimeLimit(workTaskForm.getQualityWorkTimeLimit());
		workTaskItemDao.save(item);
		
		item = new WorkTaskItem();
		item.setWorkTaskTable(table);
		item.setDepartmentInfo(departmentDao.get(DepartmentType.ADMIN.getDepartmentId()));
		item.setWorkContent(workTaskForm.getAdminWorkContent());
		item.setWorkTimeLimit(workTaskForm.getAdminWorkTimeLimit());
		workTaskItemDao.save(item);
	}
}

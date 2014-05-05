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
import edu.tongji.anliantest.model.ContractReviewRecordItem;
import edu.tongji.anliantest.model.ContractReviewRecordTable;
import edu.tongji.anliantest.model.EmployeeInfo;
import edu.tongji.anliantest.model.ProjectInfo;
import edu.tongji.anliantest.model.TaskInfo;
import edu.tongji.anliantest.utils.ContractReviewForm;
import edu.tongji.anliantest.utils.DepartmentType;
import edu.tongji.anliantest.utils.EmployeeTitle;
import edu.tongji.anliantest.utils.ProjectStatus;

@Service
public class ProjectService {
	@Autowired
	private ProjectDao projectDao;
	@Autowired
	private EmployeeDao employeeDao;
	@Autowired
	private DepartmentDao departmentDao;
	@Autowired
	private ContractReviewTableDao contractReviewTableDao;
	@Autowired
	private ContractReviewItemDao contractReviewItemDao;
	
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
		TaskInfo workInfo = new TaskInfo();
		
		//Detect Department
		ContractReviewRecordItem dItem = new ContractReviewRecordItem();
		dItem.setContractReviewRecordTable(table);
		dItem.setDepartmentInfo(departmentDao.get(DepartmentType.DETECT.getDepartmentId()));
		dItem.setReviewContent(contractReviewForm.getDetectReviewContent());
		dItem.setReviewComment(contractReviewForm.getDetectReviewComment());
		dItem.setItemStatus(ContractReviewForm.ItemStatus.unsigned.toString());
		dItem.setItemTime(new Date());
		contractReviewItemDao.save(dItem);
		//Amin Department
		ContractReviewRecordItem aItem = new ContractReviewRecordItem();
		aItem.setContractReviewRecordTable(table);
		aItem.setDepartmentInfo(departmentDao.get(DepartmentType.ADMIN.getDepartmentId()));
		aItem.setReviewContent(contractReviewForm.getAdminReviewContent());
		aItem.setReviewComment(contractReviewForm.getAdminReviewComment());
		aItem.setItemStatus(ContractReviewForm.ItemStatus.unsigned.toString());
		aItem.setItemTime(new Date());
		contractReviewItemDao.save(aItem);
		//Quality Department
		ContractReviewRecordItem qItem = new ContractReviewRecordItem();
		qItem.setContractReviewRecordTable(table);
		qItem.setDepartmentInfo(departmentDao.get(DepartmentType.QUALITY.getDepartmentId()));
		qItem.setReviewContent(contractReviewForm.getQualityReviewContent());
		qItem.setReviewComment(contractReviewForm.getQualityReviewComment());
		qItem.setItemStatus(ContractReviewForm.ItemStatus.unsigned.toString());
		qItem.setItemTime(new Date());
		contractReviewItemDao.save(qItem);
		//General Manager
		ContractReviewRecordItem gItem = new ContractReviewRecordItem();
		gItem.setContractReviewRecordTable(table);
		gItem.setDepartmentInfo(departmentDao.get(DepartmentType.GENERAL_MANAGER.getDepartmentId()));
		gItem.setReviewContent(contractReviewForm.getGeneralManagerReviewContent());
		gItem.setReviewComment(contractReviewForm.getGeneralManagerReviewComment());
		gItem.setItemStatus(ContractReviewForm.ItemStatus.unsigned.toString());
		gItem.setItemTime(new Date());
		contractReviewItemDao.save(gItem);
		
		projectInfo.setProjectStatus(new ProjectStatus(ProjectStatus.ProjectStep.PROJECT_INPUT,
				ProjectStatus.StepStatus.UNSIGNED).toString());
		projectDao.update(projectInfo);
	}
}

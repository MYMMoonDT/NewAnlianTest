package edu.tongji.anliantest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.tongji.anliantest.dao.EmployeeDao;
import edu.tongji.anliantest.model.EmployeeInfo;
import edu.tongji.anliantest.utils.EmployeeTitle;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeDao employeeDao;
	
	public EmployeeInfo getEmployeeByEmployeeId(String employeeId){
		return employeeDao.get(Integer.parseInt(employeeId));
	}
	
	public EmployeeInfo getEmployeeByEmployeeNum(String employeeNum){
		return employeeDao.getEmployeeByEmployeeNum(employeeNum);
	}
	
	public EmployeeInfo getEmployeeByEmployeeName(String employeeName){
		return employeeDao.getEmployeeByEmployeeName(employeeName);
	}
	
	public EmployeeInfo getTechDirector(){
		return employeeDao.getEmployeeByEmployeeTitle(EmployeeTitle.TECH_DIRECTOR);
	}
	
	public EmployeeInfo getEmployeeByEmployeeTitle(EmployeeTitle title){
		return employeeDao.getEmployeeByEmployeeTitle(title);
	}

	public List<EmployeeInfo> getAllEmployees() {
		return employeeDao.loadAll();
	}

	public void update(EmployeeInfo employeeInfo) {
		employeeDao.update(employeeInfo);
	}
}

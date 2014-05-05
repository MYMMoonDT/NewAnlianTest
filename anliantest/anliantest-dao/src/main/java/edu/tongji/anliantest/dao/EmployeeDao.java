package edu.tongji.anliantest.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import edu.tongji.anliantest.model.EmployeeInfo;
import edu.tongji.anliantest.utils.EmployeeTitle;

@Repository
public class EmployeeDao extends BaseDao<EmployeeInfo>{
	private final String GET_EMPLOYEE_BY_EMPLOYEENUM = "from EmployeeInfo e where e.employeeNumber = ? ";
	private final String GET_EMPLOYEE_BY_EMPLOYEENAME = "from EmployeeInfo e where e.employeeName = ? ";
	private final String GET_EMPLOYEE_BY_EMPLOYEETITLE = "from EmployeeInfo e where e.employeeTitle = ? ";
	
	public EmployeeInfo getEmployeeByEmployeeNum(String employeeNum){
		List<EmployeeInfo> employees = (List<EmployeeInfo>)getHibernateTemplate().find(GET_EMPLOYEE_BY_EMPLOYEENUM, employeeNum);
		if(employees.size() == 0){
			return null;
		}else{
			return employees.get(0);
		}
	}
	
	public EmployeeInfo getEmployeeByEmployeeName(String employeeName){
		List<EmployeeInfo> employees = (List<EmployeeInfo>)getHibernateTemplate().find(GET_EMPLOYEE_BY_EMPLOYEENAME, employeeName);
		if(employees.size() == 0){
			System.out.println("no employee");
			return null;
		}else{
			return employees.get(0);
		}
	}
	
	public EmployeeInfo getEmployeeByEmployeeTitle(EmployeeTitle title){
		List<EmployeeInfo> employees = (List<EmployeeInfo>)getHibernateTemplate().find(GET_EMPLOYEE_BY_EMPLOYEETITLE, title.getTitle());
		if(employees.size() == 0){
			System.out.println("no employee");
			return null;
		}else{
			return employees.get(0);
		}
	}
}

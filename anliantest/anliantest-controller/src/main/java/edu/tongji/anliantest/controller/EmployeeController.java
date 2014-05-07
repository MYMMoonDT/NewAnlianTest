package edu.tongji.anliantest.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import edu.tongji.anliantest.model.EmployeeInfo;
import edu.tongji.anliantest.service.EmployeeService;
import edu.tongji.anliantest.utils.EmployeeStruct;

@Controller
public class EmployeeController extends BaseController {
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping(value = "/login")
	public String loginPage(){
		return "login";
	}
	
	@RequestMapping(value = "/doLogout")
	public String logout(HttpSession session){
		session.removeAttribute(EMPLOYEE_CONTEXT);
		return "forward:/index.jsp";
	}
	
	@RequestMapping(value = "/checkLogin")
	public ModelAndView checkLogin(HttpServletRequest request, EmployeeInfo employee){
		EmployeeInfo dbEmployee = employeeService.getEmployeeByEmployeeNum(employee.getEmployeeNumber());
		ModelAndView mav = new ModelAndView();
		mav.setViewName("forward:login");
		if(dbEmployee == null){
			mav.addObject("errorMsg", "用户名不存在");
		}else if(!dbEmployee.getEmployeePassword().equals(employee.getEmployeePassword())){
			mav.addObject("errorMsg", "用户密码不正确");
		}else{
			setSessionEmployee(request, dbEmployee);
			mav.setViewName("redirect:/home/list");
		}
		return mav;
	}
	
	@RequestMapping(value = "/employeeList")
	@ResponseBody
	public Map<String, Object> getEmployeeList(){
		List<EmployeeInfo> employeeList = employeeService.getAllEmployees();
		List<EmployeeStruct> eList = new ArrayList<EmployeeStruct>();
		for(EmployeeInfo employeeItem : employeeList){
			EmployeeStruct employeeStruct = new EmployeeStruct();
			employeeStruct.setEmployeeId(employeeItem.getEmployeeId());
			employeeStruct.setEmployeeName(employeeItem.getEmployeeName());
			employeeStruct.setEmployeeAvatar(employeeItem.getEmployeeAvatar());
			employeeStruct.setEmployeeTitle(employeeItem.getEmployeeTitle());
			eList.add(employeeStruct);
		}
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("result", "success");
		result.put("employeeList", eList);
		return result;
	}
}

package edu.tongji.anliantest.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.tongji.anliantest.model.EmployeeInfo;
import edu.tongji.anliantest.model.TaskInfo;
import edu.tongji.anliantest.service.TaskService;

@Controller
public class HomeController extends BaseController{
	@Autowired
	private TaskService taskService;
	
	@RequestMapping(value = "/home/list")
	public ModelAndView homeListPage(HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		EmployeeInfo employeeInfo = this.getSessionEmployee(request);
		List<TaskInfo> taskList = taskService.getTaskListByEmployeeId(employeeInfo.getEmployeeId());
		mav.addObject("taskList", taskList);
		mav.setViewName("homeList");
		return mav;
	}
}

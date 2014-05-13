package edu.tongji.anliantest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DocumentController extends BaseController{
	@RequestMapping(value = "/document")
	public String documentPage(){
		return "document";
	}
	
	@RequestMapping(value = "/document/employee/list")
	public String documentEmployeeListPage(){
		return "employeeDocList";
	}
}

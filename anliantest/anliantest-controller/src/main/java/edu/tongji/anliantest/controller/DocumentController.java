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
	
	@RequestMapping(value = "/document/employee/create")
	public String documentEmployeeCreatePage(){
		return "employeeDocCreate";
	}
	
	@RequestMapping(value = "/document/employee/doCreate")
	public String createEmployeeDoc(){
		return "redirect:/document/employee/list";
	}
	
	@RequestMapping(value = "/document/project/list")
	public String documentProjectListPage(){
		return "projectDocList";
	}
	
	@RequestMapping(value = "/document/project/view")
	public String documentProjectViewPage(){
		return "projectDocView";
	}
	
	@RequestMapping(value = "/document/law/list")
	public String documentLawListPage(){
		return "lawDocList";
	}
	
	@RequestMapping(value = "/document/law/create")
	public String documentLawCreatePage(){
		return "lawDocCreate";
	}
	
	@RequestMapping(value = "/document/law/doCreate")
	public String createLawDoc(){
		return "redirect:/document/law/list";
	}
	
	@RequestMapping(value = "/document/standard/list")
	public String documentStandardListPage(){
		return "standardDocList";
	}
	
	@RequestMapping(value = "/document/standard/create")
	public String documentStandardCreatePage(){
		return "standardDocCreate";
	}
	
	@RequestMapping(value = "/document/standard/doCreate")
	public String createStandardDoc(){
		return "redirect:/document/standard/list";
	}
	
	@RequestMapping(value = "/document/search")
	public String documentSearchPage(){
		return "docSearch";
	}
}

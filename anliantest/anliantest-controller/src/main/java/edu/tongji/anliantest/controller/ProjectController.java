package edu.tongji.anliantest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProjectController {
	@RequestMapping(value = "/project/list")
	public String projectListPage(){
		return "projectList";
	}
	@RequestMapping(value = "/project/create")
	public String projectCreatePage(){
		return "projectCreate";
	}
	@RequestMapping(value = "/project/doCreate")
	public String createProject(){
		return "forward:/contractreview/create";
	}
	@RequestMapping(value = "/project/edit")
	public String projectEditPage(){
		return "projectEdit";
	}
	@RequestMapping(value = "/project/doEdit")
	public String editProject(){
		return "redirect:/project/list";
	}
	@RequestMapping(value = "/contractreview/create")
	public String contractReviewCreatePage(){
		return "contractReviewCreate";
	}
	@RequestMapping(value = "/contractreview/doCreate")
	public String createContractReview(){
		return "redirect:/project/list";
	}
}

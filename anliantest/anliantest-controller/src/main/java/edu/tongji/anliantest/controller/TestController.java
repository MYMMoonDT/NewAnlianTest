package edu.tongji.anliantest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController extends BaseController{
	
	@RequestMapping(value = "/test")
	public String testPage(){
		return "test";
	}

}

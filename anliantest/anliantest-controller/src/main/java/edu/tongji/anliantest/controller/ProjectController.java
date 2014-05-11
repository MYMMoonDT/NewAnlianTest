package edu.tongji.anliantest.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import edu.tongji.anliantest.model.EmployeeInfo;
import edu.tongji.anliantest.model.ProjectInfo;
import edu.tongji.anliantest.model.TaskInfo;
import edu.tongji.anliantest.service.EmployeeService;
import edu.tongji.anliantest.service.ProjectService;
import edu.tongji.anliantest.service.TaskService;
import edu.tongji.anliantest.utils.ConsumerResourceForm;
import edu.tongji.anliantest.utils.ContractReviewForm;
import edu.tongji.anliantest.utils.ProjectStatus;
import edu.tongji.anliantest.utils.WorkTaskForm;

@Controller
public class ProjectController extends BaseController{
	@Autowired
	private ProjectService projectService;
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private TaskService taskService;
	
	@RequestMapping(value = "/project/list")
	public ModelAndView projectListPage(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("projectList");
		mav.addObject("projectList", projectService.listProject());
		return mav;
	}
	@RequestMapping(value = "/project/create")
	public String projectCreatePage(){
		return "projectCreate";
	}
	@RequestMapping(value = "/project/doCreate", method=RequestMethod.POST)
	public String createProject(
			HttpServletRequest request,
			ProjectInfo projectInfo, 
			@RequestParam("businessEmployeeId") String businessEmployeeId){
		projectInfo.setProjectCreateTime(new Date());
		ProjectStatus projectStatus = new ProjectStatus(
					ProjectStatus.ProjectStep.PROJECT_INPUT,
					ProjectStatus.StepStatus.CREATE_CONTRACT_REVIEW);
		projectInfo.setProjectStatus(projectStatus.toString());
		EmployeeInfo businessEmployee = employeeService.getEmployeeByEmployeeId(businessEmployeeId);
		projectInfo.setEmployeeInfoByBusinessEmployeeId(businessEmployee);
		projectInfo = projectService.createProject(projectInfo);
		request.getSession().setAttribute("CURRENT_PROJECT_INFO", projectInfo);
		return "forward:/contractReview/create";
	}
	@RequestMapping(value = "/project/doAssign", method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> assignProject(
			@RequestParam("employeeId") int employeeId,
			@RequestParam("taskId") int taskId){
		Map<String, Object> result = new HashMap<String, Object>();
		TaskInfo taskInfo = taskService.getTaskById(taskId);
		projectService.assignProject(taskInfo.getProjectInfo().getProjectId(), employeeId);
		taskService.finishTask(taskId);
		result.put("result", "success");
		return result;
	}
	@RequestMapping(value = "/project/edit/{projectId}")
	public ModelAndView projectEditPage(@PathVariable("projectId") String projectId){
		ModelAndView mav = new ModelAndView();
		ProjectInfo projectInfo = projectService.getProjectByProjectId(projectId);
		mav.setViewName("projectEdit");
		mav.addObject("project", projectInfo);
		return mav;
	}
	@RequestMapping(value = "/project/doEdit", method=RequestMethod.POST)
	public String editProject(ProjectInfo projectInfo){
		projectService.editProject(projectInfo);
		return "redirect:/project/list";
	}
	@RequestMapping(value = "/contractReview/create")
	public String contractReviewCreatePage(){
		return "contractReview";
	}
	@RequestMapping(value = "/contractReview/doCreate", method=RequestMethod.POST)
	public String createContractReview(
			HttpServletRequest request,
			ContractReviewForm contractReviewForm){
		ProjectInfo projectInfo =  (ProjectInfo)request.getSession().getAttribute("CURRENT_PROJECT_INFO");
		projectService.createContractReview(projectInfo.getProjectId(), contractReviewForm);
		return "redirect:/project/list";
	}
	@RequestMapping(value = "/contractReview/doSign", method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> signContractReview(
			@RequestParam("taskId") int taskId){
		taskService.finishTask(taskId);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("result", "success");
		return result;
	}
	@RequestMapping(value = "/workTask/create")
	public String workTaskCreatePage(
			HttpServletRequest request,
			@RequestParam("taskId") int taskId){
		TaskInfo taskInfo = taskService.getTaskById(taskId);
		ProjectInfo projectInfo = taskInfo.getProjectInfo();
		request.getSession().setAttribute("CURRENT_PROJECT_INFO", projectInfo);
		request.getSession().setAttribute("CURRENT_TASK_ID", taskId);
		return "workTask";
	}
	@RequestMapping(value = "/workTask/doCreate", method=RequestMethod.POST)
	public String createWorkTask(
			HttpServletRequest request,
			WorkTaskForm workTaskForm){
		ProjectInfo projectInfo =  (ProjectInfo)request.getSession().getAttribute("CURRENT_PROJECT_INFO");
		int taskId = (int)request.getSession().getAttribute("CURRENT_TASK_ID");
		projectService.createWorkTask(projectInfo.getProjectId(), workTaskForm);
		taskService.finishTask(taskId);
		return "redirect:/home/list";
	}
	@RequestMapping(value = "/consumerResource/create")
	public String consumerResourceCreatePage(
			HttpServletRequest request,
			@RequestParam("taskId") int taskId){
		TaskInfo taskInfo = taskService.getTaskById(taskId);
		ProjectInfo projectInfo = taskInfo.getProjectInfo();
		request.getSession().setAttribute("CURRENT_PROJECT_INFO", projectInfo);
		request.getSession().setAttribute("CURRENT_TASK_ID", taskId);
		return "consumerResource";
	}
	@RequestMapping(value = "/consumerResource/doCreate", method=RequestMethod.POST)
	public String createConsumerResource(
			HttpServletRequest request,
			ConsumerResourceForm consumerResourceForm){
		ProjectInfo projectInfo =  (ProjectInfo)request.getSession().getAttribute("CURRENT_PROJECT_INFO");
		int taskId = (int)request.getSession().getAttribute("CURRENT_TASK_ID");
		projectService.createConsumerResource(projectInfo.getProjectId(), consumerResourceForm);
		taskService.finishTask(taskId);
		return "redirect:/home/list";
	}
	@RequestMapping(value = "/fieldSurvey/create")
	public String fieldSurveyCreatePage(
			HttpServletRequest request,
			@RequestParam("taskId") int taskId){
		TaskInfo taskInfo = taskService.getTaskById(taskId);
		ProjectInfo projectInfo = taskInfo.getProjectInfo();
		request.getSession().setAttribute("CURRENT_PROJECT_INFO", projectInfo);
		request.getSession().setAttribute("CURRENT_TASK_ID", taskId);
		return "fieldSurvey";
	}
	@RequestMapping(value = "/fieldSurvey/doCreate")
	public String createFieldSurvey(){
		return "redirect:/home/list";
	}
	@RequestMapping(value = "/samplePlan/create")
	public String samplePlanCreatePage(){
		return "samplePlan";
	}
	@RequestMapping(value = "/samplePlan/doCreate")
	public String createSamplePlan(){
		return "redirect:/home/list";
	}
	@RequestMapping(value = "/evaluatePlanReview/create")
	public String evaluatePlanReviewCreatePage(){
		return "evaluatePlanReview";
	}
	@RequestMapping(value = "/evaluatePlanReview/doCreate")
	public String createEvaluatePlanReview(){
		return "redirect:/home/list";
	}
	@RequestMapping(value = "/detectionNotice/create")
	public String detectionNoticeCreatePage(){
		return "detectionNotice";
	}
	@RequestMapping(value = "/detectionNotice/doCreate")
	public String createDetectionNotice(){
		return "redirect:/home/list";
	}
}

package edu.tongji.anliantest.utils;

public enum TaskType {
	SIGN_CONTRACT_REVIEW("合同评审记录签字"),
	CREATE_WORK_TASK("创建工作任务单"),ASSIGN_PROJECT_EMPLOYEE("指定项目负责人"),
	CREATE_CONSUMER_RESOURCE("创建客户资料登记单"),CREATE_FIELD_SURVEY("创建现场调查记录"),
	CREATE_EVALUATE_PLAN_REVIEW("创建评价方案审核记录"),CREATE_DETECTION_NOTICE("创建检测通知单");
	private String taskName;
	private TaskType(String taskName){
		this.taskName = taskName;
	}
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public String toString(){
		return taskName;
	}
}

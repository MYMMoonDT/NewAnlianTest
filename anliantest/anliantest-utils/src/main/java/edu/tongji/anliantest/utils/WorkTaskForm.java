package edu.tongji.anliantest.utils;

public class WorkTaskForm {
	public final static String WORK_TASK_TABLE_NUM = "ALJC/JL32-01";
	
	public enum TableType{
		PREVIEW_EVAL("预评"),CONTROL_EVAL("控评");
		private String tableType;
		private TableType(String tableType){
			this.tableType = tableType;
		}
		public String toString(){
			return tableType;
		}
	}
	
	private int taskIssuedEmployeeId;
	private String evaluateWorkContent;
	private String evaluateWorkTimeLimit;
	private String detectWorkContent;
	private String detectWorkTimeLimit;
	private String qualityWorkContent;
	private String qualityWorkTimeLimit;
	private String adminWorkContent;
	private String adminWorkTimeLimit;
	
	public int getTaskIssuedEmployeeId() {
		return taskIssuedEmployeeId;
	}
	public void setTaskIssuedEmployeeId(int taskIssuedEmployeeId) {
		this.taskIssuedEmployeeId = taskIssuedEmployeeId;
	}
	public String getEvaluateWorkContent() {
		return evaluateWorkContent;
	}
	public void setEvaluateWorkContent(String evaluateWorkContent) {
		this.evaluateWorkContent = evaluateWorkContent;
	}
	public String getEvaluateWorkTimeLimit() {
		return evaluateWorkTimeLimit;
	}
	public void setEvaluateWorkTimeLimit(String evaluateWorkTimeLimit) {
		this.evaluateWorkTimeLimit = evaluateWorkTimeLimit;
	}
	public String getDetectWorkContent() {
		return detectWorkContent;
	}
	public void setDetectWorkContent(String detectWorkContent) {
		this.detectWorkContent = detectWorkContent;
	}
	public String getDetectWorkTimeLimit() {
		return detectWorkTimeLimit;
	}
	public void setDetectWorkTimeLimit(String detectWorkTimeLimit) {
		this.detectWorkTimeLimit = detectWorkTimeLimit;
	}
	public String getQualityWorkContent() {
		return qualityWorkContent;
	}
	public void setQualityWorkContent(String qualityWorkContent) {
		this.qualityWorkContent = qualityWorkContent;
	}
	public String getQualityWorkTimeLimit() {
		return qualityWorkTimeLimit;
	}
	public void setQualityWorkTimeLimit(String qualityWorkTimeLimit) {
		this.qualityWorkTimeLimit = qualityWorkTimeLimit;
	}
	public String getAdminWorkContent() {
		return adminWorkContent;
	}
	public void setAdminWorkContent(String adminWorkContent) {
		this.adminWorkContent = adminWorkContent;
	}
	public String getAdminWorkTimeLimit() {
		return adminWorkTimeLimit;
	}
	public void setAdminWorkTimeLimit(String adminWorkTimeLimit) {
		this.adminWorkTimeLimit = adminWorkTimeLimit;
	}
	public static String getWorkTaskTableNum() {
		return WORK_TASK_TABLE_NUM;
	}
}

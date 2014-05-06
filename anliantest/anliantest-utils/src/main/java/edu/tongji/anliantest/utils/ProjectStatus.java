package edu.tongji.anliantest.utils;

public class ProjectStatus {
	public enum ProjectStep {
		PROJECT_INPUT("1.项目录入"),
		PROJECT_ISSUE("2.项目下达"),
		PROJECT_PREPARE("3.项目前期准备");
		
		private String stepName;
		
		private ProjectStep(String stepName){
			this.setStepName(stepName);
		}

		public String getStepName() {
			return stepName;
		}

		public void setStepName(String stepName) {
			this.stepName = stepName;
		}
		
	}
	public enum StepStatus {
		START("开始"),
		COMPLETED("完成"),
		UNSIGNED("未签字"),
		SIGNED("已签字");
		
		private String statusName;
		
		private StepStatus(String statusName){
			this.setStatusName(statusName);
		}

		public String getStatusName() {
			return statusName;
		}

		public void setStatusName(String statusName) {
			this.statusName = statusName;
		}
	}
	private ProjectStep currentStep;
	private StepStatus currentStepStatus;
	
	public ProjectStatus(ProjectStep currentStep, StepStatus currentStepStatus){
		this.currentStep = currentStep;
		this.currentStepStatus = currentStepStatus;
	}
	
	public ProjectStatus(String statusStr){
		if(statusStr != null && statusStr.split("-").length == 2){
			String[] statusArray = statusStr.split("-");
			this.currentStep = ProjectStep.valueOf(statusArray[0]);
			this.currentStepStatus = StepStatus.valueOf(statusArray[1]);
		}
	}
	
	public StepStatus getCurrentStepStatus() {
		return currentStepStatus;
	}
	public void setCurrentStepStatus(StepStatus currentStepStatus) {
		this.currentStepStatus = currentStepStatus;
	}

	public ProjectStep getCurrentStep() {
		return currentStep;
	}

	public void setCurrentStep(ProjectStep currentStep) {
		this.currentStep = currentStep;
	}
	
	@Override
	public String toString(){
		return currentStep.getStepName() + "-" + currentStepStatus.getStatusName();
	}
}

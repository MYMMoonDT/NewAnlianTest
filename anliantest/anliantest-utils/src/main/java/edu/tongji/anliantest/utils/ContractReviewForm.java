package edu.tongji.anliantest.utils;

public class ContractReviewForm {
	
	public final static String CONTRACT_REVIEW_TABLE_NUM = "ALJC/JL07-03";
	public enum Status {
		signed,unsigned
	}
	
	public enum ItemStatus {
		signed,unsigned
	}
	
	private String evaluateReviewContent;
	private String evaluateReviewComment;
	private String detectReviewContent;
	private String detectReviewComment;
	private String adminReviewContent;
	private String adminReviewComment;
	private String qualityReviewContent;
	private String qualityReviewComment;
	private String generalManagerReviewContent;
	private String generalManagerReviewComment;
	public String getEvaluateReviewContent() {
		return evaluateReviewContent;
	}
	public void setEvaluateReviewContent(String evaluateReviewContent) {
		this.evaluateReviewContent = evaluateReviewContent;
	}
	public String getEvaluateReviewComment() {
		return evaluateReviewComment;
	}
	public void setEvaluateReviewComment(String evaluateReviewComment) {
		this.evaluateReviewComment = evaluateReviewComment;
	}
	public String getDetectReviewContent() {
		return detectReviewContent;
	}
	public void setDetectReviewContent(String detectReviewContent) {
		this.detectReviewContent = detectReviewContent;
	}
	public String getDetectReviewComment() {
		return detectReviewComment;
	}
	public void setDetectReviewComment(String detectReviewComment) {
		this.detectReviewComment = detectReviewComment;
	}
	public String getQualityReviewContent() {
		return qualityReviewContent;
	}
	public void setQualityReviewContent(String qualityReviewContent) {
		this.qualityReviewContent = qualityReviewContent;
	}
	public String getQualityReviewComment() {
		return qualityReviewComment;
	}
	public void setQualityReviewComment(String qualityReviewComment) {
		this.qualityReviewComment = qualityReviewComment;
	}
	public String getGeneralManagerReviewContent() {
		return generalManagerReviewContent;
	}
	public void setGeneralManagerReviewContent(String generalManagerReviewContent) {
		this.generalManagerReviewContent = generalManagerReviewContent;
	}
	public String getGeneralManagerReviewComment() {
		return generalManagerReviewComment;
	}
	public void setGeneralManagerReviewComment(String generalManagerReviewComment) {
		this.generalManagerReviewComment = generalManagerReviewComment;
	}
	public String getAdminReviewContent() {
		return adminReviewContent;
	}
	public void setAdminReviewContent(String adminReviewContent) {
		this.adminReviewContent = adminReviewContent;
	}
	public String getAdminReviewComment() {
		return adminReviewComment;
	}
	public void setAdminReviewComment(String adminReviewComment) {
		this.adminReviewComment = adminReviewComment;
	}
}

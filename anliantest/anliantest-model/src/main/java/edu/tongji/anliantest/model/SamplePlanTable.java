package edu.tongji.anliantest.model;

// Generated 2014-9-30 13:52:24 by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * SamplePlanTable generated by hbm2java
 */
public class SamplePlanTable implements java.io.Serializable {

	private Integer tableId;
	private EmployeeInfo employeeInfoByPlanReviewEmployeeId;
	private EmployeeInfo employeeInfoByPlanWriteEmployeeId;
	private ProjectInfo projectInfo;
	private String tableNum;
	private Date samplePlanTimeStart;
	private Date samplePlanTimeEnd;
	private Date planWriteTime;
	private Date planReviewTime;
	private Set samplePlanItems = new HashSet(0);

	public SamplePlanTable() {
	}

	public SamplePlanTable(EmployeeInfo employeeInfoByPlanReviewEmployeeId,
			EmployeeInfo employeeInfoByPlanWriteEmployeeId,
			ProjectInfo projectInfo, String tableNum, Date samplePlanTimeStart,
			Date samplePlanTimeEnd, Date planWriteTime, Date planReviewTime,
			Set samplePlanItems) {
		this.employeeInfoByPlanReviewEmployeeId = employeeInfoByPlanReviewEmployeeId;
		this.employeeInfoByPlanWriteEmployeeId = employeeInfoByPlanWriteEmployeeId;
		this.projectInfo = projectInfo;
		this.tableNum = tableNum;
		this.samplePlanTimeStart = samplePlanTimeStart;
		this.samplePlanTimeEnd = samplePlanTimeEnd;
		this.planWriteTime = planWriteTime;
		this.planReviewTime = planReviewTime;
		this.samplePlanItems = samplePlanItems;
	}

	public Integer getTableId() {
		return this.tableId;
	}

	public void setTableId(Integer tableId) {
		this.tableId = tableId;
	}

	public EmployeeInfo getEmployeeInfoByPlanReviewEmployeeId() {
		return this.employeeInfoByPlanReviewEmployeeId;
	}

	public void setEmployeeInfoByPlanReviewEmployeeId(
			EmployeeInfo employeeInfoByPlanReviewEmployeeId) {
		this.employeeInfoByPlanReviewEmployeeId = employeeInfoByPlanReviewEmployeeId;
	}

	public EmployeeInfo getEmployeeInfoByPlanWriteEmployeeId() {
		return this.employeeInfoByPlanWriteEmployeeId;
	}

	public void setEmployeeInfoByPlanWriteEmployeeId(
			EmployeeInfo employeeInfoByPlanWriteEmployeeId) {
		this.employeeInfoByPlanWriteEmployeeId = employeeInfoByPlanWriteEmployeeId;
	}

	public ProjectInfo getProjectInfo() {
		return this.projectInfo;
	}

	public void setProjectInfo(ProjectInfo projectInfo) {
		this.projectInfo = projectInfo;
	}

	public String getTableNum() {
		return this.tableNum;
	}

	public void setTableNum(String tableNum) {
		this.tableNum = tableNum;
	}

	public Date getSamplePlanTimeStart() {
		return this.samplePlanTimeStart;
	}

	public void setSamplePlanTimeStart(Date samplePlanTimeStart) {
		this.samplePlanTimeStart = samplePlanTimeStart;
	}

	public Date getSamplePlanTimeEnd() {
		return this.samplePlanTimeEnd;
	}

	public void setSamplePlanTimeEnd(Date samplePlanTimeEnd) {
		this.samplePlanTimeEnd = samplePlanTimeEnd;
	}

	public Date getPlanWriteTime() {
		return this.planWriteTime;
	}

	public void setPlanWriteTime(Date planWriteTime) {
		this.planWriteTime = planWriteTime;
	}

	public Date getPlanReviewTime() {
		return this.planReviewTime;
	}

	public void setPlanReviewTime(Date planReviewTime) {
		this.planReviewTime = planReviewTime;
	}

	public Set getSamplePlanItems() {
		return this.samplePlanItems;
	}

	public void setSamplePlanItems(Set samplePlanItems) {
		this.samplePlanItems = samplePlanItems;
	}

}

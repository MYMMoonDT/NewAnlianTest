package edu.tongji.anliantest.model;

// Generated 2014-5-5 12:47:38 by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * SamplePlanTable generated by hbm2java
 */
@Entity
@Table(name = "sample_plan_table", catalog = "anliantest")
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
	private Set<SamplePlanItem> samplePlanItems = new HashSet<SamplePlanItem>(0);

	public SamplePlanTable() {
	}

	public SamplePlanTable(EmployeeInfo employeeInfoByPlanReviewEmployeeId,
			EmployeeInfo employeeInfoByPlanWriteEmployeeId,
			ProjectInfo projectInfo, String tableNum, Date samplePlanTimeStart,
			Date samplePlanTimeEnd, Date planWriteTime, Date planReviewTime,
			Set<SamplePlanItem> samplePlanItems) {
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

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "table_id", unique = true, nullable = false)
	public Integer getTableId() {
		return this.tableId;
	}

	public void setTableId(Integer tableId) {
		this.tableId = tableId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "plan_review_employee_id")
	public EmployeeInfo getEmployeeInfoByPlanReviewEmployeeId() {
		return this.employeeInfoByPlanReviewEmployeeId;
	}

	public void setEmployeeInfoByPlanReviewEmployeeId(
			EmployeeInfo employeeInfoByPlanReviewEmployeeId) {
		this.employeeInfoByPlanReviewEmployeeId = employeeInfoByPlanReviewEmployeeId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "plan_write_employee_id")
	public EmployeeInfo getEmployeeInfoByPlanWriteEmployeeId() {
		return this.employeeInfoByPlanWriteEmployeeId;
	}

	public void setEmployeeInfoByPlanWriteEmployeeId(
			EmployeeInfo employeeInfoByPlanWriteEmployeeId) {
		this.employeeInfoByPlanWriteEmployeeId = employeeInfoByPlanWriteEmployeeId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "project_id")
	public ProjectInfo getProjectInfo() {
		return this.projectInfo;
	}

	public void setProjectInfo(ProjectInfo projectInfo) {
		this.projectInfo = projectInfo;
	}

	@Column(name = "table_num", length = 13)
	public String getTableNum() {
		return this.tableNum;
	}

	public void setTableNum(String tableNum) {
		this.tableNum = tableNum;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "sample_plan_time_start", length = 0)
	public Date getSamplePlanTimeStart() {
		return this.samplePlanTimeStart;
	}

	public void setSamplePlanTimeStart(Date samplePlanTimeStart) {
		this.samplePlanTimeStart = samplePlanTimeStart;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "sample_plan_time_end", length = 0)
	public Date getSamplePlanTimeEnd() {
		return this.samplePlanTimeEnd;
	}

	public void setSamplePlanTimeEnd(Date samplePlanTimeEnd) {
		this.samplePlanTimeEnd = samplePlanTimeEnd;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "plan_write_time", length = 0)
	public Date getPlanWriteTime() {
		return this.planWriteTime;
	}

	public void setPlanWriteTime(Date planWriteTime) {
		this.planWriteTime = planWriteTime;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "plan_review_time", length = 0)
	public Date getPlanReviewTime() {
		return this.planReviewTime;
	}

	public void setPlanReviewTime(Date planReviewTime) {
		this.planReviewTime = planReviewTime;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "samplePlanTable")
	public Set<SamplePlanItem> getSamplePlanItems() {
		return this.samplePlanItems;
	}

	public void setSamplePlanItems(Set<SamplePlanItem> samplePlanItems) {
		this.samplePlanItems = samplePlanItems;
	}

}

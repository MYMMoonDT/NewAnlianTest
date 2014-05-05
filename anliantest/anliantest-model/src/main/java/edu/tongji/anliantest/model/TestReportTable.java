package edu.tongji.anliantest.model;

// Generated 2014-5-5 9:28:36 by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * TestReportTable generated by hbm2java
 */
@Entity
@Table(name = "test_report_table", catalog = "anliantest")
public class TestReportTable implements java.io.Serializable {

	private int tableId;
	private EmployeeInfo employeeInfoBySignerId;
	private ProjectInfo projectInfo;
	private EmployeeInfo employeeInfoByReviewerId;
	private EmployeeInfo employeeInfoByPreparerId;
	private String testReportNum;
	private String sampleName;
	private Integer sampleNum;
	private String sampleStatus;
	private String testProperty;
	private String testUnitName;
	private String testUnitAddress;
	private String entrustUnitName;
	private Date sampleTimeStart;
	private Date sampleTimeEnd;
	private Date receiveTimeStart;
	private Date receiveTimeEnd;
	private Date testTimeStart;
	private Date testTimeEnd;
	private Date reportTime;
	private Date tableTime;
	private Set<TestReportItem> testReportItems = new HashSet<TestReportItem>(0);

	public TestReportTable() {
	}

	public TestReportTable(int tableId) {
		this.tableId = tableId;
	}

	public TestReportTable(int tableId, EmployeeInfo employeeInfoBySignerId,
			ProjectInfo projectInfo, EmployeeInfo employeeInfoByReviewerId,
			EmployeeInfo employeeInfoByPreparerId, String testReportNum,
			String sampleName, Integer sampleNum, String sampleStatus,
			String testProperty, String testUnitName, String testUnitAddress,
			String entrustUnitName, Date sampleTimeStart, Date sampleTimeEnd,
			Date receiveTimeStart, Date receiveTimeEnd, Date testTimeStart,
			Date testTimeEnd, Date reportTime, Date tableTime,
			Set<TestReportItem> testReportItems) {
		this.tableId = tableId;
		this.employeeInfoBySignerId = employeeInfoBySignerId;
		this.projectInfo = projectInfo;
		this.employeeInfoByReviewerId = employeeInfoByReviewerId;
		this.employeeInfoByPreparerId = employeeInfoByPreparerId;
		this.testReportNum = testReportNum;
		this.sampleName = sampleName;
		this.sampleNum = sampleNum;
		this.sampleStatus = sampleStatus;
		this.testProperty = testProperty;
		this.testUnitName = testUnitName;
		this.testUnitAddress = testUnitAddress;
		this.entrustUnitName = entrustUnitName;
		this.sampleTimeStart = sampleTimeStart;
		this.sampleTimeEnd = sampleTimeEnd;
		this.receiveTimeStart = receiveTimeStart;
		this.receiveTimeEnd = receiveTimeEnd;
		this.testTimeStart = testTimeStart;
		this.testTimeEnd = testTimeEnd;
		this.reportTime = reportTime;
		this.tableTime = tableTime;
		this.testReportItems = testReportItems;
	}

	@Id
	@Column(name = "table_id", unique = true, nullable = false)
	public int getTableId() {
		return this.tableId;
	}

	public void setTableId(int tableId) {
		this.tableId = tableId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "signer_id")
	public EmployeeInfo getEmployeeInfoBySignerId() {
		return this.employeeInfoBySignerId;
	}

	public void setEmployeeInfoBySignerId(EmployeeInfo employeeInfoBySignerId) {
		this.employeeInfoBySignerId = employeeInfoBySignerId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "project_id")
	public ProjectInfo getProjectInfo() {
		return this.projectInfo;
	}

	public void setProjectInfo(ProjectInfo projectInfo) {
		this.projectInfo = projectInfo;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "reviewer_id")
	public EmployeeInfo getEmployeeInfoByReviewerId() {
		return this.employeeInfoByReviewerId;
	}

	public void setEmployeeInfoByReviewerId(
			EmployeeInfo employeeInfoByReviewerId) {
		this.employeeInfoByReviewerId = employeeInfoByReviewerId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "preparer_id")
	public EmployeeInfo getEmployeeInfoByPreparerId() {
		return this.employeeInfoByPreparerId;
	}

	public void setEmployeeInfoByPreparerId(
			EmployeeInfo employeeInfoByPreparerId) {
		this.employeeInfoByPreparerId = employeeInfoByPreparerId;
	}

	@Column(name = "test_report_num", length = 100)
	public String getTestReportNum() {
		return this.testReportNum;
	}

	public void setTestReportNum(String testReportNum) {
		this.testReportNum = testReportNum;
	}

	@Column(name = "sample_name", length = 100)
	public String getSampleName() {
		return this.sampleName;
	}

	public void setSampleName(String sampleName) {
		this.sampleName = sampleName;
	}

	@Column(name = "sample_num")
	public Integer getSampleNum() {
		return this.sampleNum;
	}

	public void setSampleNum(Integer sampleNum) {
		this.sampleNum = sampleNum;
	}

	@Column(name = "sample_status")
	public String getSampleStatus() {
		return this.sampleStatus;
	}

	public void setSampleStatus(String sampleStatus) {
		this.sampleStatus = sampleStatus;
	}

	@Column(name = "test_property", length = 100)
	public String getTestProperty() {
		return this.testProperty;
	}

	public void setTestProperty(String testProperty) {
		this.testProperty = testProperty;
	}

	@Column(name = "test_unit_name")
	public String getTestUnitName() {
		return this.testUnitName;
	}

	public void setTestUnitName(String testUnitName) {
		this.testUnitName = testUnitName;
	}

	@Column(name = "test_unit_address")
	public String getTestUnitAddress() {
		return this.testUnitAddress;
	}

	public void setTestUnitAddress(String testUnitAddress) {
		this.testUnitAddress = testUnitAddress;
	}

	@Column(name = "entrust_unit_name")
	public String getEntrustUnitName() {
		return this.entrustUnitName;
	}

	public void setEntrustUnitName(String entrustUnitName) {
		this.entrustUnitName = entrustUnitName;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "sample_time_start", length = 0)
	public Date getSampleTimeStart() {
		return this.sampleTimeStart;
	}

	public void setSampleTimeStart(Date sampleTimeStart) {
		this.sampleTimeStart = sampleTimeStart;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "sample_time_end", length = 0)
	public Date getSampleTimeEnd() {
		return this.sampleTimeEnd;
	}

	public void setSampleTimeEnd(Date sampleTimeEnd) {
		this.sampleTimeEnd = sampleTimeEnd;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "receive_time_start", length = 0)
	public Date getReceiveTimeStart() {
		return this.receiveTimeStart;
	}

	public void setReceiveTimeStart(Date receiveTimeStart) {
		this.receiveTimeStart = receiveTimeStart;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "receive_time_end", length = 0)
	public Date getReceiveTimeEnd() {
		return this.receiveTimeEnd;
	}

	public void setReceiveTimeEnd(Date receiveTimeEnd) {
		this.receiveTimeEnd = receiveTimeEnd;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "test_time_start", length = 0)
	public Date getTestTimeStart() {
		return this.testTimeStart;
	}

	public void setTestTimeStart(Date testTimeStart) {
		this.testTimeStart = testTimeStart;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "test_time_end", length = 0)
	public Date getTestTimeEnd() {
		return this.testTimeEnd;
	}

	public void setTestTimeEnd(Date testTimeEnd) {
		this.testTimeEnd = testTimeEnd;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "report_time", length = 0)
	public Date getReportTime() {
		return this.reportTime;
	}

	public void setReportTime(Date reportTime) {
		this.reportTime = reportTime;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "table_time", length = 0)
	public Date getTableTime() {
		return this.tableTime;
	}

	public void setTableTime(Date tableTime) {
		this.tableTime = tableTime;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "testReportTable")
	public Set<TestReportItem> getTestReportItems() {
		return this.testReportItems;
	}

	public void setTestReportItems(Set<TestReportItem> testReportItems) {
		this.testReportItems = testReportItems;
	}

}

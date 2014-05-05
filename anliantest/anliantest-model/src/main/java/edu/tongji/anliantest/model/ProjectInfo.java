package edu.tongji.anliantest.model;

// Generated 2014-5-5 9:28:36 by Hibernate Tools 3.4.0.CR1

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
import javax.persistence.UniqueConstraint;

/**
 * ProjectInfo generated by hbm2java
 */
@Entity
@Table(name = "project_info", catalog = "anliantest", uniqueConstraints = @UniqueConstraint(columnNames = "project_num"))
public class ProjectInfo implements java.io.Serializable {

	private Integer projectId;
	private EmployeeInfo employeeInfoByProjectEmployeeId;
	private EmployeeInfo employeeInfoByBusinessEmployeeId;
	private String projectNum;
	private String projectName;
	private String projectType;
	private Date projectCreateTime;
	private String projectStatus;
	private String companyName;
	private String companyAddress;
	private String contactPerson;
	private String contactTel;
	private Integer contractAmount;
	private Set<SamplePlanTable> samplePlanTables = new HashSet<SamplePlanTable>(
			0);
	private Set<ContractReviewRecordTable> contractReviewRecordTables = new HashSet<ContractReviewRecordTable>(
			0);
	private Set<TestDataResultTable> testDataResultTables = new HashSet<TestDataResultTable>(
			0);
	private Set<TestDataProcessTable> testDataProcessTables = new HashSet<TestDataProcessTable>(
			0);
	private Set<TestReportTable> testReportTables = new HashSet<TestReportTable>(
			0);

	public ProjectInfo() {
	}

	public ProjectInfo(EmployeeInfo employeeInfoByProjectEmployeeId,
			EmployeeInfo employeeInfoByBusinessEmployeeId, String projectNum,
			String projectName, String projectType, Date projectCreateTime,
			String projectStatus, String companyName, String companyAddress,
			String contactPerson, String contactTel, Integer contractAmount,
			Set<SamplePlanTable> samplePlanTables,
			Set<ContractReviewRecordTable> contractReviewRecordTables,
			Set<TestDataResultTable> testDataResultTables,
			Set<TestDataProcessTable> testDataProcessTables,
			Set<TestReportTable> testReportTables) {
		this.employeeInfoByProjectEmployeeId = employeeInfoByProjectEmployeeId;
		this.employeeInfoByBusinessEmployeeId = employeeInfoByBusinessEmployeeId;
		this.projectNum = projectNum;
		this.projectName = projectName;
		this.projectType = projectType;
		this.projectCreateTime = projectCreateTime;
		this.projectStatus = projectStatus;
		this.companyName = companyName;
		this.companyAddress = companyAddress;
		this.contactPerson = contactPerson;
		this.contactTel = contactTel;
		this.contractAmount = contractAmount;
		this.samplePlanTables = samplePlanTables;
		this.contractReviewRecordTables = contractReviewRecordTables;
		this.testDataResultTables = testDataResultTables;
		this.testDataProcessTables = testDataProcessTables;
		this.testReportTables = testReportTables;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "project_id", unique = true, nullable = false)
	public Integer getProjectId() {
		return this.projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "project_employee_id")
	public EmployeeInfo getEmployeeInfoByProjectEmployeeId() {
		return this.employeeInfoByProjectEmployeeId;
	}

	public void setEmployeeInfoByProjectEmployeeId(
			EmployeeInfo employeeInfoByProjectEmployeeId) {
		this.employeeInfoByProjectEmployeeId = employeeInfoByProjectEmployeeId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "business_employee_id")
	public EmployeeInfo getEmployeeInfoByBusinessEmployeeId() {
		return this.employeeInfoByBusinessEmployeeId;
	}

	public void setEmployeeInfoByBusinessEmployeeId(
			EmployeeInfo employeeInfoByBusinessEmployeeId) {
		this.employeeInfoByBusinessEmployeeId = employeeInfoByBusinessEmployeeId;
	}

	@Column(name = "project_num", unique = true, length = 50)
	public String getProjectNum() {
		return this.projectNum;
	}

	public void setProjectNum(String projectNum) {
		this.projectNum = projectNum;
	}

	@Column(name = "project_name", length = 100)
	public String getProjectName() {
		return this.projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	@Column(name = "project_type", length = 16)
	public String getProjectType() {
		return this.projectType;
	}

	public void setProjectType(String projectType) {
		this.projectType = projectType;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "project_create_time", length = 0)
	public Date getProjectCreateTime() {
		return this.projectCreateTime;
	}

	public void setProjectCreateTime(Date projectCreateTime) {
		this.projectCreateTime = projectCreateTime;
	}

	@Column(name = "project_status", length = 100)
	public String getProjectStatus() {
		return this.projectStatus;
	}

	public void setProjectStatus(String projectStatus) {
		this.projectStatus = projectStatus;
	}

	@Column(name = "company_name", length = 100)
	public String getCompanyName() {
		return this.companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	@Column(name = "company_address")
	public String getCompanyAddress() {
		return this.companyAddress;
	}

	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}

	@Column(name = "contact_person", length = 50)
	public String getContactPerson() {
		return this.contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	@Column(name = "contact_tel", length = 100)
	public String getContactTel() {
		return this.contactTel;
	}

	public void setContactTel(String contactTel) {
		this.contactTel = contactTel;
	}

	@Column(name = "contract_amount")
	public Integer getContractAmount() {
		return this.contractAmount;
	}

	public void setContractAmount(Integer contractAmount) {
		this.contractAmount = contractAmount;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "projectInfo")
	public Set<SamplePlanTable> getSamplePlanTables() {
		return this.samplePlanTables;
	}

	public void setSamplePlanTables(Set<SamplePlanTable> samplePlanTables) {
		this.samplePlanTables = samplePlanTables;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "projectInfo")
	public Set<ContractReviewRecordTable> getContractReviewRecordTables() {
		return this.contractReviewRecordTables;
	}

	public void setContractReviewRecordTables(
			Set<ContractReviewRecordTable> contractReviewRecordTables) {
		this.contractReviewRecordTables = contractReviewRecordTables;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "projectInfo")
	public Set<TestDataResultTable> getTestDataResultTables() {
		return this.testDataResultTables;
	}

	public void setTestDataResultTables(
			Set<TestDataResultTable> testDataResultTables) {
		this.testDataResultTables = testDataResultTables;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "projectInfo")
	public Set<TestDataProcessTable> getTestDataProcessTables() {
		return this.testDataProcessTables;
	}

	public void setTestDataProcessTables(
			Set<TestDataProcessTable> testDataProcessTables) {
		this.testDataProcessTables = testDataProcessTables;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "projectInfo")
	public Set<TestReportTable> getTestReportTables() {
		return this.testReportTables;
	}

	public void setTestReportTables(Set<TestReportTable> testReportTables) {
		this.testReportTables = testReportTables;
	}

}

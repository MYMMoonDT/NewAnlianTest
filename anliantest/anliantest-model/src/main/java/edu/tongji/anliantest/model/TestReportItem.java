package edu.tongji.anliantest.model;

// Generated 2014-5-6 15:31:57 by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * TestReportItem generated by hbm2java
 */
@Entity
@Table(name = "test_report_item", catalog = "anliantest")
public class TestReportItem implements java.io.Serializable {

	private int itemId;
	private TestReportTable testReportTable;
	private HarmfulSubstanceNationalStandardTable harmfulSubstanceNationalStandardTable;
	private String testWorkshopJob;
	private String substanceDetailedName;
	private Date testTime;
	private Integer testSampleId;
	private String testSampleNum;
	private BigDecimal testResult;
	private Integer testResultScale;
	private String testResultType;
	private BigDecimal testTouchTime;
	private Integer testTouchTimeScale;
	private Integer testCollectTime;

	public TestReportItem() {
	}

	public TestReportItem(int itemId) {
		this.itemId = itemId;
	}

	public TestReportItem(
			int itemId,
			TestReportTable testReportTable,
			HarmfulSubstanceNationalStandardTable harmfulSubstanceNationalStandardTable,
			String testWorkshopJob, String substanceDetailedName,
			Date testTime, Integer testSampleId, String testSampleNum,
			BigDecimal testResult, Integer testResultScale,
			String testResultType, BigDecimal testTouchTime,
			Integer testTouchTimeScale, Integer testCollectTime) {
		this.itemId = itemId;
		this.testReportTable = testReportTable;
		this.harmfulSubstanceNationalStandardTable = harmfulSubstanceNationalStandardTable;
		this.testWorkshopJob = testWorkshopJob;
		this.substanceDetailedName = substanceDetailedName;
		this.testTime = testTime;
		this.testSampleId = testSampleId;
		this.testSampleNum = testSampleNum;
		this.testResult = testResult;
		this.testResultScale = testResultScale;
		this.testResultType = testResultType;
		this.testTouchTime = testTouchTime;
		this.testTouchTimeScale = testTouchTimeScale;
		this.testCollectTime = testCollectTime;
	}

	@Id
	@Column(name = "item_id", unique = true, nullable = false)
	public int getItemId() {
		return this.itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "table_id")
	public TestReportTable getTestReportTable() {
		return this.testReportTable;
	}

	public void setTestReportTable(TestReportTable testReportTable) {
		this.testReportTable = testReportTable;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "test_substance_id")
	public HarmfulSubstanceNationalStandardTable getHarmfulSubstanceNationalStandardTable() {
		return this.harmfulSubstanceNationalStandardTable;
	}

	public void setHarmfulSubstanceNationalStandardTable(
			HarmfulSubstanceNationalStandardTable harmfulSubstanceNationalStandardTable) {
		this.harmfulSubstanceNationalStandardTable = harmfulSubstanceNationalStandardTable;
	}

	@Column(name = "test_workshop_job", length = 100)
	public String getTestWorkshopJob() {
		return this.testWorkshopJob;
	}

	public void setTestWorkshopJob(String testWorkshopJob) {
		this.testWorkshopJob = testWorkshopJob;
	}

	@Column(name = "substance_detailed_name", length = 45)
	public String getSubstanceDetailedName() {
		return this.substanceDetailedName;
	}

	public void setSubstanceDetailedName(String substanceDetailedName) {
		this.substanceDetailedName = substanceDetailedName;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "test_time", length = 0)
	public Date getTestTime() {
		return this.testTime;
	}

	public void setTestTime(Date testTime) {
		this.testTime = testTime;
	}

	@Column(name = "test_sample_id")
	public Integer getTestSampleId() {
		return this.testSampleId;
	}

	public void setTestSampleId(Integer testSampleId) {
		this.testSampleId = testSampleId;
	}

	@Column(name = "test_sample_num", length = 100)
	public String getTestSampleNum() {
		return this.testSampleNum;
	}

	public void setTestSampleNum(String testSampleNum) {
		this.testSampleNum = testSampleNum;
	}

	@Column(name = "test_result", precision = 14, scale = 8)
	public BigDecimal getTestResult() {
		return this.testResult;
	}

	public void setTestResult(BigDecimal testResult) {
		this.testResult = testResult;
	}

	@Column(name = "test_result_scale")
	public Integer getTestResultScale() {
		return this.testResultScale;
	}

	public void setTestResultScale(Integer testResultScale) {
		this.testResultScale = testResultScale;
	}

	@Column(name = "test_result_type", length = 2)
	public String getTestResultType() {
		return this.testResultType;
	}

	public void setTestResultType(String testResultType) {
		this.testResultType = testResultType;
	}

	@Column(name = "test_touch_time", precision = 7, scale = 4)
	public BigDecimal getTestTouchTime() {
		return this.testTouchTime;
	}

	public void setTestTouchTime(BigDecimal testTouchTime) {
		this.testTouchTime = testTouchTime;
	}

	@Column(name = "test_touch_time_scale")
	public Integer getTestTouchTimeScale() {
		return this.testTouchTimeScale;
	}

	public void setTestTouchTimeScale(Integer testTouchTimeScale) {
		this.testTouchTimeScale = testTouchTimeScale;
	}

	@Column(name = "test_collect_time")
	public Integer getTestCollectTime() {
		return this.testCollectTime;
	}

	public void setTestCollectTime(Integer testCollectTime) {
		this.testCollectTime = testCollectTime;
	}

}

package edu.tongji.anliantest.model;

// Generated 2014-5-8 16:08:44 by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * ContractReviewRecordItem generated by hbm2java
 */
@Entity
@Table(name = "contract_review_record_item", catalog = "anliantest")
public class ContractReviewRecordItem implements java.io.Serializable {

	private Integer itemId;
	private DepartmentInfo departmentInfo;
	private ContractReviewRecordTable contractReviewRecordTable;
	private String reviewContent;
	private String reviewComment;
	private String itemStatus;
	private Date itemTime;

	public ContractReviewRecordItem() {
	}

	public ContractReviewRecordItem(DepartmentInfo departmentInfo,
			ContractReviewRecordTable contractReviewRecordTable,
			String reviewContent, String reviewComment, String itemStatus,
			Date itemTime) {
		this.departmentInfo = departmentInfo;
		this.contractReviewRecordTable = contractReviewRecordTable;
		this.reviewContent = reviewContent;
		this.reviewComment = reviewComment;
		this.itemStatus = itemStatus;
		this.itemTime = itemTime;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "item_id", unique = true, nullable = false)
	public Integer getItemId() {
		return this.itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "deparment_id")
	public DepartmentInfo getDepartmentInfo() {
		return this.departmentInfo;
	}

	public void setDepartmentInfo(DepartmentInfo departmentInfo) {
		this.departmentInfo = departmentInfo;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "table_id")
	public ContractReviewRecordTable getContractReviewRecordTable() {
		return this.contractReviewRecordTable;
	}

	public void setContractReviewRecordTable(
			ContractReviewRecordTable contractReviewRecordTable) {
		this.contractReviewRecordTable = contractReviewRecordTable;
	}

	@Column(name = "review_content", length = 65535)
	public String getReviewContent() {
		return this.reviewContent;
	}

	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}

	@Column(name = "review_comment", length = 65535)
	public String getReviewComment() {
		return this.reviewComment;
	}

	public void setReviewComment(String reviewComment) {
		this.reviewComment = reviewComment;
	}

	@Column(name = "item_status", length = 8)
	public String getItemStatus() {
		return this.itemStatus;
	}

	public void setItemStatus(String itemStatus) {
		this.itemStatus = itemStatus;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "item_time", length = 0)
	public Date getItemTime() {
		return this.itemTime;
	}

	public void setItemTime(Date itemTime) {
		this.itemTime = itemTime;
	}

}

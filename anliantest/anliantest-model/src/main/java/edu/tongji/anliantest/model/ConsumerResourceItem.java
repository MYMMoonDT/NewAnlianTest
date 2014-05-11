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
 * ConsumerResourceItem generated by hbm2java
 */
@Entity
@Table(name = "consumer_resource_item", catalog = "anliantest")
public class ConsumerResourceItem implements java.io.Serializable {

	private Integer itemId;
	private ConsumerResourceTable consumerResourceTable;
	private EmployeeInfo employeeInfoByResourceReceiverId;
	private EmployeeInfo employeeInfoByResourceReturnerId;
	private String resourceName;
	private Date submitTime;
	private Date returnTime;
	private Integer resourceQuantity;

	public ConsumerResourceItem() {
	}

	public ConsumerResourceItem(ConsumerResourceTable consumerResourceTable,
			EmployeeInfo employeeInfoByResourceReceiverId,
			EmployeeInfo employeeInfoByResourceReturnerId, String resourceName,
			Date submitTime, Date returnTime, Integer resourceQuantity) {
		this.consumerResourceTable = consumerResourceTable;
		this.employeeInfoByResourceReceiverId = employeeInfoByResourceReceiverId;
		this.employeeInfoByResourceReturnerId = employeeInfoByResourceReturnerId;
		this.resourceName = resourceName;
		this.submitTime = submitTime;
		this.returnTime = returnTime;
		this.resourceQuantity = resourceQuantity;
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
	@JoinColumn(name = "table_id")
	public ConsumerResourceTable getConsumerResourceTable() {
		return this.consumerResourceTable;
	}

	public void setConsumerResourceTable(
			ConsumerResourceTable consumerResourceTable) {
		this.consumerResourceTable = consumerResourceTable;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "resource_receiver_id")
	public EmployeeInfo getEmployeeInfoByResourceReceiverId() {
		return this.employeeInfoByResourceReceiverId;
	}

	public void setEmployeeInfoByResourceReceiverId(
			EmployeeInfo employeeInfoByResourceReceiverId) {
		this.employeeInfoByResourceReceiverId = employeeInfoByResourceReceiverId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "resource_returner_id")
	public EmployeeInfo getEmployeeInfoByResourceReturnerId() {
		return this.employeeInfoByResourceReturnerId;
	}

	public void setEmployeeInfoByResourceReturnerId(
			EmployeeInfo employeeInfoByResourceReturnerId) {
		this.employeeInfoByResourceReturnerId = employeeInfoByResourceReturnerId;
	}

	@Column(name = "resource_name")
	public String getResourceName() {
		return this.resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "submit_time", length = 0)
	public Date getSubmitTime() {
		return this.submitTime;
	}

	public void setSubmitTime(Date submitTime) {
		this.submitTime = submitTime;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "return_time", length = 0)
	public Date getReturnTime() {
		return this.returnTime;
	}

	public void setReturnTime(Date returnTime) {
		this.returnTime = returnTime;
	}

	@Column(name = "resource_quantity")
	public Integer getResourceQuantity() {
		return this.resourceQuantity;
	}

	public void setResourceQuantity(Integer resourceQuantity) {
		this.resourceQuantity = resourceQuantity;
	}

}
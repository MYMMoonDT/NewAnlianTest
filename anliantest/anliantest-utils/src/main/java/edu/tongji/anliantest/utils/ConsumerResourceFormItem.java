package edu.tongji.anliantest.utils;

import java.util.Date;

public class ConsumerResourceFormItem {
	private String resourceName;
	private Date submitTime;
	private Date returnTime;
	private int resourceQuantity;
	private int resourceReceiverId;
	private int resourceReturnerId;
	public String getResourceName() {
		return resourceName;
	}
	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}
	public Date getSubmitTime() {
		return submitTime;
	}
	public void setSubmitTime(Date submitTime) {
		this.submitTime = submitTime;
	}
	public Date getReturnTime() {
		return returnTime;
	}
	public void setReturnTime(Date returnTime) {
		this.returnTime = returnTime;
	}
	public int getResourceQuantity() {
		return resourceQuantity;
	}
	public void setResourceQuantity(int resourceQuantity) {
		this.resourceQuantity = resourceQuantity;
	}
	public int getResourceReceiverId() {
		return resourceReceiverId;
	}
	public void setResourceReceiverId(int resourceReceiverId) {
		this.resourceReceiverId = resourceReceiverId;
	}
	public int getResourceReturnerId() {
		return resourceReturnerId;
	}
	public void setResourceReturnerId(int resourceReturnerId) {
		this.resourceReturnerId = resourceReturnerId;
	}
}

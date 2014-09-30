package edu.tongji.anliantest.model;

// Generated 2014-9-30 13:52:24 by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;

/**
 * ConsumerResourceTable generated by hbm2java
 */
public class ConsumerResourceTable implements java.io.Serializable {

	private Integer tableId;
	private ProjectInfo projectInfo;
	private String tableNum;
	private String tableType;
	private Set consumerResourceItems = new HashSet(0);

	public ConsumerResourceTable() {
	}

	public ConsumerResourceTable(ProjectInfo projectInfo, String tableNum,
			String tableType, Set consumerResourceItems) {
		this.projectInfo = projectInfo;
		this.tableNum = tableNum;
		this.tableType = tableType;
		this.consumerResourceItems = consumerResourceItems;
	}

	public Integer getTableId() {
		return this.tableId;
	}

	public void setTableId(Integer tableId) {
		this.tableId = tableId;
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

	public String getTableType() {
		return this.tableType;
	}

	public void setTableType(String tableType) {
		this.tableType = tableType;
	}

	public Set getConsumerResourceItems() {
		return this.consumerResourceItems;
	}

	public void setConsumerResourceItems(Set consumerResourceItems) {
		this.consumerResourceItems = consumerResourceItems;
	}

}

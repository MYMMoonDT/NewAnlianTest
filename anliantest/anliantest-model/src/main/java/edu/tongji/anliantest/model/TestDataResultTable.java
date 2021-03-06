package edu.tongji.anliantest.model;

// Generated 2014-9-30 13:52:24 by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;

/**
 * TestDataResultTable generated by hbm2java
 */
public class TestDataResultTable implements java.io.Serializable {

	private int tableId;
	private ProjectInfo projectInfo;
	private String tableName;
	private Set testDataResultItems = new HashSet(0);

	public TestDataResultTable() {
	}

	public TestDataResultTable(int tableId) {
		this.tableId = tableId;
	}

	public TestDataResultTable(int tableId, ProjectInfo projectInfo,
			String tableName, Set testDataResultItems) {
		this.tableId = tableId;
		this.projectInfo = projectInfo;
		this.tableName = tableName;
		this.testDataResultItems = testDataResultItems;
	}

	public int getTableId() {
		return this.tableId;
	}

	public void setTableId(int tableId) {
		this.tableId = tableId;
	}

	public ProjectInfo getProjectInfo() {
		return this.projectInfo;
	}

	public void setProjectInfo(ProjectInfo projectInfo) {
		this.projectInfo = projectInfo;
	}

	public String getTableName() {
		return this.tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public Set getTestDataResultItems() {
		return this.testDataResultItems;
	}

	public void setTestDataResultItems(Set testDataResultItems) {
		this.testDataResultItems = testDataResultItems;
	}

}

package edu.tongji.anliantest.model;

// Generated 2014-5-8 16:08:44 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * WorkTaskItem generated by hbm2java
 */
@Entity
@Table(name = "work_task_item", catalog = "anliantest")
public class WorkTaskItem implements java.io.Serializable {

	private Integer itemId;
	private WorkTaskTable workTaskTable;
	private DepartmentInfo departmentInfo;
	private String workContent;
	private String workTimeLimit;

	public WorkTaskItem() {
	}

	public WorkTaskItem(WorkTaskTable workTaskTable,
			DepartmentInfo departmentInfo, String workContent,
			String workTimeLimit) {
		this.workTaskTable = workTaskTable;
		this.departmentInfo = departmentInfo;
		this.workContent = workContent;
		this.workTimeLimit = workTimeLimit;
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
	public WorkTaskTable getWorkTaskTable() {
		return this.workTaskTable;
	}

	public void setWorkTaskTable(WorkTaskTable workTaskTable) {
		this.workTaskTable = workTaskTable;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "department_id")
	public DepartmentInfo getDepartmentInfo() {
		return this.departmentInfo;
	}

	public void setDepartmentInfo(DepartmentInfo departmentInfo) {
		this.departmentInfo = departmentInfo;
	}

	@Column(name = "work_content", length = 65535)
	public String getWorkContent() {
		return this.workContent;
	}

	public void setWorkContent(String workContent) {
		this.workContent = workContent;
	}

	@Column(name = "work_time_limit", length = 45)
	public String getWorkTimeLimit() {
		return this.workTimeLimit;
	}

	public void setWorkTimeLimit(String workTimeLimit) {
		this.workTimeLimit = workTimeLimit;
	}

}

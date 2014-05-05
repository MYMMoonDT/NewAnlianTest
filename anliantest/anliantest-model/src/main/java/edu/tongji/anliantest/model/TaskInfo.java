package edu.tongji.anliantest.model;

// Generated 2014-5-5 9:28:36 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * TaskInfo generated by hbm2java
 */
@Entity
@Table(name = "task_info", catalog = "anliantest")
public class TaskInfo implements java.io.Serializable {

	private Integer taskId;
	private Integer employeeId;
	private Integer projectId;
	private String taskType;

	public TaskInfo() {
	}

	public TaskInfo(Integer employeeId, Integer projectId, String taskType) {
		this.employeeId = employeeId;
		this.projectId = projectId;
		this.taskType = taskType;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "task_id", unique = true, nullable = false)
	public Integer getTaskId() {
		return this.taskId;
	}

	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}

	@Column(name = "employee_id")
	public Integer getEmployeeId() {
		return this.employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	@Column(name = "project_id")
	public Integer getProjectId() {
		return this.projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	@Column(name = "task_type", length = 100)
	public String getTaskType() {
		return this.taskType;
	}

	public void setTaskType(String taskType) {
		this.taskType = taskType;
	}

}
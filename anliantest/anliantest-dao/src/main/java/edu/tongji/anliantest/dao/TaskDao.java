package edu.tongji.anliantest.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import edu.tongji.anliantest.model.TaskInfo;

@Repository
public class TaskDao extends BaseDao<TaskInfo>{
	private final String GET_TASK_LIST_BY_EMPLOYEEID = "from TaskInfo t where t.employeeInfo.employeeId = ? and t.taskStatus = 0";
	
	public List<TaskInfo> getTaskListByEmployeeId(int employeeId){
		return (List<TaskInfo>)getHibernateTemplate().find(GET_TASK_LIST_BY_EMPLOYEEID, employeeId); 
	}
	
	public void finishTask(int taskId){
		TaskInfo taskInfo = load(taskId);
		taskInfo.setTaskStatus(1);
		getHibernateTemplate().update(taskInfo);
	}
}

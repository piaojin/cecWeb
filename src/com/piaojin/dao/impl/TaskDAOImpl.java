package com.piaojin.dao.impl;

import java.util.List;
import com.piaojin.domain.Task;


public class TaskDAOImpl extends BaseDAOImpl<Task> implements com.piaojin.dao.TaskDAO {

public void deleteTask(Task task) {
		// TODO Auto-generated method stub
		super.delete(task);
	}

	public Task findTask(String title) {
		// TODO Auto-generated method stub
		String hql="from Users where title='"+title;
		List list=super.find(hql, null);
		if(list.size()==1){
			return (Task)list.get(0);
		}else{
			return null;
		}
	}

	public Task getById(int tid) {
		// TODO Auto-generated method stub
		Class<Task> task = null;
		return super.findById(Task.class, tid);
	}
	
	public void save(Task task){
		super.save(task);
	}

	public void update(Task task) {
		// TODO Auto-generated method stub
		super.saveOrUpdate(task);
	}
}
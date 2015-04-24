package com.piaojin.service.impl;

import com.piaojin.dao.TaskDAO;
import com.piaojin.domain.Task;
import com.piaojin.service.TaskService;

public class TaskServiceImpl implements TaskService {

	public TaskDAO getTaskDAO() {
		return taskDAO;
	}

	public void setTaskDAO(TaskDAO taskDAO) {
		this.taskDAO = taskDAO;
	}

	private TaskDAO taskDAO;
	public void deleteTask(Task task) {
		// TODO Auto-generated method stub
		taskDAO.deleteTask(task);
	}

	public Task findTask(String title) {
		// TODO Auto-generated method stub
		return taskDAO.findTask(title);
	}

	public Task getById(int tid) {
		// TODO Auto-generated method stub
		return taskDAO.getById(tid);
	}

	public void save(Task task) {
		// TODO Auto-generated method stub
		taskDAO.save(task);
	}

	public void update(Task task) {
		// TODO Auto-generated method stub
		taskDAO.update(task);
	}

}

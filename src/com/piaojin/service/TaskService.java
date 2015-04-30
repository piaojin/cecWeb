package com.piaojin.service;

import java.util.List;

import com.piaojin.domain.Task;

public interface TaskService {
	void deleteTask(Task task);
	List<Task> getTask(int uid);//我发布的任务
	List<Task> getMyTask(int eid);//我的任务
	Task findTask(String title);
	Task getById(int tid);
	void save(Task task);
	void update(Task task);
}

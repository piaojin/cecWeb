package com.piaojin.service;

import com.piaojin.domain.Task;

public interface TaskService {
	void deleteTask(Task task);
	Task findTask(String title);
	Task getById(int tid);
	void save(Task task);
	void update(Task task);
}

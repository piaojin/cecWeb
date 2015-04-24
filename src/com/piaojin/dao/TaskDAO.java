package com.piaojin.dao;

import com.piaojin.domain.Task;

/**
 * Created by yangjb on 2015/1/25.
 */
public interface TaskDAO extends BaseDAO<Task>{
	void deleteTask(Task task);
	Task findTask(String title);
	Task getById(int tid);
	void save(Task task);
	void update(Task task);
}

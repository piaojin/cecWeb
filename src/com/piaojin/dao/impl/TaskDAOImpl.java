package com.piaojin.dao.impl;

import java.util.ArrayList;
import java.util.List;
import com.piaojin.domain.Task;

public class TaskDAOImpl extends BaseDAOImpl<Task> implements
		com.piaojin.dao.TaskDAO {

	public void deleteTask(Task task) {
		// TODO Auto-generated method stub
		super.delete(task);
	}

	public Task findTask(String title) {
		// TODO Auto-generated method stub
		String hql = "from Task where title='" + title + "'";
		List list = super.find(hql, null);
		if (list.size() > 0) {
			Task task = (Task) list.get(0);
			task.setKid(task.getTid());
			return task;
		} else {
			return null;
		}
	}

	public Task getById(int tid) {
		// TODO Auto-generated method stub
		Task task = super.findById(Task.class, tid);
		task.setKid(task.getTid());
		return task;
	}

	public void save(Task task) {
		super.save(task);
	}

	public void update(Task task) {
		// TODO Auto-generated method stub
		super.saveOrUpdate(task);
	}

	public List<Task> getTask(int uid) {
		// TODO Auto-generated method stub
		String hql = "from Task where uid =" + uid;
		List<Task> list = null;
		List<Object> obj = null;
		obj = super.find(hql, null);
		if (obj != null && obj.size() > 0) {
			list = new ArrayList<Task>();
			for (Object o : obj) {
				Task temptask = (Task) o;
				temptask.setKid(temptask.getTid());
				temptask.setUid(temptask.getEmployByUid().getUid());
				temptask.setEid(temptask.getEmployByEid().getUid());
				list.add(temptask);
			}
		}
		return list;
	}

	public List<Task> getMyTask(int eid) {
		// TODO Auto-generated method stub
		String hql = "from Task where eid =" + eid;
		List<Task> list = null;
		List<Object> obj = null;
		obj = super.find(hql, null);
		if (obj != null && obj.size() > 0) {
			list = new ArrayList<Task>();
			for (Object o : obj) {
				Task temptask = (Task) o;
				temptask.setKid(temptask.getTid());
				temptask.setUid(temptask.getEmployByUid().getUid());
				temptask.setEid(temptask.getEmployByEid().getUid());
				list.add(temptask);
			}
		}
		return list;
	}
}

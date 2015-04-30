package com.piaojin.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletContext;
import org.apache.struts2.util.ServletContextAware;
import com.piaojin.common.CommonResource;
import com.piaojin.domain.Employ;
import com.piaojin.domain.Task;

public class TaskAction extends BaseAction<Employ> implements
		ServletContextAware {
	private Task task;

	private void setCharacterEncoding() {
		super.response.setCharacterEncoding("UTF-8");
		super.response.setContentType("text/html;charset=UTF-8");
	}

	@Override
	public Map<String, Object> getSession() {
		// TODO Auto-generated method stub
		return super.getSession();
	}

	public void setServletContext(ServletContext arg0) {
		// TODO Auto-generated method stub

	}

	public void AddTask() throws IOException {
		System.out.println("AddTask");
		setCharacterEncoding();
		String taskjson = super.request.getParameter("parameter");
		System.out.println(taskjson);
		// 添加到数据库中去
		Task task = CommonResource.gson.fromJson(taskjson, Task.class);
		Employ u = super.employService.getById(task.getUid());
		Employ e = super.employService.getById(task.getEid());
		task.setEmployByEid(e);
		task.setEmployByUid(u);
		System.out.println(u.getName() + e.getName() + task.getTime());
		super.taskService.save(task);
		task = super.taskService.findTask(task.getTitle());
		task.setKid(task.getTid());
		super.taskService.update(task);
		System.out.println(CommonResource.gson.toJson(task));
		super.response.getWriter().write(CommonResource.gson.toJson(task));
	}

	// 获取所有我的任务
	public void getMyTask() throws IOException {
		System.out.println("getMyTask");
		setCharacterEncoding();
		String employeeid = super.request.getParameter("parameter");
		int eid = Integer.parseInt(employeeid);
		List<Task> list = new ArrayList<Task>();
		list = super.taskService.getMyTask(eid);
		String jsonlist = CommonResource.gson.toJson(list);
		System.out.println(jsonlist);
		super.response.getWriter().write(jsonlist);
	}

	// 获取所有我的任务
	public void getTask() throws IOException {
		System.out.println("getTask");
		setCharacterEncoding();
		String employeeid = super.request.getParameter("parameter");
		int uid = Integer.parseInt(employeeid);
		List<Task> list = new ArrayList<Task>();
		list = super.taskService.getTask(uid);
		String jsonlist = CommonResource.gson.toJson(list);
		System.out.println(jsonlist);
		super.response.getWriter().write(jsonlist);
	}
	
	//接收任务
	public void acceptTask() throws IOException{
		System.out.println("acceptTask");
		setCharacterEncoding();
		String taskkid = super.request.getParameter("parameter");
		int kid=Integer.parseInt(taskkid);
		//更新任务为进行中
		Task task=super.taskService.getById(kid);
		task.setStatus(CommonResource.STATUSACCEPT);
		super.taskService.update(task);
		super.response.getWriter().write("success");
	}
	
	//完成任务
	public void finishTask() throws IOException{
		System.out.println("finishTask");
		setCharacterEncoding();
		String taskkid = super.request.getParameter("parameter");
		int kid=Integer.parseInt(taskkid);
		//更新任务为完成
		Task task=super.taskService.getById(kid);
		task.setStatus(CommonResource.STATUSFINISH);
		super.taskService.update(task);
		super.response.getWriter().write("success");
	}
	
	//删除任务
	public void deleteTask() throws IOException{
		System.out.println("deleteTask");
		setCharacterEncoding();
		String taskkid = super.request.getParameter("parameter");
		int kid=Integer.parseInt(taskkid);
		Task task=super.taskService.getById(kid);
		task.setStatus(CommonResource.STATUSFINISH);
		super.taskService.deleteTask(task);
		super.response.getWriter().write("success");
	}
	
	//更新任务
	public void sendEditTask() throws IOException{
		System.out.println("sendEditTask");
		setCharacterEncoding();
		String taskjson = super.request.getParameter("parameter");
		Task temptask=CommonResource.gson.fromJson(taskjson, Task.class);
		Task task=super.taskService.getById(temptask.getKid());
		task.setTitle(temptask.getTitle());
		task.setStarttime(temptask.getStarttime());
		task.setEndtime(temptask.getEndtime());
		task.setContent(temptask.getContent());
		task.setTime(temptask.getTime());
		task.setStatus(temptask.getStatus());
		super.taskService.update(task);
		super.response.getWriter().write("success");
	}

}

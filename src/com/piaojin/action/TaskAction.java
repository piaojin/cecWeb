package com.piaojin.action;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts2.util.ServletContextAware;

import com.piaojin.common.CommonResource;
import com.piaojin.common.MD5Code;
import com.piaojin.domain.Employ;
import com.piaojin.domain.Task;
import com.sun.mail.iap.Response;


public class TaskAction extends BaseAction<Employ> implements
		ServletContextAware {
	private Task task;

	@Override
	public Map<String, Object> getSession() {
		// TODO Auto-generated method stub
		return super.getSession();
	}

	public void setServletContext(ServletContext arg0) {
		// TODO Auto-generated method stub

	}
	
	public void AddTask() throws IOException{
		System.out.println("AddTask");
		super.response.setCharacterEncoding("UTF-8");
		super.response.setContentType("text/html;charset=UTF-8");
		String taskjson=super.request.getParameter("taskjson");
		System.out.println(taskjson);
		//添加到数据库中去
		Task task=CommonResource.gson.fromJson(taskjson, Task.class);
		Employ u=super.employService.getById(task.getUid());
		Employ e=super.employService.getById(task.getEid());
		task.setEmployByEid(e);
		task.setEmployByUid(u);
		System.out.println(u.getName()+e.getName()+task.getTime());
		super.taskService.save(task);
		task=super.taskService.findTask(task.getTitle());
		task.setKid(task.getTid());
		super.taskService.update(task);
		System.out.println(CommonResource.gson.toJson(task));
		super.response.getWriter().write(CommonResource.gson.toJson(task));
	}

}

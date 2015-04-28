package com.piaojin.action;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletContext;
import org.apache.struts2.util.ServletContextAware;
import com.google.gson.Gson;
import com.piaojin.common.CommonResource;
import com.piaojin.domain.Employ;
import com.piaojin.domain.MyFile;

public class EmployAction extends BaseAction<Employ> implements
		ServletContextAware {
	final String SUC = "success";
	final String ERROR = "error";
	final String NULLERROR = "nullerror";
	private Employ employ;

	@Override
	public Map<String, Object> getSession() {
		// TODO Auto-generated method stub
		return super.getSession();
	}

	public void setServletContext(ServletContext arg0) {
		// TODO Auto-generated method stub

	}

	public String save() {
		System.out.println("save");
		return SUC;
	}

	// 登录
	public void Login() throws IOException {
		System.out.println("Login");
		String name = super.request.getParameter("name");
		String pwd = super.request.getParameter("pwd");

		if (name == null || pwd == null || "".equals(name) || "".equals(pwd)) {
			System.out.println("用户名或密码为空！");
			super.response.getWriter().write(NULLERROR);
			return;
		}

		Employ employ = super.employService.checkEmploy(name, pwd);
		// 把employ转换成json格式返回客户端
		String json = new Gson().toJson(employ);
		if (employ == null) {
			System.out.println("用户名或密码错误！");
			super.response.getWriter().write(ERROR);
			return;
		}
		super.response.setCharacterEncoding("UTF-8");
		super.response.setContentType("text/html;charset=UTF-8");
		super.response.getWriter().write(json);
		System.out.println("json");
		System.out.println(json);
	}

	// 返回所有的员工集合
	public void getAllEmploy() throws IOException {
		// 获取所有员工集合
		System.out.println("getAllEmploy");
		super.response.setCharacterEncoding("UTF-8");
		super.response.setContentType("text/html;charset=UTF-8");
		List<Employ> list = employService.getAllEmploy();
		super.response.getOutputStream().write(CommonResource.gson.toJson(list).getBytes("UTF-8"));
		System.out.println(CommonResource.gson.toJson(list));
	}
	
}

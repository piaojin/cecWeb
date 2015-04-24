package com.piaojin.common;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
final public class Mysshtools {

	private static HttpServletRequest request=null;
	private static HttpServletResponse response=null;
	public static HttpServletResponse getResponse() throws IOException {
		response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		//response.flushBuffer();
		return response;
	}
	
	private static ApplicationContext ac=null;
	public static HttpServletRequest getRequest(){
		request=ServletActionContext.getRequest();
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return request;
	}
	public static ApplicationContext getAc() {
		return ac=new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	public static HttpSession getSession() {
		return session=ServletActionContext.getRequest().getSession();
	}
	private static HttpSession session=null;
}

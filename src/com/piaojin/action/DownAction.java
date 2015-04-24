package com.piaojin.action;

import java.util.Map;

import javax.servlet.ServletContext;

import org.apache.struts2.util.ServletContextAware;

import com.piaojin.domain.Employ;

public class DownAction extends BaseAction<Employ> implements
ServletContextAware{

	public void setServletContext(ServletContext arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Map<String, Object> getSession() {
		// TODO Auto-generated method stub
		return super.getSession();
	}
	
	public void DownFile(){
		System.out.println("DownFile");
	}
}

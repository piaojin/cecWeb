package com.piaojin.action;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletContext;
import org.apache.struts2.util.ServletContextAware;

import com.piaojin.common.CommonResource;
import com.piaojin.domain.Department;
import com.piaojin.domain.Employ;
import com.piaojin.domain.MyFile;

public class DepartmentAction extends BaseAction<Employ> implements
ServletContextAware{

	public void setServletContext(ServletContext arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Map<String, Object> getSession() {
		// TODO Auto-generated method stub
		return super.getSession();
	}
	
	//获取所有的部门集合
	public void getAllDepartment() throws UnsupportedEncodingException, IOException{
		List<Department> list=super.departmentService.getAllDepartment();
		System.out.println(CommonResource.gson.toJson(list));
		super.response.getOutputStream().write(CommonResource.gson.toJson(list).getBytes("UTF-8"));
	}
}

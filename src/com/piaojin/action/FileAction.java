package com.piaojin.action;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts2.util.ServletContextAware;

import com.piaojin.common.CommonResource;
import com.piaojin.common.MD5Code;
import com.piaojin.domain.Employ;
import com.piaojin.domain.MyFile;
import com.sun.mail.iap.Response;


public class FileAction extends BaseAction<Employ> implements
		ServletContextAware {
	private MyFile file;

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
	
	//获取共享文件
		public void getAllSharedFile() throws UnsupportedEncodingException, IOException{
			System.out.println("getAllSharedFile");
			setCharacterEncoding();
			List<MyFile> list=super.fileService.getAllSharedFile();
			String jsonlist=null;
			if(list!=null&&list.size()>0){
				super.response.flushBuffer();
				jsonlist=CommonResource.gson.toJson(list);
				System.out.println(jsonlist);
				super.response.getOutputStream().write(jsonlist.getBytes("UTF-8"));
			}else{
				super.response.getOutputStream().write(null);
			}
			
		}

}

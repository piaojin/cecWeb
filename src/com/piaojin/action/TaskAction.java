package com.piaojin.action;

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

}

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
		System.out.println("123");
		employ = new Employ();
		employ.setName("飘金");
		employ.setSex(0);
		employ.setTel("13666902838");
		employ.setEmail("804488815@qq.com");
		employ.setAddress("福建省莆田市荔城区北高镇北高村坑东30号");
		employ.setEmployeeid(6);
		employ.setPwd("804488815");
		employ.setDepartment("飘金操作系统研发部门");
		employ.setHead("www.piaojin.com");
		employ.setLevel(6);
		// super.employService.save(employ);
		String json = new Gson().toJson(employ);
		System.out.println(json);
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
		/*File dir=new File(CommonResource.TEMPPATH);
	    if(dir.exists()){
	    	dir.mkdirs();
	    }
	    File file=new File(dir,CommonResource.ALLEMPLOY);
	    if(file.exists()){
	    	file.createNewFile();
	    }
	    FileWriter fw=new FileWriter(file);
	    BufferedWriter bw=new BufferedWriter(fw);
		if(list!=null&&list.size()>0){
			gson=new Gson();
			for(Employ employ:list){
				String employjson=gson.toJson(employ);
				bw.write(employjson);
				bw.newLine();
			}
		}
		bw.flush();
		bw.close();
		fw.close();*/
		super.response.getOutputStream().write(CommonResource.gson.toJson(list).getBytes("UTF-8"));
	}
	
	//获取共享文件
	public void getAllSharedFile() throws UnsupportedEncodingException, IOException{
		System.out.println("getAllSharedFile");
		List<MyFile> list=super.fileService.getAllSharedFile();
		String jsonlist=null;
		if(list!=null&&list.size()>0){
			jsonlist=CommonResource.gson.toJson(list);
			super.response.getOutputStream().write(jsonlist.getBytes("UTF-8"));
		}else{
			super.response.getOutputStream().write(null);
		}
		
	}
}

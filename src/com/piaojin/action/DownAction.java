package com.piaojin.action;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PushbackInputStream;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import javax.servlet.ServletContext;
import org.apache.struts2.util.ServletContextAware;

import com.piaojin.common.StreamTool;
import com.piaojin.domain.Employ;
import com.piaojin.domain.MyFile;

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
	
	public void DownFile() throws UnsupportedEncodingException, IOException{
		System.out.println("DownFile");
		MyFile myfile=null;
		int pid=-1;
		RandomAccessFile fileOutStream = null;
		OutputStream outputStream=super.response.getOutputStream();
		String temp=super.request.getParameter("pid");
	    if(temp!=null){
	    	pid=Integer.parseInt(temp);
	        myfile=super.fileService.getById(pid);
	        if(myfile!=null){
	        	File file=new File(myfile.getAbsoluteurl());
	        	if(file.isFile()){
	        		fileOutStream=new RandomAccessFile(file, "r");
	        		 byte[] buffer = new byte[1024];
	        		 int length=0;
	                 int len = -1;
	                 while (((len = fileOutStream.read(buffer)) != -1)) {
	                	 outputStream.write(buffer, 0, len);
	                     length += len;
	                     System.out.println("下载进度" + length + ",len:" + len+",filesize:"+myfile.getFilesize());
	                     if (len == 0 || len == -1 || length - myfile.getFilesize() == 0) {
	                         break;
	                     }
	                 }
	        	}else{
	        		outputStream.write("".getBytes());
	        	}
	        }else{
	        	outputStream.write("".getBytes());
	        }
	    }
	}
}

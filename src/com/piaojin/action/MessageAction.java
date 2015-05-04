package com.piaojin.action;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Map;
import javax.servlet.ServletContext;
import org.apache.struts2.util.ServletContextAware;
import com.piaojin.common.CommonResource;
import com.piaojin.domain.Employ;
import com.piaojin.domain.Message;


public class MessageAction extends BaseAction<Employ> implements
		ServletContextAware {
	private Message message;
	
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

	//转发消息
	private void relayToReceiver(Message message) throws UnknownHostException, IOException{
		Socket socket=new Socket(message.getReceiverip(),6060);
		socket.setSoTimeout(10000);
		if(socket!=null&&socket.isConnected()){
			OutputStream outStream = socket.getOutputStream();
            PrintStream printStream = new PrintStream(outStream,false,"UTF-8");
            printStream.println(CommonResource.gson.toJson(message));
            socket.close();
		}
	}
	
	public void relayMessage() throws Exception{
		System.out.println("relayMessage");
		setCharacterEncoding();
		String messagejson=super.request.getParameter("parameter");
		System.out.println(messagejson);
		Message message=CommonResource.gson.fromJson(messagejson, Message.class);
        if(message!=null){
        	relayToReceiver(message);
        }
        System.out.println("消息已转发出去");
	}
	
}

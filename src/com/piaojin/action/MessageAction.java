package com.piaojin.action;

import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PushbackInputStream;
import java.io.RandomAccessFile;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Map;
import javax.servlet.ServletContext;
import org.apache.struts2.util.ServletContextAware;
import com.piaojin.common.CommonResource;
import com.piaojin.common.MessageResource;
import com.piaojin.domain.Employ;
import com.piaojin.domain.Message;
import com.piaojin.domain.MyFile;


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
	
	//转发文字聊天信息
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
	
	//转发语音
	public void relayVideo() throws IOException{
		System.out.println("relayVideo");
		String videoname=super.request.getParameter("videoname");
		System.out.println("videoname"+videoname);
		setCharacterEncoding();
		InputStream inputStream=super.request.getInputStream();
		readFile(inputStream,videoname);
        		
	}
	
	public void relayFile() throws IOException{
		System.out.println("relayFile");
		setCharacterEncoding();
		String messagejson=super.request.getParameter("parameter");
		System.out.println(messagejson);
		Message message=CommonResource.gson.fromJson(messagejson, Message.class);
		if(message!=null){
			OutputStream outStream=super.response.getOutputStream();
			downloadFile(message,outStream);
		}
		
	}
	
	public void downloadFile(Message message, OutputStream outStream) {
        File tempfile = new File(CommonResource.VIDEOPATH+new File(message.getVideourl()).getName());
        RandomAccessFile fileOutStream = null;
        if(tempfile.isFile()){
        	try {
                fileOutStream = new RandomAccessFile(tempfile, "r");
                byte[] buffer = new byte[1024];
                int len = -1;
                while (((len = fileOutStream.read(buffer)) != -1)) {
                    	outStream.write(buffer, 0, len);
                        System.out.println("下载的长度:" + len);
                }
                fileOutStream.close();
                System.out.println("文件发送完!");
            } catch (Exception e) {
                System.out.println("&&&&&&&&&&&" + e.getMessage());
                e.printStackTrace();
            }
        }
    }
	
	public void readFile(InputStream inputStream,String videoname) {
		RandomAccessFile fileOutStream = null;
		try {
			File dir = new File(CommonResource.VIDEOPATH);
			if (!dir.exists())
				dir.mkdirs();
			File file = new File(dir, videoname);
			fileOutStream = new RandomAccessFile(file, "rwd");
			byte[] buffer = new byte[1024];
			int len = -1;
			double length = 0;
			while ((len = inputStream.read(buffer)) != -1) {// 从输入流中读取数据写入到文件中
				fileOutStream.write(buffer, 0, len);
				length += len;
				System.out.println("长度:" + length+","+len);
			}
			System.out.println("语音文件全部读完...");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (fileOutStream != null) {
				try {
					fileOutStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
}

package com.piaojin.serversocket;
/*下载文件服务*/
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PushbackInputStream;
import java.io.RandomAccessFile;
import java.net.Socket;
import org.springframework.context.ApplicationContext;
import com.google.gson.Gson;
import com.piaojin.common.CommonResource;
import com.piaojin.common.DateUtil;
import com.piaojin.common.DownloadfileResource;
import com.piaojin.common.Mysshtools;
import com.piaojin.common.StreamTool;
import com.piaojin.common.UploadfileResource;
import com.piaojin.domain.Employ;
import com.piaojin.domain.MyFile;
import com.piaojin.json.JsonHelper;
import com.piaojin.service.EmployService;
import com.piaojin.service.MyFileService;

public class DownloadSocketTask implements Runnable {

	private String uploadPath = "D:\\uploadFile\\";
	MyFile myfile=null;
    private Thread thread=new Thread(this);
	PrintStream printStream=null;
	OutputStream outStream=null;
	PushbackInputStream inStream =null;
	File file = null;
	private MyFileService fileService;
	private EmployService employService;
	private ApplicationContext a;

	public MyFileService getMyFileService() {
		return fileService;
	}

	public void setMyFileService(MyFileService fileService) {
		this.fileService = fileService;
	}

	private Socket socket;

	public DownloadSocketTask(Socket socket) {
		this.socket = socket;
		a = Mysshtools.getAc();
		fileService = (MyFileService) a.getBean("MyFileService");
		employService = (EmployService) a.getBean("EmployService");
	}

	// 客户端连接成功便开始读取客户端的文件并保存到电脑中且建立表记录读取文件到的情况
	public void run() {
		try {
			if (socket != null && socket.isConnected()) {
				System.out.println("进入下载服务器...");
				inStream = new PushbackInputStream(
						socket.getInputStream());
				outStream = socket.getOutputStream();
				printStream = new PrintStream(outStream, false,
						"UTF-8");
				/* 读 */
				String downloadfilejson = StreamTool.readLine(inStream);
				System.out.println(downloadfilejson);
				myfile = CommonResource.gson.fromJson(downloadfilejson,
						MyFile.class);
				/* 去数据库查询是否已有记录即是否上传过，即上传的状态 */
				// 查找是否有同名的文件
				System.out.println("myfile.getName():"+myfile.getName());
				MyFile tempfile = fileService.getById(myfile
						.getKid());
				if (tempfile != null) {
					//要下载的文件存在
					Employ employ = employService.getById(myfile.getUid());
					myfile.setEmploy(employ);
					// 向客户端发送数据,准备好叫客户端准备好接收文件
					JsonHelper startdownjson = new JsonHelper();
					startdownjson.setType(DownloadfileResource.STARTDOWNLOAD);
					String startdownstr = CommonResource.gson.toJson(startdownjson);
					/* 写 */
					printStream.println(startdownstr);
					System.out.println("jsonhelperstr:" + startdownstr);
					/* 读 */
					//客户端是否准备好接收文件
					String isreadyjson = StreamTool.readLine(inStream);
					JsonHelper j=CommonResource.gson.fromJson(isreadyjson,
							JsonHelper.class);
					if(j.getType()==DownloadfileResource.DODOWNLOAD){
						//开始传文件
						uploadFile(myfile,outStream);
						
						
					}else{
						//客户端出现问题，停止线程
						System.out.println("客户端出现问题，停止线程");
						close();
					}
					
				}else{
					//要下载的文件不存在
					System.out.println("要下载的文件不存在");
					JsonHelper error=new JsonHelper();
					error.setType(DownloadfileResource.FILENOTFIND);
					/* 写 */
					printStream.println(CommonResource.gson.toJson(error));
					close();
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (socket != null && !socket.isClosed())
					socket.close();
			} catch (IOException e) {
			}
		}
	}

	private void uploadFile(MyFile myfile, OutputStream outStream) {
        File tempfile = new File(CommonResource.UPLOADPATH+myfile.getName());
        RandomAccessFile fileOutStream = null;
        try {
            fileOutStream = new RandomAccessFile(tempfile, "r");
            byte[] buffer = new byte[1024];
            int len = -1;
            Double length = Double.valueOf(0);
            while (((len = fileOutStream.read(buffer)) != -1)) {
            	if(!socket.isConnected()||socket.isClosed()){
            		outStream.close();
            		break;
            	}
            	System.out.println(socket.isConnected()+","+socket.isClosed());
                	outStream.write(buffer, 0, len);
                	//outStream.flush();
                    length += len;
                    this.myfile.setCompletedsize(length);
                    System.out.println("下载的长度:" + length + "," + len);
                    if (len == 0 || len == -1 || length - this.myfile.getFilesize() == 0) {
                        break;
                    }
            }
            System.out.println("文件发送完!");
            readCompleted();
        } catch (Exception e) {
            close();
            System.out.println("&&&&&&&&&&&" + e.getMessage());
            e.printStackTrace();
        }
    }
	
	private void readCompleted(){
		System.out.println("readCompleted..."+this.myfile.getFilesize()+","
				+this.myfile
				.getCompletedsize());
		if (this.myfile.getFilesize()-this.myfile
				.getCompletedsize()==0) {
			System.out.println("下载文件完毕...");
			
		} else {
			System.out.println("下载文件未完成...");
		}
		close();
	}
	
	private void close(){
	   if(!thread.isInterrupted()){
		   thread.interrupt();
		   System.out.println("关闭文件上传线程...");
	   }
	}
}

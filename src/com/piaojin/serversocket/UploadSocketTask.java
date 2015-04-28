package com.piaojin.serversocket;
/*上传文件服务*/
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
import com.piaojin.common.FileUtil;
import com.piaojin.common.Mysshtools;
import com.piaojin.common.StreamTool;
import com.piaojin.common.UploadfileResource;
import com.piaojin.domain.Employ;
import com.piaojin.domain.MyFile;
import com.piaojin.json.JsonHelper;
import com.piaojin.service.EmployService;
import com.piaojin.service.MyFileService;

public class UploadSocketTask implements Runnable {

	MyFile myfile=null;
    private Thread thread=new Thread(this);
	PrintStream printStream=null;
	OutputStream outStream=null;
	PushbackInputStream inStream =null;
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

	public UploadSocketTask(Socket socket) {
		this.socket = socket;
		a = Mysshtools.getAc();
		fileService = (MyFileService) a.getBean("MyFileService");
		employService = (EmployService) a.getBean("EmployService");
	}

	// 客户端连接成功便开始读取客户端的文件并保存到电脑中且建立表记录读取文件到的情况
	public void run() {
		try {
			if (socket != null && socket.isConnected()) {
				System.out.println("进入上传服务器...");
				inStream = new PushbackInputStream(
						socket.getInputStream());
				outStream = socket.getOutputStream();
				printStream = new PrintStream(outStream);
				/* 读 */
				String uploadfilejson = StreamTool.readLine(inStream);
				System.out.println(uploadfilejson);
				myfile = new Gson().fromJson(uploadfilejson,
						MyFile.class);
				/* 去数据库查询是否已有记录即是否上传过，即上传的状态 */
				// 查找是否有同名的文件
				System.out.println("myfile.getName():"+myfile.getName());
				MyFile tempfile = fileService.findFileByName(myfile
						.getName());
				if (tempfile != null) {
					// 已存在该名字的文件，用日期重新命名文件
					String tempname = myfile.getName();
					String temppart1 = tempname.substring(0,
							tempname.indexOf("."));
					String temppart2 = tempname
							.substring(tempname.indexOf("."));
					myfile.setName(temppart1 + DateUtil.CurrentTime()
							+ temppart2);
				}
				Employ employ = employService.getById(myfile.getUid());
				myfile.setEmploy(employ);
				// 向客户端发送数据,准备好叫客户端开始上传文件
				JsonHelper jsonhelper = new JsonHelper();
				jsonhelper.setType(UploadfileResource.STARTUPLOAD);
				String jsonhelperstr = new Gson().toJson(jsonhelper);
				/* 写 */
				printStream.println(jsonhelperstr);
				System.out.println("jsonhelperstr:" + jsonhelperstr);

				/* 开始读文件内容 */
				readFile(this.myfile, inStream);

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

	private void readFile(MyFile uploadfile, PushbackInputStream inStream) {
		RandomAccessFile fileOutStream = null;
		try {
			File dir = new File(CommonResource.UPLOADPATH);
			if (!dir.exists())
				dir.mkdirs();
			File file = new File(dir, uploadfile.getName());
			fileOutStream = new RandomAccessFile(file, "rwd");
			fileOutStream.seek(uploadfile.getCompletedsize().intValue());
			fileOutStream.setLength(uploadfile.getFilesize().longValue());// 设置文件长度
			byte[] buffer = new byte[1024];
			int len = -1;
			double length = 0;
			InputStream inputStream=socket.getInputStream();
			this.myfile.setAbsoluteurl(file.getAbsolutePath());
			while ((len = inputStream.read(buffer)) != -1) {// 从输入流中读取数据写入到文件中
				fileOutStream.write(buffer, 0, len);
				length += len;
				uploadfile.setCompletedsize(length);
				System.out.println("长度:" + length+","+len);
			    if(len==0||len==-1||length-this.myfile.getFilesize()==0){
			    	break;
			    }
			}
			System.out.println("文件全部读完...");
			readCompleted();
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
	
	private void readCompleted(){
		System.out.println("readCompleted..."+this.myfile.getFilesize()+","
				+this.myfile
				.getCompletedsize());
		if (this.myfile.getFilesize()-this.myfile
				.getCompletedsize()==0) {
			this.myfile.setStatus(CommonResource.STATUS_NOT_DOWN);
			this.myfile.setCompletedate(DateUtil.CurrentTime());
			this.myfile.setIscomplete(1);
			System.out.println("上传文件完毕...");
			fileService.save(this.myfile);
			JsonHelper jsonhelpers = new JsonHelper();
			jsonhelpers.setType(UploadfileResource.UPLOADFINISH);
			String jsonhelperstr2 = new Gson().toJson(jsonhelpers);
			/* 告诉客户端文件上传完毕*/
			printStream.println(jsonhelperstr2);
			System.out.println("jsonhelperstr:" + jsonhelperstr2);
		} else {
			// 删除未完成的文件
			FileUtil.delete(CommonResource.UPLOADPATH+myfile.getName());
			JsonHelper jsonhelpers = new JsonHelper();
			jsonhelpers.setType(UploadfileResource.UPLOADFAIL);
			String jsonhelperstrs = new Gson().toJson(jsonhelpers);
			/* 告诉客户端文件上传完毕*/
			printStream.println(jsonhelperstrs);
			System.out.println("上传文件未完成...");
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

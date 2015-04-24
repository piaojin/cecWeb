package com.piaojin.serversocket;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PushbackInputStream;
import java.io.RandomAccessFile;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import com.piaojin.common.StreamTool;

public class SocketServer {
	private ExecutorService executorService;// 线程池
	private ServerSocket ss = null;
	private int port;// 监听端口
	private boolean quit;// 是否退出
    //保存到数据库
	public SocketServer(int port) {
		this.port = port;
		// 初始化线程池
		executorService = Executors.newFixedThreadPool(Runtime.getRuntime()
				.availableProcessors() * 50);
	}

	// 启动服务
	public void start() throws Exception {
		ss = new ServerSocket(port);
		while (!quit) {
			Socket socket = ss.accept();//接受客户端的请求
			// 为支持多用户并发访问，采用线程池管理每一个用户的连接请求
			executorService.execute(new UploadSocketTask(socket));// 启动一个线程来处理请求
		}
	}

	// 退出
	public void quit() {
		this.quit = true;
		try {
			ss.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws Exception {
		InetAddress addr = InetAddress.getLocalHost();
		String ip = addr.getHostAddress();// 获得本机IP
		String address = addr.getHostName();// 获得本机名称
		System.out.println(ip);
		SocketServer server = new SocketServer(6666);
		server.start();
	}



}

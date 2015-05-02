package test;

import java.io.File;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.List;

import net.sf.json.JsonConfig;
import net.sf.json.util.PropertyFilter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.piaojin.common.CommonResource;
import com.piaojin.common.FileUtil;
import com.piaojin.common.Mysshtools;
import com.piaojin.dao.DepartmentDAO;
import com.piaojin.domain.Department;
import com.piaojin.domain.Employ;
import com.piaojin.domain.MyFile;
import com.piaojin.domain.Task;
import com.piaojin.service.EmployService;
import com.piaojin.service.MyFileService;
import com.piaojin.service.TaskService;

import junit.framework.TestCase;

public class test extends TestCase {

	public void test1() throws IOException {
		DatagramSocket client = new DatagramSocket();

		String sendStr = "Hello! I'm Client";
		byte[] sendBuf;
		sendBuf = sendStr.getBytes();
		InetAddress addr = InetAddress.getByName("192.168.253.2");
		int port = 6060;
		DatagramPacket sendPacket = new DatagramPacket(sendBuf, sendBuf.length,
				addr, port);
		client.send(sendPacket);
		byte[] recvBuf = new byte[100];
		DatagramPacket recvPacket = new DatagramPacket(recvBuf, recvBuf.length);
		client.receive(recvPacket);
		String recvStr = new String(recvPacket.getData(), 0,
				recvPacket.getLength());
		System.out.println("收到:" + recvStr);
		client.close();

	}

}

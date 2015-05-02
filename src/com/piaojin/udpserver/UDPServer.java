package com.piaojin.udpserver;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPServer implements Runnable{

	DatagramSocket  server = null;
	byte[] recvBuf = new byte[100];
    DatagramPacket recvPacket 
        = new DatagramPacket(recvBuf , recvBuf.length);
	
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args){

		UDPServer udpserver=new UDPServer();
		try {
			udpserver.server=new DatagramSocket(6060);
			new Thread(udpserver).start();
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void run() {

		while(!Thread.interrupted()){
			try {
				server.receive(recvPacket);
				String recvStr = new String(recvPacket.getData() , 0 , recvPacket.getLength());
		        System.out.println("Hello World!" + recvStr);
		        int port = recvPacket.getPort();
		        InetAddress addr = recvPacket.getAddress();
		        String sendStr = "Hello ! I'm Server";
		        byte[] sendBuf;
		        sendBuf = sendStr.getBytes();
		        DatagramPacket sendPacket 
		            = new DatagramPacket(sendBuf , sendBuf.length , addr , port );
		        server.send(sendPacket);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}

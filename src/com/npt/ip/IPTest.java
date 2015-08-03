package com.npt.ip;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class IPTest {
	public static void main(String args[]) throws UnknownHostException{
		
		InetAddress addr = InetAddress.getLocalHost();
		
		String ip = addr.getHostAddress().toString();
		
		String address = addr.getHostName().toString();
		
		System.out.println("本机局域网IP地址：	"+ip+"\n"+"本机名称：	"+address);
	}
}

package com.npt.ip;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class IPTest {
	public static void main(String args[]) throws UnknownHostException{
		
		InetAddress addr = InetAddress.getLocalHost();
		
		String ip = addr.getHostAddress().toString();
		
		String address = addr.getHostName().toString();
		
		System.out.println("����������IP��ַ��	"+ip+"\n"+"�������ƣ�	"+address);
	}
}

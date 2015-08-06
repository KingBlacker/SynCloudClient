package com.npt.service;

import java.io.IOException;

import org.apache.http.ParseException;

public class TestMain {
	public static void main(String args[]) throws ParseException, IOException{
	
	String username = "matrix";
	String userpwd = "12345";
//	UserRegist reg = new UserRegist(username,userpwd);
//	reg.regist();
//	UserLogin ul = new UserLogin(username,userpwd);
//	ul.login();
	
	SyncUser su = new SyncUser();
	su.getSyncUser();
	}
}

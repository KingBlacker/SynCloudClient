package com.npt.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

@SuppressWarnings("deprecation")
public class UserRegist {
	
	private String username;
	private String userpwd;
	private String registURL = "http://127.0.0.1/SynCloudServer/Impl/RegistCheck.php";
	
	/**
	 * construction to transfer the username and userpwd
	 * @param username
	 * @param userpwd
	 */
	public UserRegist(String username,String userpwd){
			this.username = username;
			this.userpwd = userpwd;
	}
	
	/**
	 * regist the user
	 * @throws ParseException
	 * @throws IOException
	 */
	public void regist() throws ParseException, IOException{
		 HttpPost httpRequest = new HttpPost(this.registURL);
	     List<NameValuePair> params = new ArrayList<NameValuePair>();
	     params.add(new BasicNameValuePair("username",this.username));
	     params.add(new BasicNameValuePair("password",this.userpwd));
	   

	     HttpEntity httpEntity = new UrlEncodedFormEntity(params,"utf-8");
	     httpRequest.setEntity(httpEntity);
				
	     @SuppressWarnings({ "resource", "deprecation" })
		 HttpClient httpClient = new DefaultHttpClient();
		 HttpResponse httpResponse = httpClient.execute(httpRequest);
				
	     if(httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
				//get the response entity
	    	 		String result = EntityUtils.toString(httpResponse.getEntity());
				System.out.println(result);

		}else{
					System.out.println("there is no result");
		}
	}

}

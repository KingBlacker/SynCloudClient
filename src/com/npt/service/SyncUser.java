package com.npt.service;

import java.io.IOException;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.ParseException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;



@SuppressWarnings("deprecation")
public class SyncUser {
	private String userURL = "http://127.0.0.1/SynCloudServer/Impl/SyncUser.php";
	public JSONArray getSyncUser() throws ParseException, IOException{
		 HttpPost httpRequest = new HttpPost(this.userURL);
	 	 @SuppressWarnings({ "resource" })
		 HttpClient httpClient = new DefaultHttpClient();
		 HttpResponse httpResponse = httpClient.execute(httpRequest);
			
	     JSONArray userRes = null;
		 String result = null;
	     if(httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
				//get the response entity
	    	 		result = EntityUtils.toString(httpResponse.getEntity());
	    	 		userRes = new JSONArray(result);
	    	 }
		return userRes;
		
	}

}

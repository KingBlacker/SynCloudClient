package com.npt.test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpConnection;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;




@SuppressWarnings({ "deprecation", "unused" })
public class PostClient{
	public static void main(String args[]) throws ClientProtocolException, IOException{

		String url = "http://127.0.0.1/SynCloudServer/Test/server_post.php";
        HttpPost httpRequest = new HttpPost(url);
        
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("username", "zhpmatrix"));
        params.add(new BasicNameValuePair("password", "121345"));
   

     

        HttpEntity httpEntity = new UrlEncodedFormEntity(params,"utf-8");
		httpRequest.setEntity(httpEntity);
			
		@SuppressWarnings({ "resource", "deprecation" })
		HttpClient httpClient = new DefaultHttpClient();
		HttpResponse httpResponse = httpClient.execute(httpRequest);
			
		if(httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
				String result = EntityUtils.toString(httpResponse.getEntity());
				System.out.println(result);

		}else{
				System.out.println("there is no result");
		}
		} 

}

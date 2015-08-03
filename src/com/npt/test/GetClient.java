package com.npt.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;


@SuppressWarnings("deprecation")
public class GetClient{

	public static void main(String[] args) throws ClientProtocolException, IOException{

	    @SuppressWarnings("resource")
	    HttpClient httpclient = new DefaultHttpClient();
	    
	    HttpGet httpgets = new HttpGet("http://127.0.0.1/SynCloudServer/Test/server.php?username=zhpmatrix"); 
        
        HttpResponse response = httpclient.execute(httpgets);  
        HttpEntity entity = response.getEntity();  
        
        if (entity != null) {  
            InputStream instreams = entity.getContent();  
            String str = convertStreamToString(instreams);
            System.out.println(str);
            
            /* Do not need the rest */  
            httpgets.abort();  
        }
	}
	
	/**
	 * convert the input stream into string to put out
	 * @param is
	 * @return string result
	 */
	public static String convertStreamToString(InputStream is) {    
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));    
        StringBuilder sb = new StringBuilder();    
     
        String line = null;    
        try {    
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");    
            }    
        } catch (IOException e) {    
            e.printStackTrace();    
        } finally {    
            try {    
                is.close();    
            } catch (IOException e) {    
               e.printStackTrace();    
            }    
        }    
        return sb.toString();    
    }

}
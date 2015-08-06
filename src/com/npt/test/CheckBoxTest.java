package com.npt.test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.JCheckBox;

import org.apache.http.ParseException;
import org.json.JSONArray;

import com.npt.service.SyncUser;

public class CheckBoxTest {
	public static void main(String args[]) throws ParseException, IOException{
		HashMap<String,JCheckBox> group = new HashMap<String,JCheckBox>();
		SyncUser su = new SyncUser();
		JSONArray result = su.getSyncUser();
		
		for(int i = 0;i < result.length();i++){
			System.out.println(result.getString(i));
			group.put("checkbox"+String.valueOf(i),new JCheckBox(result.getString(i)));
		}
		
		
		Iterator<String> iterator3 = group.keySet().iterator();
		while (iterator3.hasNext()) { 
		        System.out.println(iterator3.next());
		 }
		
		Iterator<String> iterator = group.keySet().iterator();
		while (iterator.hasNext()) { 
		        group.get(iterator.next()).setName("checkbox...");
		 }
		
		Iterator<String> iterator2 = group.keySet().iterator();
		while (iterator2.hasNext()) { 
		        System.out.println(group.get(iterator2.next()).getName());
		 }
		

	}

}

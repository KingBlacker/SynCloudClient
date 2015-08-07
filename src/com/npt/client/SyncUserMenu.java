package com.npt.client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.*;

import org.apache.http.ParseException;
import org.json.JSONArray;

import com.npt.client.FileChoose;
import com.npt.service.SyncUser;


@SuppressWarnings("serial")
public class SyncUserMenu extends JFrame {
	//define the filechoose object
	private FileChoose fileChoose;
	
	//selected user
	String selectedUser = "";
	JPanel panel01,panel02,panel03,panel;
	JLabel label;
	JButton button;
	
	//get the checkbox
	HashMap<String, JCheckBox> checkboxGroup;
	
	/**
	 * construction
	 * @param fileChoose
	 * @throws IOException 
	 * @throws ParseException 
	 */
	public SyncUserMenu(FileChoose fileChoose) throws ParseException, IOException{
		
		label = new JLabel("请选择同步用户：");
		panel = new JPanel();
	    panel01 = new JPanel();
		panel02 = new JPanel();
		panel03 = new JPanel();
		panel01.add(label);

		button = new JButton("确定");
		button.addActionListener(new ChooseListener(this));
	    checkboxGroup = this.checkBoxGroup();
		
		Iterator<String> iterator = checkboxGroup.keySet().iterator();
		while (iterator.hasNext()) { 
			panel02.add(checkboxGroup.get(iterator.next()));
		 }
		
		panel03.add(button);
		
		JScrollPane pane = new JScrollPane(panel02, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		this.add(panel01);
		this.add(pane);
		this.add(panel03);
		
		this.setLayout(new BoxLayout(getContentPane(),BoxLayout.Y_AXIS));
		
		this.setSize(300,300);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setTitle("同步用户选择");
		
		this.setFileChoose(fileChoose);
	}
	private HashMap<String, JCheckBox> checkBoxGroup() throws ParseException, IOException{
		HashMap<String,JCheckBox> group = new HashMap<String,JCheckBox>();
		SyncUser su = new SyncUser();
		JSONArray result = su.getSyncUser();
		for(int i = 0;i < result.length();i++){
			group.put("checkbox"+String.valueOf(i),new JCheckBox(result.getString(i)));
		}
		return group;
	}
	
	//set the object reference
	public void setFileChoose(FileChoose fileChoose){
		this.fileChoose = fileChoose;
	}
	
	//set the text field
	public void setTextField(String msg){
		this.fileChoose.text2.setText(msg);
		
	}
	
	/**
	 * ChooseListener
	 * @author zhpmatrix
	 *
	 */
	class ChooseListener implements ActionListener{
		private SyncUserMenu adaptee;
		ChooseListener(SyncUserMenu adaptee) {
	        this.adaptee = adaptee;
	    }
		public void actionPerformed(ActionEvent e) {
	        adaptee.jButton1_actionPerformed(e);
	    }
	}
	
	/**
	 * Get the results of the CheckBox
	 * @param e
	 */
	public void jButton1_actionPerformed(ActionEvent e) {
		Iterator<String> iterator = checkboxGroup.keySet().iterator();
		while (iterator.hasNext()) {
			JCheckBox checkbox = checkboxGroup.get(iterator.next());
			if(checkbox.isSelected()){
				selectedUser += checkbox.getText();
			}
		 }
	     this.setTextField(this.selectedUser);
	     
	     //close the window
	     dispose();
	     
	    }


}

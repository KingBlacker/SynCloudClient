package com.npt.client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import com.npt.client.FileChoose;


public class SyncUserMenu extends JFrame {
	
	//define the filechoose object
	private FileChoose fileChoose;
	
	//selected user
	String selectedUser = "";
	
	JCheckBox checkbox01,checkbox02,checkbox03,checkbox04,checkbox05;
	JPanel panel01,panel02,panel03,panel;
	JLabel label;
	JButton button;
	
	public SyncUserMenu(FileChoose fileChoose){
		label = new JLabel("请选择同步用户：");
		checkbox01 = new JCheckBox("老王");
		checkbox02 = new JCheckBox("老李");
		checkbox03 = new JCheckBox("老孙");
		checkbox04 = new JCheckBox("老朱");
		checkbox05 = new JCheckBox("老沙");
		button = new JButton("确定");
		button.addActionListener(new ChooseListener(this));
		panel01 = new JPanel();
		panel02 = new JPanel();
		panel03 = new JPanel();
		panel = new JPanel();
		
		panel01.add(label);
		
		panel02.add(checkbox01);
		panel02.add(checkbox02);
		panel02.add(checkbox03);
		panel02.add(checkbox04);
		panel02.add(checkbox05);
		
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
	
	//set the object reference
	public void setFileChoose(FileChoose fileChoose){
		this.fileChoose = fileChoose;
	}
	
	//set the text field
	public void setTextField(String msg){
		this.fileChoose.text2.setText(msg);
		
	}
	
	class ChooseListener implements ActionListener{
		private SyncUserMenu adaptee;
		ChooseListener(SyncUserMenu adaptee) {
	        this.adaptee = adaptee;
	    }
		public void actionPerformed(ActionEvent e) {
	        adaptee.jButton1_actionPerformed(e);
	    }
	}
	public void jButton1_actionPerformed(ActionEvent e) {
		if(checkbox01.isSelected()){
	      this.selectedUser=checkbox01.getText();
	     }
	     if(checkbox02.isSelected()){;
	      selectedUser = selectedUser+checkbox02.getText();
	     }
	     if(checkbox03.isSelected()){
	      selectedUser = selectedUser+checkbox03.getText();
	     }
	     if(checkbox04.isSelected()){
	    	 selectedUser = selectedUser+checkbox04.getText();
		 }
	     if(checkbox05.isSelected()){
		      selectedUser = selectedUser+checkbox05.getText();
		 }
	     
	     //TODO set textfield
	     this.setTextField(this.selectedUser);
	     
	     //TODO close the window
	     dispose();
	     
	    }


}

package com.npt.SynClound;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;

import javax.swing.*;

public class SyncUserMenu extends JFrame {
	JCheckBox checkbox01,checkbox02,checkbox03,checkbox04,checkbox05;
	JPanel panel01,panel02,panel03,panel;
	JLabel label;
	JButton button;
	//StringBuffer choice;
	
	public SyncUserMenu(){
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
		
	/*	checkbox01.addItemListener((ItemListener) this);
		checkbox02.addItemListener((ItemListener) this);
		checkbox03.addItemListener((ItemListener) this);
		checkbox04.addItemListener((ItemListener) this);*/
		
		panel01.add(label);
		
		panel02.add(checkbox01);
		panel02.add(checkbox02);
		panel02.add(checkbox03);
		panel02.add(checkbox04);
		panel02.add(checkbox05);
		
		panel03.add(button);
		
		panel.add(panel01);
		panel.add(panel02);
		panel.add(panel03);
		
		this.add(panel);
		
		this.setLayout(new BoxLayout(getContentPane(),BoxLayout.Y_AXIS));
		
		this.setSize(400,1000);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setTitle("同步用户选择");
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
	    // System.out.println("性别："+(jRadioButton1.isSelected()?jRadioButton1.getText():jRadioButton2.getText()));
	     if(checkbox01.isSelected()){
	      System.out.println(checkbox01.getText());
	     }
	     if(checkbox02.isSelected()){
	      System.out.println(checkbox02.getText());
	     }
	     if(checkbox03.isSelected()){
	      System.out.println(checkbox03.getText());
	     }
	     if(checkbox04.isSelected()){
	    	 System.out.println(checkbox04.getText());
		 }
	     if(checkbox05.isSelected()){
		      System.out.println(checkbox05.getText());
		 }
	    }
	
	
	public static void main(String[]  args){
		SyncUserMenu frame=new SyncUserMenu();
		  frame.setBounds(100, 100, 200, 300);
		  frame.setVisible(true);
	}
}
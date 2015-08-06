package com.npt.client;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Login extends JFrame{
	JTextField text01;
	JPasswordField text02;
	JLabel label01,label02;
	JButton button01,button02;
	JPanel panel01,panel02,panel03;
	public Login(){
		text01 = new JTextField(10);
		text02 = new JPasswordField(10);
		label01 = new JLabel("用户名：");
		label02 = new JLabel("密码     ：");
		button01 = new JButton("登录");
		button01.addActionListener(new addListener());
		button02 = new JButton("注册");
		button02.addActionListener(new RegisterListener());
		panel01 = new JPanel();
		panel02 = new JPanel();
		panel03 = new JPanel();
		
		this.setLayout(new FlowLayout());
		
		panel01.add(label01);
		panel01.add(text01);
		
		panel02.add(label02);
		panel02.add(text02);
		
		panel03.add(button01);
		panel03.add(button02);
		
		this.add(panel01);
		this.add(panel02);
		this.add(panel03);
		
		this.setSize(250,250);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setTitle("SynCloud");
	}
	
	//TODO Login
	class addListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(e.getActionCommand()=="登录"){
				dispose();
				new MainMenu();
			}
		}
	}//class addListener
	
	//TODO regist
	class RegisterListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(e.getActionCommand()=="注册"){
				dispose();
				new Register();
				
			}
		}
	}//class RegisterListener
	
	public static void main(String[]  args){
		new Login();
	}
}

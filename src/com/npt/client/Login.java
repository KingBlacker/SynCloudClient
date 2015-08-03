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
		//panel = new JPanel();
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
	
	class addListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(e.getActionCommand()=="登录"){
				System.out.println(text01.getText());
				System.out.println(text02.getText());
			}
		}
	}
	
	class RegisterListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(e.getActionCommand()=="注册"){
				JFrame frame01 = new JFrame();
				frame01.setTitle("用户注册");
				frame01.setSize(250,250);
				Container container01 =frame01.getContentPane();
				JPanel panel = new JPanel();
				JPanel panel01 = new JPanel();
				JPanel panel02 = new JPanel();
				JPanel panel03 = new JPanel();
				JPanel panel04 = new JPanel();
				JLabel label01 = new JLabel("用户名    ：");
				JLabel label02 = new JLabel("密码         ：");
				JLabel label03 = new JLabel("确认密码：");
				JTextField text01 = new JTextField(10);
				JPasswordField text02 = new JPasswordField(10);
				JPasswordField text03 = new JPasswordField(10);
				JButton button = new JButton("确认");
				button.addActionListener(new UserRegisterListener());
				panel01.add(label01);
				panel01.add(text01);
				
				panel02.add(label02);
				panel02.add(text02);
				
				panel03.add(label03);
				panel03.add(text03);
				
				panel04.add(button);
				
				panel.add(panel01);
				panel.add(panel02);
				panel.add(panel03);
				panel.add(panel04);
				
				container01.add(panel,BorderLayout.CENTER);
				frame01.setVisible(true);
				
			}
		}
	}
	
	class UserRegisterListener implements ActionListener{
		JTextField text01 = new JTextField();
		JPasswordField text02 = new JPasswordField();
		JPasswordField text03 = new JPasswordField();
		public void actionPerformed(ActionEvent e){
			if(e.getActionCommand()=="确认"){
				System.out.println(text01.getText());
				System.out.println(text02.getText());
				System.out.println(text03.getText());
			}
		}
	}
	
	public static void main(String[]  args){
		new Login();
	}
}

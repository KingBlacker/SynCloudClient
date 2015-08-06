package com.npt.client;
import javax.swing.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Register extends JFrame{
		JTextField text01;
		JPasswordField text02,text03;
		JPanel panel01,panel02,panel03,panel04;
		JLabel label01,label02,label03;
		JButton button;
		public Register(){
			text01 = new JTextField(10);
			text02 = new JPasswordField(10);
			text03 = new JPasswordField(10);
			label01 = new JLabel("用户名    ：");
			label02 = new JLabel("密码         ：");
			label03 = new JLabel("确认密码：");
			button = new JButton("确认");
			button.addActionListener(new UserRegisterListener());
			panel01 = new JPanel();
			panel02 = new JPanel();
			panel03 = new JPanel();
			panel04 = new JPanel();
			
			this.setLayout(new FlowLayout());
			
			panel01.add(label01);
			panel01.add(text01);
			
			panel02.add(label02);
			panel02.add(text02);
			
			panel03.add(label03);
			panel03.add(text03);
			
			panel04.add(button);
			
			this.add(panel01);
			this.add(panel02);
			this.add(panel03);
			this.add(panel04);
			
			this.setSize(250,250);
			
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setVisible(true);
			this.setTitle("用户注册");
		}
		
		class UserRegisterListener implements ActionListener{
			public void actionPerformed(ActionEvent e){
				if(e.getActionCommand()=="确认"){
					dispose();
					new Login();
				}
			}
		}//class UserRegisterListener
}

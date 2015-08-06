package com.npt.client;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


@SuppressWarnings("serial")
public class Setting extends JFrame{
	
	JLabel label01,label02,label03,label04;
	JTextField text01,text02,text03;
	JPasswordField text04;
	JButton button;
	JPanel panel01,panel02,panel03,panel04 ,panel05;
	
	public Setting(){
		
		label01 = new JLabel("同步开始时间：");
		label02 = new JLabel("同步       周期：");
		label03 = new JLabel("计算机用户名：");
		label04 = new JLabel("帐号登录密码：");
		text01 = new JTextField(20);
		text02 = new JTextField(20);
		text03 = new JTextField(20);
		text04 = new JPasswordField(20);
		button = new JButton("确定");
		button.addActionListener(new SettingListen());
		panel01 = new JPanel();
		panel02 = new JPanel();
		panel03 = new JPanel();
		panel04 = new JPanel();
		panel05 = new JPanel();
		
		this.setLayout(new FlowLayout());
		
		panel01.add(label01);
		panel01.add(text01);
		
		panel02.add(label02);
		panel02.add(text02);
		
		panel03.add(label03);
		panel03.add(text03);
		
		panel04.add(label04);
		panel04.add(text04);
		
		panel05.add(button);
		
		this.add(panel01);
		this.add(panel02);
		this.add(panel03);
		this.add(panel04);
		this.add(panel05);
		
		this.setSize(400, 300);
	
		this.setVisible(true);
		this.setTitle("同步设置");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
	}
	/**
	 * Setting Listener
	 * @author zhpmatrix
	 *
	 */
	class SettingListen implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(e.getActionCommand()=="确定"){
				dispose();
			}
		}
	}//class SettingListen

}

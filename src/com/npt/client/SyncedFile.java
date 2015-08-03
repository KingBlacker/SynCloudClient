package com.npt.client;

import java.awt.*;
import javax.swing.*;

public class SyncedFile extends JFrame {
	JLabel label01,label02;
	JButton button01,button02;
	JPanel panel01,panel02,panel;
	
	public SyncedFile(){
		label01 = new JLabel("你好");
		label02 = new JLabel("hello");
		button01 = new JButton("查看同步用户");
		button02 = new JButton("查看同步用户");
		panel01 = new JPanel();
		panel02 = new JPanel();
		panel = new JPanel();
		
		panel01.add(label01);
		panel01.add(button01);
		
		panel02.add(label02);
		panel02.add(button02);
		
		panel.add(panel01);
		panel.add(panel02);
		
		this.add(panel);
		
		this.setLayout(new FlowLayout());
		
		this.setSize(400,1000);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setTitle("已同步文件");
	}
	
	public static void main(String[]  args){
		new SyncedFile();
	} 
}

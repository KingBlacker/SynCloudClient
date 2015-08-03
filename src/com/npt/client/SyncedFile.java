package com.npt.SynClound;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class SyncedFile extends JFrame {
	JLabel label01,label02;
	JButton button01,button02;
	JPanel panel01,panel02,panel;
	
	public SyncedFile(){
		label01 = new JLabel("你好");
		label02 = new JLabel("hello");
		button01 = new JButton("查看同步用户");
		button01.addActionListener(new ShowUserListener());
		button02 = new JButton("查看同步用户");
		button02.addActionListener(new ShowUserListener());
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
	
	class ShowUserListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(e.getActionCommand() == "查看同步用户"){
				JFrame frame = new JFrame();
				frame.setSize(300,300);
				frame.setTitle("同步用户");
				Container container = frame.getContentPane();
				JPanel panel = new JPanel();
				JPanel panel01 = new JPanel();
				JPanel panel02 = new JPanel();
				JLabel label01 = new JLabel("查看同步用户：");
				JLabel label02 = new JLabel("张三");
				JLabel label03 = new JLabel("李四");
				JLabel label04 = new JLabel("王五");
				JLabel label05 = new JLabel("赵六");	
				
				panel01.add(label01);
				
				panel02.add(label02);
				panel02.add(label03);
				panel02.add(label04);
				panel02.add(label05);
				
				panel.add(panel01);
				panel.add(panel02);
				
				container.add(panel,BorderLayout.CENTER);
				frame.setVisible(true);
			}
		}
	}
	
	public static void main(String[]  args){
		new SyncedFile();
	} 
}

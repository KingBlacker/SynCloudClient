package com.npt.SynCloud;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class SyncedFile extends JFrame {
	JLabel label01,label02,label03,label04;
	JButton button01,button02,button03,button04,button05,button06;
	JPanel panel01,panel02,panel03,panel04,panel05,panel06,panel;
	
	public SyncedFile(){
		label01 = new JLabel("逗比张");
		button01 = new JButton("打开");
		button02 = new JButton("同步");
		button03 = new JButton("设置");
		button04 = new JButton("已同步文件");
		button01.addActionListener(new OpenFileListener());
		//button02.addActionListener(new OpenFileListener());
		button03.addActionListener(new OpenFileListener());
		button04.addActionListener(new OpenFileListener());
		label02 = new JLabel("已同步文件：");
		label03 = new JLabel("你好");
		label04 = new JLabel("hello");
		button05 = new JButton("查看同步用户");
		button05.addActionListener(new ShowUserListener());
		button06 = new JButton("查看同步用户");
		button06.addActionListener(new ShowUserListener());
		panel01 = new JPanel();
		panel02 = new JPanel();
		panel03 = new JPanel();
		panel04 = new JPanel();
		panel05 = new JPanel();
		panel06 = new JPanel();
		panel = new JPanel();
		
		panel01.add(label01);
		
		panel02.add(button01);
		panel02.add(button02);
		panel02.add(button03);
		panel02.add(button04);
		
		panel03.add(label02);
		
		panel04.add(label03);
		panel04.add(button05);
		
		panel05.add(label04);
		panel05.add(button06);
		
		panel.add(panel01);
		panel.add(panel02);
		panel.add(panel03);
		
		panel06.add(panel04);
		panel06.add(panel05);
		
		JScrollPane pane = new JScrollPane(panel06, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		this.add(panel);
		this.add(pane);
		
		this.setLayout(new BoxLayout(getContentPane(),BoxLayout.Y_AXIS));
		
		this.setSize(350,700);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setTitle("SynCloud");
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
	}//class ShowUserListener
	
	class OpenFileListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(e.getActionCommand()=="打开"){
				dispose();
				new FileChoose();
			}
			else if (e.getActionCommand()=="设置"){
				new Setting();
			}
			else if (e.getActionCommand()=="已同步文件"){
				dispose();
				new SyncedFile();
			}
		}
	}//class OpenFileListener
}

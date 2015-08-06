package com.npt.client;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class MainMenu extends JFrame{
		//JTable table;
		JPanel panel01,panel02,panel;
		JLabel label01;
		JButton button01,button02,button03,button04;
		public MainMenu(){
			label01 = new JLabel("逗比张");
			//label01.setVerticalAlignment(SwingConstants.LEFT);
			button01 = new JButton("打开");
			button02 = new JButton("同步");
			button03 = new JButton("设置");
			button04 = new JButton("已同步文件");
			button01.addActionListener(new OpenFileListener());
			//button01.addActionListener(new OpenFileListener());
			button03.addActionListener(new OpenFileListener());
			button04.addActionListener(new OpenFileListener());
			panel01 = new JPanel();
			panel02 = new JPanel();
			panel = new JPanel();
			
			this.setLayout(new FlowLayout());
			
			panel01.add(label01);
			
			panel02.add(button01);
			panel02.add(button02);
			panel02.add(button03);
			panel02.add(button04);
			
			this.add(panel01);
			this.add(panel02);
			//panel.add(panel01);
			//panel.add(panel02);
			
			//JScrollPane scrollpane = new JScrollPane(panel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			
			//this.add(scrollpane);
			
			this.setSize(350,700);
			
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setVisible(true);
			this.setTitle("SynCloud");
		}
		
		class OpenFileListener implements ActionListener{
			public void actionPerformed(ActionEvent e){
				if(e.getActionCommand()=="打开"){
					/*JFileChooser chooser = new JFileChooser();
					chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
					int ret = chooser.showOpenDialog(button01);
					if (ret == JFileChooser.APPROVE_OPTION) {
					File dir = chooser.getSelectedFile();
					// dir is the selected directory
					System.out.println(dir);
					}*/
					dispose();
					new OpenFile();
				}
				else if (e.getActionCommand()=="设置"){
					new Setting();
				}
				else if (e.getActionCommand()=="已同步文件"){
					new SyncedFile();
				}
			}
				
		}
}
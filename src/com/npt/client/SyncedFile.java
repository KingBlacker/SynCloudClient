package com.npt.client;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

@SuppressWarnings("serial")
public class SyncedFile extends JFrame {
	
	JLabel label01,label02,label03,label04;
	JButton button01,button02,button03,button04,button05,button06;
	JPanel panel01,panel02,panel;
	
	public SyncedFile(){
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    String laf = UIManager.getSystemLookAndFeelClassName();
	    //检查jdk版本，是否支持GroupLayout布局
	    try {
	         UIManager.setLookAndFeel(laf);
	    } catch (UnsupportedLookAndFeelException exc) {
	     System.err.println("Warning: UnsupportedLookAndFeel: " + laf);
	    } catch (Exception exc) {
	     System.err.println("Error loading " + laf + ": " + exc);
	    }
		
		label01 = new JLabel("同步文件");
		button01 = new JButton("打开");
		button02 = new JButton("同步");
		button03 = new JButton("设置");
		button04 = new JButton("已同步文件");
		button01.addActionListener(new OpenFileListener());
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
		panel = new JPanel();
		
		panel01.add(label03);
		panel01.add(button05);
		
		panel02.add(label04);
		panel02.add(button06);
		
		panel.add(panel01);
		panel.add(panel02);
		
		JScrollPane pane = new JScrollPane(panel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		Container c = getContentPane();
		GroupLayout layout = new GroupLayout(c);
		c.setLayout(layout);
		
		//自动设定组件、组之间的间隙
	    layout.setAutoCreateGaps(true);
	    layout.setAutoCreateContainerGaps(true);

	    //LEADING -- 左对齐    BASELINE -- 底部对齐  CENTER -- 中心对齐
	    GroupLayout.SequentialGroup hpg1a = layout.createSequentialGroup();
	    hpg1a.addComponent(button01);
	    hpg1a.addComponent(button02);
	    hpg1a.addComponent(button03);
	    hpg1a.addComponent(button04);
	  
	    GroupLayout.ParallelGroup hpg1 = layout.createParallelGroup(GroupLayout.Alignment.CENTER);
	    hpg1.addComponent(label01);
	    hpg1.addGroup(hpg1a);
	    hpg1.addComponent(label02);
	    hpg1.addComponent(pane);

	    //水平
	    layout.setHorizontalGroup(layout.createSequentialGroup().addGroup(hpg1));    
	    
	    //设定两个Button在水平方向一样宽
	    layout.linkSize(SwingConstants.HORIZONTAL,new Component[] { button01, button02,button03});

	    GroupLayout.ParallelGroup vpg1 = layout.createParallelGroup(GroupLayout.Alignment.BASELINE);
	    vpg1.addComponent(label01);
	    
	    GroupLayout.ParallelGroup vpg2 = layout.createParallelGroup(GroupLayout.Alignment.BASELINE);
	    vpg2.addComponent(button01);
	    vpg2.addComponent(button02);
	    vpg2.addComponent(button03);
	    vpg2.addComponent(button04);

	    GroupLayout.ParallelGroup vpg3 = layout.createParallelGroup(GroupLayout.Alignment.BASELINE);
	    vpg3.addComponent(label02);
	    
	    GroupLayout.ParallelGroup vpg4 = layout.createParallelGroup(GroupLayout.Alignment.BASELINE);
	    vpg4.addComponent(pane);

	   //垂直
	   layout.setVerticalGroup(layout.createSequentialGroup().addGroup(vpg1).addGroup(vpg2).addGroup(vpg3).addGroup(vpg4));
	    
	    setLocation(200,200);
	    pack();
		setSize(320,700);
		setVisible(true);
		setTitle("SynCloud");
	}
	
	/**
	 * ShowUserListener Class
	 * @author zhpmatrix
	 *
	 */
	class ShowUserListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(e.getActionCommand() == "查看同步用户"){
				new ShowSyncedUser();
			}
		}
	}//class ShowUserListener
	
	/**
	 * OpenFileListener Object
	 * 
	 * @author zhpmatrix
	 *
	 */
	class OpenFileListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(e.getActionCommand()=="打开"){
				dispose();
				new FileChoose();
			}
			else if (e.getActionCommand()=="设置"){
				dispose();
				new MainMenu();
				new Setting();
			}
			else if (e.getActionCommand()=="已同步文件"){
				dispose();
				new SyncedFile();
			}
		}
	}//class OpenFileListener
}

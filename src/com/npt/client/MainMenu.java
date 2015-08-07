package com.npt.client;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class MainMenu extends JFrame{
	
	    //define the variables
		JLabel label01;
		JButton button01,button02,button03,button04;
	    
		/**
	     * construction function
	     */
		public MainMenu(){
			
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
			
			label01 = new JLabel("主功能界面");
			
			button01 = new JButton("打开");
			button02 = new JButton("同步");
			button03 = new JButton("设置");
			
			button04 = new JButton("已同步文件");
			
			button01.addActionListener(new OpenFileListener());
			button03.addActionListener(new OpenFileListener());
			button04.addActionListener(new OpenFileListener());
			
			Container c = getContentPane();
			GroupLayout layout = new GroupLayout(c);
			c.setLayout(layout);
			
			//自动设定组件、组之间的间隙
		    layout.setAutoCreateGaps(true);
		    layout.setAutoCreateContainerGaps(true);

		    //LEADING -- 左对齐    BASELINE -- 底部对齐  CENTER -- 中心对齐
		    GroupLayout.ParallelGroup hpg1 = layout.createParallelGroup(GroupLayout.Alignment.LEADING);
		    hpg1.addComponent(button01);

		    GroupLayout.SequentialGroup hpg2a = layout.createSequentialGroup();
		    hpg2a.addComponent(button02);
		    hpg2a.addComponent(button03);
		  
		    GroupLayout.ParallelGroup hpg2 = layout.createParallelGroup(GroupLayout.Alignment.CENTER);
		    hpg2.addComponent(label01);
		    hpg2.addGroup(hpg2a);
		    
		    GroupLayout.ParallelGroup hpg3 = layout.createParallelGroup(GroupLayout.Alignment.LEADING);
		    hpg3.addComponent(button04);

		    //水平
		    layout.setHorizontalGroup(layout.createSequentialGroup().addGroup(hpg1).addGroup(hpg2).addGroup(hpg3));    
		    
		    //设定两个Button在水平方向一样宽
		    layout.linkSize(SwingConstants.HORIZONTAL,new Component[] { button01, button02,button03});

		    GroupLayout.ParallelGroup vpg1 = layout.createParallelGroup(GroupLayout.Alignment.BASELINE);
		    vpg1.addComponent(label01);
		    
		    GroupLayout.ParallelGroup vpg2 = layout.createParallelGroup(GroupLayout.Alignment.BASELINE);
		    vpg2.addComponent(button01);
		    vpg2.addComponent(button02);
		    vpg2.addComponent(button03);
		    vpg2.addComponent(button04);

		   //垂直
		   layout.setVerticalGroup(layout.createSequentialGroup().addGroup(vpg1).addGroup(vpg2));
		    
		    setLocation(200,200);
		    pack();
			setVisible(true);
			setSize(320,700);
			setTitle("SynCloud");
		}
		
		/**
		 * set the listener for OpenFile
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
					new Setting();
				}
				else if (e.getActionCommand()=="已同步文件"){
					dispose();
					new SyncedFile();
				}
			}
				
		}//class OpenFileListener
}

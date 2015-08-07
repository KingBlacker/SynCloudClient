package com.npt.client;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

@SuppressWarnings("serial")
public class Login extends JFrame{
	
	/**
	 * the main function here
	 * @param args
	 */
	public static void main(String[]  args){
		new Login();
	}
	
	/**
	 * define the variable here
	 */
	JTextField text01;
	JPasswordField text02;
	
	JLabel label01,label02;
	JButton button01,button02;
	
	/**
	 * construction function
	 */
	public Login(){
		super("SynCloud");
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
	    
		text01 = new JTextField(10);
		text02 = new JPasswordField(10);
		label01 = new JLabel("用户名：");
		label02 = new JLabel("密  码：");
		
		button01 = new JButton("登录");
		button01.addActionListener(new addListener());
		
		button02 = new JButton("注册");
		button02.addActionListener(new RegisterListener());
		
		Container c = getContentPane();
		GroupLayout layout = new GroupLayout(c);
		c.setLayout(layout);
		
		//自动设定组件、组之间的间隙
	    layout.setAutoCreateGaps(true);
	    layout.setAutoCreateContainerGaps(true);

	    //LEADING -- 左对齐    BASELINE -- 底部对齐  CENTER -- 中心对齐
	    GroupLayout.ParallelGroup hpg1 = layout.createParallelGroup(GroupLayout.Alignment.LEADING);
	    hpg1.addComponent(label01);
	    hpg1.addComponent(label02);

	    GroupLayout.SequentialGroup hpg2a = layout.createSequentialGroup();
	    hpg2a.addComponent(button01);
	    hpg2a.addComponent(button02);
	  
	    GroupLayout.ParallelGroup hpg2 = layout.createParallelGroup(GroupLayout.Alignment.LEADING);
	    hpg2.addComponent(text01);
	    hpg2.addComponent(text02);
	    hpg2.addGroup(hpg2a);

	    //水平
	    layout.setHorizontalGroup(layout.createSequentialGroup().addGroup(hpg1).addGroup(hpg2));    
	    
	    //设定两个Button在水平方向一样宽
	    layout.linkSize(SwingConstants.HORIZONTAL,new Component[] { button01, button02});

	    GroupLayout.ParallelGroup vpg1 = layout.createParallelGroup(GroupLayout.Alignment.BASELINE);
	    vpg1.addComponent(label01);
	    vpg1.addComponent(text01);
	    
	    GroupLayout.ParallelGroup vpg2 = layout.createParallelGroup(GroupLayout.Alignment.BASELINE);
	    vpg2.addComponent(label02);
	    vpg2.addComponent(text02);

	    GroupLayout.ParallelGroup vpg3 = layout.createParallelGroup(GroupLayout.Alignment.BASELINE);
	    vpg3.addComponent(button01);
	    vpg3.addComponent(button02);

	   //垂直
	   layout.setVerticalGroup(layout.createSequentialGroup().addGroup(vpg1).addGroup(vpg2).addGroup(vpg3));
	    
	    setLocation(200,200);
	    pack();
	    setVisible(true);
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

}

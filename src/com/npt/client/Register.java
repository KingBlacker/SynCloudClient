package com.npt.client;
import javax.swing.*;

import org.apache.http.ParseException;

import com.npt.service.UserRegist;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

@SuppressWarnings("serial")
public class Register extends JFrame{
	
		JTextField text01;
		JPasswordField text02,text03;
		JPanel panel01,panel02,panel03,panel04;
		JLabel label01,label02,label03;
		JButton button;
	
		public Register(){
			
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
		
			text01 = new JTextField();
			text02 = new JPasswordField();
			text03 = new JPasswordField();
			
			label01 = new JLabel("用户名:");
			label02 = new JLabel("密码:");
			label03 = new JLabel("确认密码:");
			
			button = new JButton("确认");
			button.addActionListener(new UserRegisterListener());
			
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
		    hpg1.addComponent(label03);

		    GroupLayout.ParallelGroup hpg2 = layout.createParallelGroup(GroupLayout.Alignment.LEADING);
		    hpg2.addComponent(text01);
		    hpg2.addComponent(text02);
		    hpg2.addComponent(text03);
		    hpg2.addComponent(button);
		    
		    //水平方向
		    layout.setHorizontalGroup(layout.createSequentialGroup().addGroup(hpg1).addGroup(hpg2));
			
		    GroupLayout.ParallelGroup vpg1 = layout.createParallelGroup(GroupLayout.Alignment.BASELINE);
		    vpg1.addComponent(label01);
		    vpg1.addComponent(text01);
		    
		    GroupLayout.ParallelGroup vpg2 = layout.createParallelGroup(GroupLayout.Alignment.BASELINE);
		    vpg2.addComponent(label02);
		    vpg2.addComponent(text02);
		    
		    GroupLayout.ParallelGroup vpg3 = layout.createParallelGroup(GroupLayout.Alignment.BASELINE);
		    vpg3.addComponent(label03);
		    vpg3.addComponent(text03);
		    
		    GroupLayout.ParallelGroup vpg4 = layout.createParallelGroup(GroupLayout.Alignment.BASELINE);
		    vpg4.addComponent(button);
		    
		    //垂直
			layout.setVerticalGroup(layout.createSequentialGroup().addGroup(vpg1).addGroup(vpg2).addGroup(vpg3).addGroup(vpg4));
			
			setLocation(200,200);
		    pack();
			
		    setSize(250,200);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setVisible(true);
			setTitle("用户注册");
		}
		
		/**
		 * UserRegisterListener Class
		 * @author zhpmatrix
		 *
		 */
		class UserRegisterListener implements ActionListener{
			public void actionPerformed(ActionEvent e){
				if(e.getActionCommand()=="确认"){
					
					//regist the user
				    String username = text01.getText();
				    String userpwd = text02.getText();
					UserRegist reg = new UserRegist(username,userpwd);
					
				    try {
						reg.regist();
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				

					
					//dispost the current window
					dispose();
					
					//open a new window
					new Login();
				}
			}
		}//class UserRegisterListener
}

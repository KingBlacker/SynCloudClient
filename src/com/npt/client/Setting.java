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
	
	public Setting(){
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    String laf = UIManager.getSystemLookAndFeelClassName();
	    //检查jdk版本，是否支持GroupLayout布局
	    try {
	         UIManager.setLookAndFeel(laf);
	    } catch (UnsupportedLookAndFeelException exc) {
	     System.err.println("Warning: UnsupportedLookAndFeel: " + laf);
	    } catch (Exception exc) {
	     System.err.println("Error loading " + laf + ": " + exc);
	    }
		
		label01 = new JLabel("同步开始时间：");
		label02 = new JLabel("同步    周期：");
		label03 = new JLabel("计算机用户名：");
		label04 = new JLabel("帐号登录密码：");
		text01 = new JTextField(20);
		text02 = new JTextField(20);
		text03 = new JTextField(20);
		text04 = new JPasswordField(20);
		button = new JButton("确定");
		button.addActionListener(new SettingListen());
		
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
	    hpg1.addComponent(label04);
	  
	    GroupLayout.ParallelGroup hpg2 = layout.createParallelGroup(GroupLayout.Alignment.LEADING);
	    hpg2.addComponent(text01);
	    hpg2.addComponent(text02);
	    hpg2.addComponent(text03);
	    hpg2.addComponent(text04);
	    hpg2.addComponent(button);

	    //水平
	    layout.setHorizontalGroup(layout.createSequentialGroup().addGroup(hpg1).addGroup(hpg2));    
	    
	    //设定两个Button在水平方向一样宽
	    layout.linkSize(SwingConstants.HORIZONTAL,new Component[] { text01, text02,text03,text04});

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
	    vpg4.addComponent(label04);
	    vpg4.addComponent(text04);
	    
	    GroupLayout.ParallelGroup vpg5 = layout.createParallelGroup(GroupLayout.Alignment.CENTER);
	    vpg5.addComponent(button);
	    
	   //垂直
	   layout.setVerticalGroup(layout.createSequentialGroup().addGroup(vpg1).addGroup(vpg2).addGroup(vpg3).addGroup(vpg4).addGroup(vpg5));
	    
	    setLocation(200,200);
	    pack();
		setVisible(true);
		setTitle("同步设置");
		
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

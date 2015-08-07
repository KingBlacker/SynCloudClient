package com.npt.client;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;

public class SaveFile extends JFrame{
	JLabel label;
	JTextField text;
	JButton button01,button02,button03;
	
	public SaveFile(){
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
		
		label = new JLabel("消息");
		button01 = new JButton("...");
		button01.addActionListener(new SaveFileListener());
		button02 = new JButton("取消");
		button02.addActionListener(new CloseListener());
		button03 = new JButton("保存");
		button03.addActionListener(new CloseListener());
		text = new JTextField();
		
		Container c = getContentPane();
		GroupLayout layout = new GroupLayout(c);
		c.setLayout(layout);
		
		//自动设定组件、组之间的间隙
	    layout.setAutoCreateGaps(true);
	    layout.setAutoCreateContainerGaps(true);

	    //LEADING -- 左对齐    BASELINE -- 底部对齐  CENTER -- 中心对齐
	    GroupLayout.SequentialGroup hpg1a = layout.createSequentialGroup();
	    hpg1a.addComponent(text);
	    hpg1a.addComponent(button01);
	  
	    GroupLayout.SequentialGroup hpg1b = layout.createSequentialGroup();
	    hpg1b.addComponent(button03);
	    hpg1b.addComponent(button02);
	    
	    GroupLayout.ParallelGroup hpg1 = layout.createParallelGroup(GroupLayout.Alignment.CENTER);
	    hpg1.addComponent(label);
	    hpg1.addGroup(hpg1a);
	    hpg1.addGroup(hpg1b);

	    //水平
	    layout.setHorizontalGroup(layout.createSequentialGroup().addGroup(hpg1));    
	    
	    //设定两个Button在水平方向一样宽
	    layout.linkSize(SwingConstants.HORIZONTAL,new Component[] { button01, button02,button03});

	    GroupLayout.ParallelGroup vpg1 = layout.createParallelGroup(GroupLayout.Alignment.BASELINE);
	    vpg1.addComponent(label);
	    
	    GroupLayout.ParallelGroup vpg2 = layout.createParallelGroup(GroupLayout.Alignment.BASELINE);
	    vpg2.addComponent(text);
	    vpg2.addComponent(button01);
	    
	    GroupLayout.ParallelGroup vpg3 = layout.createParallelGroup(GroupLayout.Alignment.BASELINE);
	    vpg3.addComponent(button03);
	    vpg3.addComponent(button02);

	   //垂直
	   layout.setVerticalGroup(layout.createSequentialGroup().addGroup(vpg1).addGroup(vpg2).addGroup(vpg3));
	    
	    setLocation(200,200);
	    pack();
		setSize(200,200);
		setVisible(true);
		setTitle("同步提醒");
	}
	
	class SaveFileListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			if (event.getSource().equals(button01)){
				JFileChooser jf = new JFileChooser();  
				jf.setFileSelectionMode(JFileChooser.SAVE_DIALOG | JFileChooser.DIRECTORIES_ONLY);  
				int state = jf.showDialog(null,null); 
				//int state=jf.showOpenDialog(null);//此句是打开文件选择器界面的触发语句
	             
	             if(state==1){
	                 return;//撤销则返回
	            }
	            else{
				File fi = jf.getSelectedFile();
				text.setText(fi.getAbsolutePath());
	            }
			}
		}
	}

	class CloseListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if (e.getActionCommand()=="取消"){
				dispose();
			}
			if (e.getActionCommand()=="保存"){
				String f = text.getText()+"\\test.txt";  
				System.out.println("save: "+f);  
				try{  
				    FileWriter out = new FileWriter(f);  
				    out.write("successful!!!");  
				    out.close();  
				}  
				catch(Exception args0){
					args0.printStackTrace();
				}  
				dispose();
			}
		}
	}
	
	public static void main(String[] args){
		new SaveFile();
	}
}

package com.npt.client;

import javax.swing.*;

import org.apache.http.ParseException;

import com.npt.client.SyncUserMenu;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class FileChoose extends JFrame{

	private static final long serialVersionUID = 1L;
	
	JFrame frame = new JFrame("SynCloud");
	JPanel panel = new JPanel();
	JPanel panel01 = new JPanel();
	JPanel panel02 = new JPanel();
	JPanel panel03 = new JPanel();
	JPanel panel04 = new JPanel();
	
	JLabel label = new JLabel("文件选择");
	JButton button3 = new JButton("打开");
	JButton button4 = new JButton("同步");
	JButton button5 = new JButton("设置");
	JButton button6 = new JButton("已同步文件");
    
	JFrame frame01=new JFrame("文件及同步用户选择");
    JLabel label1=new JLabel("选择文件");
    JLabel label2=new JLabel("同步用户");
    
    JTextField text1=new JTextField(10);
    JTextField text2=new JTextField(10);
    
    JButton button1=new JButton("...");
    JButton button2=new JButton("...");
    
    public FileChoose(){
        
    		//下面两行是取得屏幕的高度和宽度
        double lx=Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        double ly=Toolkit.getDefaultToolkit().getScreenSize().getHeight();
    
        frame01.setLocation(new Point((int)(lx/2)-150,(int)(ly/2)-150));//设定窗口出现位置
        frame01.setSize(300,150);//设定窗口大小
       
        //下面设定标签等的出现位置和高宽
        label1.setBounds(10,10,70,20);
        label2.setBounds(10,30,100,20);
        text1.setBounds(80,10,120,20);
        text2.setBounds(80,30,120,20);
        button1.setBounds(210,10,50,20);
        button2.setBounds(210,30,50,20);
        
        button1.addActionListener(new OpenActionListener(this));//添加事件处理
        button2.addActionListener(new OpenActionListener(this));//添加事件处理
        
        panel03.add(label1);
        panel03.add(text1);
        panel03.add(button1);
        panel04.add(label2);
        panel04.add(text2);
        panel04.add(button2);
        
        button3.addActionListener(new ChoiceListener());
		button5.addActionListener(new ChoiceListener());
		button6.addActionListener(new ChoiceListener());
		
		panel01 = new JPanel();
		panel02 = new JPanel();
		panel = new JPanel();
		
		frame.setLayout(new FlowLayout());
		
		panel01.add(label);
		
		panel02.add(button3);
		panel02.add(button4);
		panel02.add(button5);
		panel02.add(button6);
		
		frame.add(panel01);
		frame.add(panel02);
		frame.add(panel03);
		frame.add(panel04);
		
		frame.setSize(350,700);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setTitle("SynCloud");
    }
    
    /**
     * OpenActionListener
     * @author zhpmatrix
     *
     */
    class OpenActionListener implements ActionListener{
    			private FileChoose fileChoose;
    			public OpenActionListener(FileChoose fileChoose){
    				this.fileChoose = fileChoose;
	 }
	 
	/**
	 * FileChooser Menu 
	 */
    public void actionPerformed(ActionEvent e){//事件处理
        if(e.getSource().equals(button1)){//判断触发方法的按钮是哪个
        		
        		JFileChooser jfc=new JFileChooser();//文件选择器
        		
        		jfc.setCurrentDirectory(new File("d:\\"));//文件选择器的初始目录定为d盘
        		
        		jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);//文件选定可以是文件或是目录
            
        		int state=jfc.showOpenDialog(null);//此句是打开文件选择器界面的触发语句
            
        		if(state==1){
                return;//撤销则返回
            }
            else{
                File f=jfc.getSelectedFile();//f为选择到的目录
                text1.setText(f.getAbsolutePath());
            }
        }
        if(e.getSource().equals(button2)){
        			
        			//transfer the FileChoose Object to SyncUserMenu to keep the value in the Object
        			SyncUserMenu user = null;
					try {
						user = new SyncUserMenu(this.fileChoose);
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
        			user.setVisible(true);
        	}
    		}
    }//class OpenActionListener
 
 
 class ChoiceListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(e.getActionCommand()=="打开"){
				frame.dispose();
				//create a new filechoose
				new FileChoose();
			}
			else if (e.getActionCommand()=="设置"){
				frame.dispose();
				new MainMenu();
				new Setting();
			}
			else if (e.getActionCommand()=="已同步文件"){
				frame.dispose();
				new SyncedFile();
			}
		}
			
	}//class ChoiceListener
 
 }

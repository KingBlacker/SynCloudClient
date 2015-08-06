package com.npt.client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class FileChoose extends JFrame{
	JFrame frame = new JFrame("SynCloud");
	JPanel panel = new JPanel();
	JPanel panel01 = new JPanel();
	JPanel panel02 = new JPanel();
	JPanel panel03 = new JPanel();
	JPanel panel04 = new JPanel();
	JLabel label = new JLabel("逗比张");
	JButton button3 = new JButton("打开");
	JButton button4 = new JButton("同步");
	JButton button5 = new JButton("设置");
	JButton button6 = new JButton("已同步文件");
    JFrame frame01=new JFrame("文件及同步用户选择");
    JTabbedPane tabPane=new JTabbedPane();//选项卡布局
    Container con=new Container();//布局1
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
        frame01.setContentPane(tabPane);//设置布局
       //下面设定标签等的出现位置和高宽
        label1.setBounds(10,10,70,20);
        label2.setBounds(10,30,100,20);
        text1.setBounds(80,10,120,20);
        text2.setBounds(80,30,120,20);
        button1.setBounds(210,10,50,20);
        button2.setBounds(210,30,50,20);
        button1.addActionListener(new OpenActionListener());//添加事件处理
        button2.addActionListener(new OpenActionListener());//添加事件处理
        panel03.add(label1);
        panel03.add(text1);
        panel03.add(button1);
        panel04.add(label2);
        panel04.add(text2);
        panel04.add(button2);
        //tabPane.add(con);//添加布局1
       // panel03.setVisible(true);//窗口可见
        //panel03.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//使能关闭窗口，结束程序
        
        button3.addActionListener(new ChoiceListener());
		//button4.addActionListener(new OpenFileListener());
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
		//panel.add(panel01);
		//panel.add(panel02);
		
		//JScrollPane scrollpane = new JScrollPane(panel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		//this.add(scrollpane);
		
		frame.setSize(350,700);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setTitle("SynCloud");
    }
 class OpenActionListener implements ActionListener{
    public void actionPerformed(ActionEvent e){//事件处理
        if(e.getSource().equals(button1)){//判断触发方法的按钮是哪个
        	JFileChooser jfc=new JFileChooser();//文件选择器
        	jfc.setCurrentDirectory(new File("d:\\"));//文件选择器的初始目录定为d盘
        	jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
            //jfc.setFileSelectionMode(1);//设定只能选择到文件夹
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
        	SyncUserMenu user = new SyncUserMenu();
        	text2.setText(user.a);
        	System.out.println(user.a);
        	//File f=jfc.getSelectedFile();//f为选择到的文件
            //text1.setText(f.getAbsolutePath());
           /* jfc.setFileSelectionMode(0);//设定只能选择到文件
            int state=jfc.showOpenDialog(null);//此句是打开文件选择器界面的触发语句
            if(state==1){
                return;//撤销则返回
            }
            else{
                File f=jfc.getSelectedFile();//f为选择到的文件
                text2.setText(f.getAbsolutePath());
           }*/
        }
    }
 }
 class ChoiceListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(e.getActionCommand()=="打开"){
				dispose();
				new FileChoose();
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

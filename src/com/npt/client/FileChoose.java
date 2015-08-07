package com.npt.client;
import javax.swing.*;

import java.awt.*;

import com.npt.client.SyncUserMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class FileChoose extends JFrame{

	private static final long serialVersionUID = 1L;
	
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
	    
        //下面设定标签等的出现位置和高宽
        label1.setBounds(10,10,70,20);
        label2.setBounds(10,30,100,20);
        text1.setBounds(80,10,120,20);
        text2.setBounds(80,30,120,20);
        button1.setBounds(210,10,50,20);
        button2.setBounds(210,30,50,20);
        
        button1.addActionListener(new OpenActionListener(this));//添加事件处理
        button2.addActionListener(new OpenActionListener(this));//添加事件处理
        
        button3.addActionListener(new ChoiceListener());
        button4.addActionListener(new ChoiceListener());
		button5.addActionListener(new ChoiceListener());
		button6.addActionListener(new ChoiceListener());
		
		Container c = getContentPane();
		GroupLayout layout = new GroupLayout(c);
		c.setLayout(layout);
		
		//自动设定组件、组之间的间隙
	    layout.setAutoCreateGaps(true);
	    layout.setAutoCreateContainerGaps(true);

	    //LEADING -- 左对齐    BASELINE -- 底部对齐  CENTER -- 中心对齐
	    GroupLayout.ParallelGroup hpg1 = layout.createParallelGroup(GroupLayout.Alignment.LEADING);
	    hpg1.addComponent(button3);
	    hpg1.addComponent(label1);
	    hpg1.addComponent(label2);

	    GroupLayout.SequentialGroup hpg2a = layout.createSequentialGroup();
	    hpg2a.addComponent(button4);
	    hpg2a.addComponent(button5);
	  
	    GroupLayout.ParallelGroup hpg2 = layout.createParallelGroup(GroupLayout.Alignment.CENTER);
	    hpg2.addComponent(label);
	    hpg2.addGroup(hpg2a);
	    hpg2.addComponent(text1);
	    hpg2.addComponent(text2);
	    
	    GroupLayout.ParallelGroup hpg3 = layout.createParallelGroup(GroupLayout.Alignment.LEADING);
	    hpg3.addComponent(button6);
	    hpg3.addComponent(button1);
	    hpg3.addComponent(button2);

	    //水平
	    layout.setHorizontalGroup(layout.createSequentialGroup().addGroup(hpg1).addGroup(hpg2).addGroup(hpg3));    
	    
	    //设定两个Button在水平方向一样宽
	    layout.linkSize(SwingConstants.HORIZONTAL,new Component[] { button1, button2,button3,button4,button5});

	    GroupLayout.ParallelGroup vpg1 = layout.createParallelGroup(GroupLayout.Alignment.BASELINE);
	    vpg1.addComponent(label);
	    
	    GroupLayout.ParallelGroup vpg2 = layout.createParallelGroup(GroupLayout.Alignment.BASELINE);
	    vpg2.addComponent(button3);
	    vpg2.addComponent(button4);
	    vpg2.addComponent(button5);
	    vpg2.addComponent(button6);

	    GroupLayout.ParallelGroup vpg3 = layout.createParallelGroup(GroupLayout.Alignment.BASELINE);
	    vpg3.addComponent(label1);
	    vpg3.addComponent(text1);
	    vpg3.addComponent(button1);
	    
	    GroupLayout.ParallelGroup vpg4 = layout.createParallelGroup(GroupLayout.Alignment.BASELINE);
	    vpg4.addComponent(label2);
	    vpg4.addComponent(text2);
	    vpg4.addComponent(button2);

	   //垂直
	   layout.setVerticalGroup(layout.createSequentialGroup().addGroup(vpg1).addGroup(vpg2).addGroup(vpg3).addGroup(vpg4));
	    
		setLocation(200,200);
		setSize(320,700);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setTitle("SynCloud");
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
			SyncUserMenu user = new SyncUserMenu(this.fileChoose);
			user.setVisible(true);
        	}
    		}
    }//class OpenActionListener
 
 
 class ChoiceListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(e.getActionCommand()=="打开"){
				dispose();
				//create a new filechoose
				new FileChoose();
			}
			else if (e.getActionCommand()=="同步"){
				System.out.println(text1.getText());
				System.out.println(text2.getText());
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
			
	}//class ChoiceListener
 
 }

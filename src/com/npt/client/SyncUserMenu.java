package com.npt.client;

import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import com.npt.client.FileChoose;


@SuppressWarnings("serial")
public class SyncUserMenu extends JFrame {
	
	//define the filechoose object
	private FileChoose fileChoose;
	
	//selected user
	String selectedUser = "";
	
	JCheckBox checkbox01,checkbox02,checkbox03,checkbox04,checkbox05;
	JPanel panel;
	JLabel label;
	JButton button;
	
	/**
	 * construction
	 * @param fileChoose
	 */
	public SyncUserMenu(FileChoose fileChoose){
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
	    
		label = new JLabel("请选择同步用户：");
		checkbox01 = new JCheckBox("老王");
		checkbox02 = new JCheckBox("老李");
		checkbox03 = new JCheckBox("老孙");
		checkbox04 = new JCheckBox("老朱");
		checkbox05 = new JCheckBox("老沙");
		button = new JButton("确定");
		button.addActionListener(new ChooseListener(this));
		panel = new JPanel();
		
		panel.add(checkbox01);
		panel.add(checkbox02);
		panel.add(checkbox03);
		panel.add(checkbox04);
		panel.add(checkbox05);
		
		JScrollPane pane = new JScrollPane(panel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		Container c = getContentPane();
		GroupLayout layout = new GroupLayout(c);
		c.setLayout(layout);
		
		//自动设定组件、组之间的间隙
	    layout.setAutoCreateGaps(true);
	    layout.setAutoCreateContainerGaps(true);

	    //LEADING -- 左对齐    BASELINE -- 底部对齐  CENTER -- 中心对齐
	    GroupLayout.ParallelGroup hpg1 = layout.createParallelGroup(GroupLayout.Alignment.CENTER);
	    hpg1.addComponent(label);
	    hpg1.addComponent(pane);
	    hpg1.addComponent(button);

	    //水平
	    layout.setHorizontalGroup(layout.createSequentialGroup().addGroup(hpg1));

	    GroupLayout.ParallelGroup vpg1 = layout.createParallelGroup(GroupLayout.Alignment.BASELINE);
	    vpg1.addComponent(label);
	    
	    GroupLayout.ParallelGroup vpg2 = layout.createParallelGroup(GroupLayout.Alignment.BASELINE);
	    vpg2.addComponent(pane);

	    GroupLayout.ParallelGroup vpg3 = layout.createParallelGroup(GroupLayout.Alignment.BASELINE);
	    vpg3.addComponent(button);

	   //垂直
	   layout.setVerticalGroup(layout.createSequentialGroup().addGroup(vpg1).addGroup(vpg2).addGroup(vpg3));
	    
	    setLocation(200,200);
	    pack();
		
		setSize(320,700);
		setVisible(true);
		setTitle("同步用户选择");
		
		setFileChoose(fileChoose);
	}
	
	//set the object reference
	public void setFileChoose(FileChoose fileChoose){
		this.fileChoose = fileChoose;
	}
	
	//set the text field
	public void setTextField(String msg){
		this.fileChoose.text2.setText(msg);
		
	}
	
	/**
	 * ChooseListener
	 * @author zhpmatrix
	 *
	 */
	class ChooseListener implements ActionListener{
		private SyncUserMenu adaptee;
		ChooseListener(SyncUserMenu adaptee) {
	        this.adaptee = adaptee;
	    }
		public void actionPerformed(ActionEvent e) {
	        adaptee.jButton1_actionPerformed(e);
	    }
	}
	
	/**
	 * Get the results of the CheckBox
	 * @param e
	 */
	public void jButton1_actionPerformed(ActionEvent e) {
		if(checkbox01.isSelected()){
	      this.selectedUser=checkbox01.getText();
	     }
	     if(checkbox02.isSelected()){;
	      selectedUser = selectedUser+checkbox02.getText();
	     }
	     if(checkbox03.isSelected()){
	      selectedUser = selectedUser+checkbox03.getText();
	     }
	     if(checkbox04.isSelected()){
	    	 selectedUser = selectedUser+checkbox04.getText();
		 }
	     if(checkbox05.isSelected()){
		      selectedUser = selectedUser+checkbox05.getText();
		 }
	     
	     //TODO set textfield
	     this.setTextField(this.selectedUser);
	     
	     //TODO close the window
	     dispose();
	     
	    }


}

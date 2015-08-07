package com.npt.client;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShowSyncedUser extends JFrame {
	JPanel panel;
	JLabel label01, label02, label03, label04, label05, label06;
	JButton button;

	// JButton button = new JButton("确定");
	public ShowSyncedUser() {

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		String laf = UIManager.getSystemLookAndFeelClassName();
		// 检查jdk版本，是否支持GroupLayout布局
		try {
			UIManager.setLookAndFeel(laf);
		} catch (UnsupportedLookAndFeelException exc) {
			System.err.println("Warning: UnsupportedLookAndFeel: " + laf);
		} catch (Exception exc) {
			System.err.println("Error loading " + laf + ": " + exc);
		}

		panel = new JPanel();
		label01 = new JLabel("查看同步用户：");
		label02 = new JLabel("张三");
		label03 = new JLabel("李四");
		label04 = new JLabel("王五");
		label05 = new JLabel("赵六");
		label06 = new JLabel("胜七");
		button = new JButton("确定");
		button.addActionListener(new CloseListener());
		this.setSize(300, 300);
		this.setTitle("同步用户");

		panel.add(label01);
		panel.add(label02);
		panel.add(label03);
		panel.add(label04);
		panel.add(label05);
		panel.add(label06);

		JScrollPane pane = new JScrollPane(panel,
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		Container c = getContentPane();
		GroupLayout layout = new GroupLayout(c);
		c.setLayout(layout);

		// 自动设定组件、组之间的间隙
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);

		// LEADING -- 左对齐 BASELINE -- 底部对齐 CENTER -- 中心对齐
		GroupLayout.ParallelGroup hpg1 = layout
				.createParallelGroup(GroupLayout.Alignment.LEADING);
		hpg1.addComponent(label01);
		hpg1.addComponent(pane);
		hpg1.addComponent(button);

		// 水平
		layout.setHorizontalGroup(layout.createSequentialGroup().addGroup(hpg1));

		GroupLayout.ParallelGroup vpg1 = layout
				.createParallelGroup(GroupLayout.Alignment.BASELINE);
		vpg1.addComponent(label01);

		GroupLayout.ParallelGroup vpg2 = layout
				.createParallelGroup(GroupLayout.Alignment.BASELINE);
		vpg2.addComponent(pane);

		GroupLayout.ParallelGroup vpg3 = layout
				.createParallelGroup(GroupLayout.Alignment.BASELINE);
		vpg3.addComponent(button);

		// 垂直
		layout.setVerticalGroup(layout.createSequentialGroup().addGroup(vpg1)
				.addGroup(vpg2).addGroup(vpg3));

		setLocation(200, 200);
		pack();
		this.setVisible(true);
	}
	
	class CloseListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(e.getActionCommand() == "确定"){
				dispose();
			}
		}
	}
}

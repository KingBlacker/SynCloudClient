package npt.SynClound.Menu;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class Setting extends JFrame{
	JLabel label01,label02;
	JTextField text01,text02;
	JButton button;
	JPanel panel01,panel02,panel03;
	public Setting(){
		label01 = new JLabel("同步开始时间：");
		label02 = new JLabel("同步       周期：");
		text01 = new JTextField(20);
		text02 = new JTextField(20);
		button = new JButton("确定");
		button.addActionListener(new SettingListen());  //此处添加监听器
		panel01 = new JPanel();
		panel02 = new JPanel();
		panel03 = new JPanel();
		
		this.setLayout(new FlowLayout());
		
		panel01.add(label01);
		panel01.add(text01);
		
		panel02.add(label02);
		panel02.add(text02);
		
		panel03.add(button);
		
		this.add(panel01);
		this.add(panel02);
		this.add(panel03);
		
		this.setSize(400, 300);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setTitle("同步设置");
		
	}
	
	class SettingListen implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(e.getActionCommand()=="确定"){
				System.out.println(text01.getText());
				System.out.println(text02.getText());
			}
		}
	}
	public static void main(String[]  args){
		new Setting();
	}
}

package com.tarena.fish.day08;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class FishFrame1{
	JButton min;
	JButton close;
	JFrame frame;
	public FishFrame1(){
		frame = new JFrame("捕鱼达人");
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setBounds((dim.width-829)/2, (dim.height-550)/2,
				829, 550);
		frame.setUndecorated(true);//设置标题栏不可见
		JLabel mainLabel = new JLabel(
				new ImageIcon("image/bg.png"));
		min = new JButton(new 
				ImageIcon("image/min.png"));//最小化按钮
		min.setBounds(747, 10, 31, 31);//设置相对位置以及大小
		min.setContentAreaFilled(false);//设置图标按钮透明部分实现透明效果
		min.setBorderPainted(false);//取消边框绘制
		mainLabel.add(min);//将最小化按钮添加到mainLabel中
		//添加关闭按钮
		close = new JButton(new 
				ImageIcon("image/close.png"));
		close.setBounds(783, 10, 31, 31);
		close.setContentAreaFilled(false);
		close.setBorderPainted(false);
		mainLabel.add(close);            
		min.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setExtendedState(JFrame.ICONIFIED);
			}
		});
		close.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		frame.add(mainLabel);
		//设置图标
		frame.setIconImage(new ImageIcon(
				"image/icon.jpg").getImage());
		//frame.setTitle("捕鱼达人");
		frame.setVisible(true);
	}
	public static void main(String[] args) {
		new FishFrame1();
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==min){//将窗体最小化
			frame.setExtendedState(JFrame.ICONIFIED);
		}else if(e.getSource()==close){
			System.exit(0);//终止虚拟机
		}
	}
}

package com.tarena.day11;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class BubbleFrame {
	JFrame frame;
	public BubbleFrame(){
		frame = new JFrame("≈›≈›¥Û’Ω");
		int width = 430;
		int height = 640;
		Dimension dim= Toolkit.getDefaultToolkit().
				getScreenSize();
		frame.setBounds((dim.width-width)/2,(dim.height-height)/2,
				width, height);
		frame.setDefaultCloseOperation(
				JFrame.EXIT_ON_CLOSE);
		BubblePanel panel = new BubblePanel(width,height);
		frame.add(panel);
		frame.addMouseListener(panel);
		frame.addMouseMotionListener(panel);
		Thread thread = new Thread(panel);
		thread.start();
		frame.setVisible(true);
	}
	public static void main(String[] args) {
		new BubbleFrame();
	}

}

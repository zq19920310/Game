package com.tarena.char_game;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class CharFrame {
	public CharFrame(){
		JFrame frame = new JFrame("´ò×ÖÄ¸ÓÎÏ·");
		int width = 430;
		int height = 640;
		Dimension dim = Toolkit.getDefaultToolkit().
				getScreenSize();
		frame.setBounds((dim.width-width)/2,(dim.height-height)/2,
				width, height);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		CharPanel2 panel = new CharPanel2(width, height);
		frame.add(panel);
		Thread thread = new Thread(panel);
		thread.start();
		frame.addKeyListener(panel);
		frame.setVisible(true);
	}
	public static void main(String[] args) {
		new CharFrame();
	}
}

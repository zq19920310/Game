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
		frame = new JFrame("�������");
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setBounds((dim.width-829)/2, (dim.height-550)/2,
				829, 550);
		frame.setUndecorated(true);//���ñ��������ɼ�
		JLabel mainLabel = new JLabel(
				new ImageIcon("image/bg.png"));
		min = new JButton(new 
				ImageIcon("image/min.png"));//��С����ť
		min.setBounds(747, 10, 31, 31);//�������λ���Լ���С
		min.setContentAreaFilled(false);//����ͼ�갴ť͸������ʵ��͸��Ч��
		min.setBorderPainted(false);//ȡ���߿����
		mainLabel.add(min);//����С����ť��ӵ�mainLabel��
		//��ӹرհ�ť
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
		//����ͼ��
		frame.setIconImage(new ImageIcon(
				"image/icon.jpg").getImage());
		//frame.setTitle("�������");
		frame.setVisible(true);
	}
	public static void main(String[] args) {
		new FishFrame1();
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==min){//��������С��
			frame.setExtendedState(JFrame.ICONIFIED);
		}else if(e.getSource()==close){
			System.exit(0);//��ֹ�����
		}
	}
}

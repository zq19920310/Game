package com.tarena.day02;
//1�����ǽ����һ����
//����һ���ࣺimport  ����.����;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.*;

public class MyJFrame021 {
	public static void main(String[] args){
		//2��������ʵ����JFrame��Ķ���
		//Ů���� С�� = new Ů����();
		JFrame frame = new JFrame();
		/*//4�����ô���Ĵ�С
		frame.setSize(300, 400);
		//5�����ô�������λ��
		frame.setLocation(300,100);*/
		//4-5�����ô���Ĵ�С�Լ����λ��
		frame.setBounds(300,100,300,400);
		//6�����ô���ı���
		frame.setTitle("����֮��");
		//7�����ô����С���ɱ�
		frame.setResizable(false);
		//������ʵ����MyJPanel021������Ķ���
		MyJPanel021 panel = new MyJPanel021();
		//��������ӵ�������
		frame.add(panel);
		//3�����ô���ɼ�
		frame.setVisible(true);
	}
}
/**��д�����࣬ʹ�ùؼ���extends�̳�JPanel�ࣨ�����ࣩ
 */
class MyJPanel021  extends JPanel{
	public void paint(Graphics g){
		//Graphics g:����
		g.drawLine(20, 30, 100, 200);
		g.setColor(Color.BLUE);
		g.drawRect(10, 50, 100, 100);
		g.setColor(Color.RED);
		g.fillRect(120, 50, 100, 100);
	}
	public void playGame(){
		//...
	}//Ctrl+Shift+O:�Զ����뵱ǰ������Ҫ�����������
}







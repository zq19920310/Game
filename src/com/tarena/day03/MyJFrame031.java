package com.tarena.day03;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
//1�����ǽ����һ����
public class MyJFrame031 {
	public static void main(String[] args) {
		/**2��������ʵ����JFrame��Ķ���
		 * Ů����  С��  = null;
		 * С��  = new Ů����();
		 */
		/*JFrame  frame = null;//����һ������
		frame  = new JFrame();//ʵ����
*/		JFrame frame = new JFrame();
		frame.setTitle("Ԫ������ô����");
		Dimension dim = Toolkit.getDefaultToolkit().
					getScreenSize();
		int sw = dim.width;//��Ļ�Ŀ�
		int sh = dim.height;//��Ļ�ĸ�
		frame.setBounds((sw-430)/2, (sh-640)/2, 430, 640);
		/**EXIT_ON_CLOSE���رմ���ʱ�˳�����
		 * HIDE_ON_CLOSE:�رմ���ʱ�����������أ�Ĭ�ϣ�
		 * DO_NOTHING_ON_CLOSE:�رմ���ʱ�������������ô��彫�޷����رգ�
		 * DISPOSE_ON_CLOSE:�رմ���ʱ�����Ƚ��ô������٣����ٺ��˳�����
		 */
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.setUndecorated(true);//���ر������Լ��߿�
		//������ʵ����MyJPanel031��Ķ���
		MyJPanel031 panel = new MyJPanel031();
		frame.add(panel);
		frame.setVisible(true);
	}
}
class  MyJPanel031 extends JPanel{
	//Alt+/��ʾ���Զ���ȫ
	public void paint(Graphics g){
		//ͨ��super�ؼ��֣����ø����е�paint����
		super.paint(g);
		//this:��ʾ��ǰ��Ķ���
		this.setBackground(Color.BLACK);
		g.setColor(Color.WHITE);
		/*Graphics2D gd = (Graphics2D)g;
		gd.setStroke(new BasicStroke(5));*/
		g.drawString("*", 100, 100);
	}
}







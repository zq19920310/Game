package com.tarena.day03;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
//1、哥们借给我一个类
public class MyJFrame031 {
	public static void main(String[] args) {
		/**2、声明并实例化JFrame类的对象
		 * 女朋友  小美  = null;
		 * 小美  = new 女朋友();
		 */
		/*JFrame  frame = null;//声明一个对象
		frame  = new JFrame();//实例化
*/		JFrame frame = new JFrame();
		frame.setTitle("元芳你怎么看？");
		Dimension dim = Toolkit.getDefaultToolkit().
					getScreenSize();
		int sw = dim.width;//屏幕的宽
		int sh = dim.height;//屏幕的高
		frame.setBounds((sw-430)/2, (sh-640)/2, 430, 640);
		/**EXIT_ON_CLOSE：关闭窗体时退出程序
		 * HIDE_ON_CLOSE:关闭窗体时，将窗体隐藏（默认）
		 * DO_NOTHING_ON_CLOSE:关闭窗体时，神马都不做（该窗体将无法被关闭）
		 * DISPOSE_ON_CLOSE:关闭窗体时，首先将该窗体销毁，销毁后退出程序
		 */
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.setUndecorated(true);//隐藏标题栏以及边框
		//声明并实例化MyJPanel031类的对象
		MyJPanel031 panel = new MyJPanel031();
		frame.add(panel);
		frame.setVisible(true);
	}
}
class  MyJPanel031 extends JPanel{
	//Alt+/提示或自动补全
	public void paint(Graphics g){
		//通过super关键字，调用父类中的paint方法
		super.paint(g);
		//this:表示当前类的对象
		this.setBackground(Color.BLACK);
		g.setColor(Color.WHITE);
		/*Graphics2D gd = (Graphics2D)g;
		gd.setStroke(new BasicStroke(5));*/
		g.drawString("*", 100, 100);
	}
}







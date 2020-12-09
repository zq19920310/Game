package com.tarena.day03;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
public class MyJFrame032 {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setSize(dim);
		frame.setUndecorated(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MyJPanel032 panel = new MyJPanel032(dim);
		frame.add(panel);
		frame.setVisible(true);
	}
}
class MyJPanel032 extends JPanel{
	Dimension dim;
	/**构造方法：
	 * 方法名和类名相同，没有返回值类型，也不使用void。
	 * 1、什么时候被调用？实例化时被调用
	 * 2、当一个类中如果没有定义任何构造方法的话，默认存在一个无参的构造方法。
	 * 3、如果在一个类中，只定义了一个有参的构造方法，那么默认存在的无参构造方法
	 * 将不在存在。如果还想使用无参的构造方法，那么需要自定义一个无参的构造方法。
	 * 4、构造方法之间互相调用时，使用this(参数列表);
	 * 	  在构造方法互相调用时，要有“出口”,避免死循环。
	 * 5、作用：a.构造（实例化）一个新的对象；
	 *        b.为该类的属性赋初始化的值
	 */
	public MyJPanel032(){
	}
	public MyJPanel032(Dimension dim){
		this.dim = dim;
	}
	public MyJPanel032(Dimension dim,String str){
		//...
	}
	public void paint(Graphics g){
		//通过super关键字调用父类中的paint方法
		super.paint(g);
		//使用this关键字设置背景色
		this.setBackground(Color.BLACK);
		g.setColor(Color.WHITE);
		Random random = new Random();
		for(int i=0;i<300;i++){
			int x = random.nextInt(dim.width);
			int y = random.nextInt(dim.height);
			g.drawString("*", x, y);
		}
	}
}










package com.tarena.day02;
//1、哥们借给我一个类
//导入一个类：import  包名.类名;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.*;

public class MyJFrame021 {
	public static void main(String[] args){
		//2、声明并实例化JFrame类的对象
		//女朋友 小美 = new 女朋友();
		JFrame frame = new JFrame();
		/*//4、设置窗体的大小
		frame.setSize(300, 400);
		//5、设置窗体的相对位置
		frame.setLocation(300,100);*/
		//4-5：设置窗体的大小以及相对位置
		frame.setBounds(300,100,300,400);
		//6、设置窗体的标题
		frame.setTitle("土豪之窗");
		//7、设置窗体大小不可变
		frame.setResizable(false);
		//声明并实例化MyJPanel021画布类的对象
		MyJPanel021 panel = new MyJPanel021();
		//将画布添加到窗体上
		frame.add(panel);
		//3、设置窗体可见
		frame.setVisible(true);
	}
}
/**编写画布类，使用关键字extends继承JPanel类（画布类）
 */
class MyJPanel021  extends JPanel{
	public void paint(Graphics g){
		//Graphics g:画笔
		g.drawLine(20, 30, 100, 200);
		g.setColor(Color.BLUE);
		g.drawRect(10, 50, 100, 100);
		g.setColor(Color.RED);
		g.fillRect(120, 50, 100, 100);
	}
	public void playGame(){
		//...
	}//Ctrl+Shift+O:自动导入当前类中需要导入的所有类
}







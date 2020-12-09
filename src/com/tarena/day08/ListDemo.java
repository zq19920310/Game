package com.tarena.day08;

import java.util.LinkedList;
import java.util.List;
public class ListDemo {
	public static void main(String[] args) {
		/**1��������ʵ����������Ķ���
		 * List<����> ���϶�������� = new ArrayList<����>();
		 * List<����> ���϶�������� = new LinkedList<����>();
		 * ArrayList:�ɱ䳤�ȵ�����
		 * 		�ŵ㣺��ѯЧ�ʽϸߣ�
		 *      ȱ�㣺��Ӻ�ɾ��Ч�ʽϵ�
		 *LinkedList:�ɱ䳤�ȵ�����
		 *		�ŵ㣺��Ӻ�ɾ��Ч�ʽϸ�
		 *	    ȱ�㣺��ѯ��Ч�ʽϵ�
		 *2�����÷�����
		 *	add(Object obj):���һ������
		 *  add(int index,Object obj):�ڶ�Ӧ��λ�������һ������
		 *  get(int index)����ȡ��Ӧλ�õĶ���
		 *  remove(int index)��ɾ��ָ��λ�õĶ���
		 *  remove(Object obj)��ɾ�������ж�Ӧ�Ķ���
		 *  size():��ȡ���ϵĳ��ȣ����������ĸ�����
		 *  3������
		 *  A.����ӵĶ������������֤��
		 *  ʹ�÷���֮�󣬸ü�����ֻ����ӷ��Ͷ�Ӧ���͵Ķ���
		 *  ������"�����"�Ķ���
		 *  B.ʹ��get������ȡ���������һ���Ŀ������һ�£�
		 *  ͨ������Ҫ��������ת����
		 */
		//List<Food> foodBox = new ArrayList<Food>();//
		List<Food> foodBox = new LinkedList<Food>();
		Food f1 = new Food("ƽңţ��",50);
		foodBox.add(f1);//add���һ������
		foodBox.add(new Food("������Ѽ",72));
		foodBox.add(new Food("����һֻ",3000));
		Food f2 = new Food("��Ϻ",500);
		foodBox.add(0,f2);
		foodBox.remove(2);
		foodBox.remove(2);
		for(int i=0;i<foodBox.size();i++){
			Food food =  foodBox.get(i);
			food.printInfo();
		}
	}
}
class Food{
	private String name;
	private double price;
	public Food(String name,double price){
		this.name = name;
		this.price = price;
	}
	public void printInfo(){
		System.out.println("���ƣ�"+name+"�۸�"+price);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
}


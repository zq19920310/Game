package com.tarena.day01;
//�����ж�
public class Demo02 {
	public static void main(String[] args){
		 /*if(�������ʽ){
			 //������ʽ�Ľ��Ϊtrue��ִ�иÿ����
		 }else if(�������ʽ2){
			 //....
		 }else if(�������ʽ3){
			 //.....
		 }else{
			 //�������е��������ʽ��� ��Ϊfalseʱ��ִ�иÿ����
		 }*/
		//Ctrl+Shift+/������ע��
		/*if(�������ʽ){
			//��������
		}else{
			//�������ʽ��������
		}*/
		/*if(�������ʽ){
			//��������ʱִ�У���������������κβ�����
		}*/
		int age = 10;
		if(age>=18){
			System.out.println("�����ˣ����Խ�����");
		}else{
			System.out.println("������˼��δ���겻�ܽ�����");
		}
		int score = 70;
		char level = ' ';
		switch(score/10){
			case 9:level ='A';break;
			case 8:level = 'B';break;
			case 7:level = 'C';break;
			case 6:level = 'D';break;
			case 5:case 4:case 3:case 2:case 1:case 0:
					level = 'E';break;
			default:
				level = ' ';break;
		}
		System.out.println("ת����ĳɼ���"+level);
	}
}

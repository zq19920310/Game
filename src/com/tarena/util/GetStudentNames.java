package com.tarena.util;

import java.util.Random;

public class GetStudentNames {
	public static void main(String[] args) {
		String  names[] = {
				"������	",
				"��˧��	",
				"�׺�",
				"���",
				"������",
				"�����",
				"��Խ ",
				"����� ",
				"����ǿ ",
				"���",
				"��ΰ",
				"�����",
				"��ұ�",
				"�",
				"����ǰ",
				"����",
				"����",
				"������  ",
				"������",
				"���ܷ� ",
				"��ʤ��",
				"����",
				"��ǫ",
				"����",
				"���ɾ�",
				"��˶",
				"������  ",
				"��ͦ  ",
				"Ҧ��ǿ",
				"������",
				"��ԲԲ",
				"����",
				"����",
				"��D",
				"������",
				"�Ὠ÷",
				"��С��",
				"������",
				"������",
				"������",
				"����",
				"������",
				"��Ȩ��",
				"������",
				"����",
				"����",
				"��ΰ��",
				"ʷ����",
				"����",
				"����֥",
				"�",
				"�վ�",
				"���ٷ�",
				"������",
				"����",
				"������",
				"������",
				"��־��",
				"����ΰ",
				"������ ",
				"˾Ρ  ",
				"�ܽ���",
				"���ȴ�",
				"��ǫ",
				"������",
				"��С��",
				"��Х�� ",
				"���� ",
				"��ΰ�� ",
				"������",
				"������",
				"����",
				"������",
				"����",
				"����ϼ",
				"�԰�",
				"��ΰ�� ",
				"����"
				};
		int getNum = 30;
		String stuNames[] = new String[getNum];
		Random random = new Random();
		for(int i=0;i<getNum;i++){
			int index = random.nextInt(names.length);
			boolean isHave = false;//��ȡ���������Ƿ��Ѿ�����
			for(int j=0;j<=i-1;j++){
				if(names[index].equals(stuNames[j])){
					i--;
					isHave = true;
					break;
				}
 			}
			if(!isHave){//isHave==false
				stuNames[i] = names[index];
			}
		}
		System.out.println("����ͬѧ���˷�");
		for(int m = 0;m<getNum;m++){
			System.out.println(stuNames[m]);
		}
	}
}

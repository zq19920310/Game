package com.tarena.util;

import java.util.Random;

public class GetStudentNames {
	public static void main(String[] args) {
		String  names[] = {
				"李素鹏	",
				"张帅政	",
				"米浩",
				"李杰",
				"徐文萌",
				"徐恩晟",
				"陈越 ",
				"郭鸿岗 ",
				"王李强 ",
				"侯贝贝",
				"秦伟",
				"张彦辉",
				"万家宝",
				"杨喆",
				"李向前",
				"杨柳",
				"骆涛",
				"黄晓聪  ",
				"鲍汉波",
				"柴周峰 ",
				"孙胜杰",
				"冀宇",
				"刘谦",
				"杨奇",
				"党成娟",
				"苏硕",
				"刘建文  ",
				"李挺  ",
				"姚兴强",
				"岳泽奇",
				"郭圆圆",
				"姜超",
				"相茹",
				"徐燚",
				"刘艳芹",
				"裴建梅",
				"崔小杰",
				"赵晓亮",
				"韩文清",
				"李智鹏",
				"张奇",
				"刘子民",
				"周权威",
				"杨涛涛",
				"王飞",
				"安敏",
				"黄伟杨",
				"史鹏亚",
				"李鹏",
				"和琳芝",
				"杨华",
				"苏君",
				"王琴飞",
				"王兵兵",
				"刘乔",
				"宋婷婷",
				"宁梓茜",
				"尹志鹏",
				"王建伟",
				"邓旺兵 ",
				"司巍  ",
				"周杰祥",
				"李奕村",
				"杨谦",
				"宋卫朋",
				"李小辉",
				"马啸宇 ",
				"吴瑾琛 ",
				"王伟军 ",
				"胡代祥",
				"武洋洋",
				"李毅",
				"孟锴沣",
				"王磊",
				"康利霞",
				"赵皝",
				"许伟红 ",
				"贺蕾"
				};
		int getNum = 30;
		String stuNames[] = new String[getNum];
		Random random = new Random();
		for(int i=0;i<getNum;i++){
			int index = random.nextInt(names.length);
			boolean isHave = false;//抽取出的姓名是否已经存在
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
		System.out.println("以下同学来了否？");
		for(int m = 0;m<getNum;m++){
			System.out.println(stuNames[m]);
		}
	}
}

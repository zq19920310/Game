package com.tarena.game;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;


public class MusicPlayer {
	private InputStream ins;
	private AudioStream as;
	public MusicPlayer(String fileName) {
		//根据文件名称获取音频文件的路径
		String url = getClass().getResource(fileName).getPath();
		//得到的路径中文件夹名称中有空格会转花为“%20”，所以使用前要将“%20”变为空格
		url = url.replaceAll("%20", " ");
		//去掉路径前多余的“\”
		url = url.substring(1, url.length());
		File file = new File(url);
		try {
			ins = new FileInputStream(file);
			as = new AudioStream(ins);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void play(){
		AudioPlayer.player.start(as);
	}
	public void stopPlay(){
		AudioPlayer.player.stop(as);
	}
	
}

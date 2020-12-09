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
		//�����ļ����ƻ�ȡ��Ƶ�ļ���·��
		String url = getClass().getResource(fileName).getPath();
		//�õ���·�����ļ����������пո��ת��Ϊ��%20��������ʹ��ǰҪ����%20����Ϊ�ո�
		url = url.replaceAll("%20", " ");
		//ȥ��·��ǰ����ġ�\��
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

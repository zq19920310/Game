package com.tarena.game;
import javax.swing.JFrame;
public class StartGame  extends JFrame{
	//����һ���˵���
	private GameJPanel panel;
	private MusicPlayer bgMusic;
	public StartGame(){
		bgMusic = new MusicPlayer("game_music.wav");
	}
	public void showWin(){
		this.setTitle("ȫ��ɻ���ս��΢�Ű棩");
		this.setBounds(100, 50, 430, 640);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		panel = new GameJPanel();
		Thread t = new Thread(panel);
		t.start();
		this.add(panel);
		panel.setPanel(panel);
		//���˵�����ӵ�������
		//this.setJMenuBar(menuBar);
		this.addMouseListener(panel);
		this.addKeyListener(panel);
		this.addMouseMotionListener(panel);
		bgMusic.play();
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new StartGame().showWin();
	}
}

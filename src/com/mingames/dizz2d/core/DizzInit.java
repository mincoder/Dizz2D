package com.mingames.dizz2d.core;

import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class DizzInit extends JPanel{
	
	private static final long serialVersionUID = -9164956658963162115L;
	public static JFrame frame;
	
	public static void main(String[] args) {
		//Dizz2D Game = new Dizz2D();
		frame = new JFrame();
		frame.setSize(700,700);
		frame.setTitle("Dizz2d");
		frame.add(new Dizz2D());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		//Game.gameLoop();
	}
	
	public static void requestKeyListner(KeyListener kl) {
		frame.addKeyListener(kl);
	}
	
	public static void requestKeyListnerRemoval(KeyListener kl) {
		frame.removeKeyListener(kl);
	}
	
}
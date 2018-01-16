package com.mingames.dizz2d.core;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class DizzInit extends JPanel implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -9164956658963162115L;
	public static JFrame frame;
	StateHandler sh = new StateHandler(StateHandler.GAME);
	int i=0;
	
	public static void main(String[] args) {
		DizzInit Game = new DizzInit();
		frame = new JFrame();
		frame.setSize(700,700);
		frame.setTitle("Dizz2d");
		frame.add(Game);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		Game.gameLoop();
	}
	
	public DizzInit() {
		Timer tim = new Timer(1,this);
		tim.start();
	}
	
	public void gameLoop() {
		//while(true) repaint();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
		System.out.println(i++ + "");
	}
	
	public void paint(Graphics g) {
		sh.render(g,this);
	}
	
}
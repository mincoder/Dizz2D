package com.mingames.dizz2d.core;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class DizzInit extends JPanel{
	
	public static JFrame frame;
	
	public static void main(String[] args) {
		frame = new JFrame();
		frame.setSize(700,700);
		frame.setTitle("Dizz2d");
		frame.add(new DizzInit());
		frame.setVisible(true);
	}
	
	public DizzInit() {
		
	}
	
}
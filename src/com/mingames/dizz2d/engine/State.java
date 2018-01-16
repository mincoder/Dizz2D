package com.mingames.dizz2d.engine;

import java.awt.Graphics;
import java.awt.image.ImageObserver;

import javax.swing.JPanel;

public interface State {
	
	public void update();
	public void render(Graphics g);
	
}

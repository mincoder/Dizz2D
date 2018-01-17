package com.mingames.dizz2d.blocks;

import java.awt.image.BufferedImage;

public interface Block {
	
	public int getId();
	public BufferedImage getImg();
	public boolean getIfAnimated();
	public int getDamage();
	public void setDamage(int set);
	public int getLayer();
	
}

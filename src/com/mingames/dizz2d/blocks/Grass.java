package com.mingames.dizz2d.blocks;

import java.awt.image.BufferedImage;

import com.mingames.dizz2d.engine.TextureMap;

public class Grass implements Block{
	
	public static BufferedImage img = TextureMap.getSprite(0, 0, "res/tiles.png");
	int layer=0;
	int damage=10;
	
	@Override
	public int getId() {
		return 1;
	}

	@Override
	public BufferedImage getImg() {
		return img;
	}

	@Override
	public boolean getIfAnimated() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getDamage() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setDamage(int damage) {
		this.damage=damage;
	}

	@Override
	public int getLayer() {
		return layer;
	}

}

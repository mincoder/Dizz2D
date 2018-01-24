package com.mingames.dizz2d.blocks;

import java.awt.image.BufferedImage;

import com.mingames.dizz2d.core.Dizz2D;
import com.mingames.dizz2d.engine.Animation;
import com.mingames.dizz2d.engine.TextureMap;

public class Water implements Block{

	private static BufferedImage[] animImg = {TextureMap.getSprite(3, 0, "res/tiles.png"),TextureMap.getSprite(2, 0, "res/tiles.png"),TextureMap.getSprite(3, 0, "res/tiles.png"),TextureMap.getSprite(4, 0, "res/tiles.png")};
	private static Animation anim = new Animation(animImg,100,Dizz2D.MillisecondsBetweenTicks);
	private int layer=0;
	private int damage=10;
	
	@Override
	public int getId() {
		return 1;
	}

	@Override
	public BufferedImage getImg() {
		return anim.getImage();
	}

	@Override
	public boolean getIfAnimated() {
		// TODO Auto-generated method stub
		return true;
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

	@Override
	public void update() {
		anim.update();
	}

}

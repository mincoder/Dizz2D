package com.mingames.dizz2d.enities;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.mingames.dizz2d.core.Dizz2D;
import com.mingames.dizz2d.engine.Animation;
import com.mingames.dizz2d.engine.Entity;

public class Bullet extends Entity{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 273666555118991211L;
	Animation animFront;
	Animation animBack;
	Animation animLeft;
	Animation animRight;

	
	public Bullet(int x,int y, String imgWalkFront,String imgWalkBack,String imgWalkLeft,String imgWalkRight) {
		BufferedImage imgFile = null;
		try {
			imgFile = ImageIO.read(new File(imgWalkFront));
		} catch (IOException e) {
			e.printStackTrace();
		}
		animFront = new Animation(imgWalkFront,imgFile.getWidth()/16,0.25,Dizz2D.MillisecondsBetweenTicks);
		animBack = new Animation(imgWalkBack,imgFile.getWidth()/16,0.25,Dizz2D.MillisecondsBetweenTicks);
		animLeft = new Animation(imgWalkLeft,imgFile.getWidth()/16,0.25,Dizz2D.MillisecondsBetweenTicks);
		animRight = new Animation(imgWalkRight,imgFile.getWidth()/16,0.25,Dizz2D.MillisecondsBetweenTicks);
	}
	
	public void update() {
		animFront.update();
		animBack.update();
		animLeft.update();
		animRight.update();
		moveWithoutCollision();
	}
	
	public BufferedImage getImg() {
		if(Math.abs(xspeed)+Math.abs(yspeed)>0) {
			if(yspeed>0) {
			return animFront.getImage();
			} else if(yspeed<0) {
				return animBack.getImage();
			} else if(xspeed<0) {
				return animLeft.getImage();
			} else if(xspeed>0) {
				return animRight.getImage();
			} else {
				return animFront.getImage();
			}
		} else return animFront.getImage();
	}
	
}

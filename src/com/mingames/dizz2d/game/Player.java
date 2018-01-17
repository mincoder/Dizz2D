package com.mingames.dizz2d.game;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.mingames.dizz2d.core.Dizz2D;
import com.mingames.dizz2d.engine.Animation;
import com.mingames.dizz2d.engine.Entity;

public class Player extends Entity{
	
	Animation animStill;
	Animation animWalkFront;
	Animation animWalkBack;
	Animation animWalkLeft;
	Animation animWalkRight;

	
	public Player(int x,int y, String imgStill, String imgWalkFront,String imgWalkBack,String imgWalkLeft,String imgWalkRight) {
		BufferedImage imgFile = null;
		try {
			imgFile = ImageIO.read(new File(imgStill));
		} catch (IOException e) {
			e.printStackTrace();
		}
		animStill = new Animation(imgStill,imgFile.getWidth()/16,1,Dizz2D.MillisecondsBetweenTicks);
		animWalkFront = new Animation(imgWalkFront,imgFile.getWidth()/16,0.25,Dizz2D.MillisecondsBetweenTicks);
		animWalkBack = new Animation(imgWalkBack,imgFile.getWidth()/16,0.25,Dizz2D.MillisecondsBetweenTicks);
		animWalkLeft = new Animation(imgWalkLeft,imgFile.getWidth()/16,0.25,Dizz2D.MillisecondsBetweenTicks);
		animWalkRight = new Animation(imgWalkRight,imgFile.getWidth()/16,0.25,Dizz2D.MillisecondsBetweenTicks);
	}
	
	public void update() {
		animStill.update();
		animWalkFront.update();
		animWalkBack.update();
		animWalkLeft.update();
		animWalkRight.update();
	}
	
	public BufferedImage getImg() {
		if(Math.abs(xspeed)+Math.abs(yspeed)>0) {
			if(yspeed>0) {
			return animWalkFront.getImage();
			} else if(yspeed<0) {
				return animWalkBack.getImage();
			} else if(xspeed<0) {
				return animWalkLeft.getImage();
			} else if(xspeed>0) {
				return animWalkRight.getImage();
			} else {
				return animStill.getImage();
			}
		} else return animStill.getImage();
	}
	
}

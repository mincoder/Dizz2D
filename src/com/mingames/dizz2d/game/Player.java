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
	Animation animWalk;
	
	public Player(int x,int y, String imgStill, String imgWalk) {
		BufferedImage imgFile = null;
		try {
			imgFile = ImageIO.read(new File(imgStill));
		} catch (IOException e) {
			e.printStackTrace();
		}
		animStill = new Animation(imgStill,imgFile.getWidth()/16,1,Dizz2D.MillisecondsBetweenTicks);
		try {
			imgFile = ImageIO.read(new File(imgWalk));
		} catch (IOException e) {
			e.printStackTrace();
		}
		animWalk = new Animation(imgWalk,imgFile.getWidth()/16,0.25,Dizz2D.MillisecondsBetweenTicks);
	}
	
	public void update() {
		animStill.update();
		animWalk.update();
	}
	
	public BufferedImage getImg() {
		if(Math.abs(xspeed)+Math.abs(yspeed)>0) {
			return animWalk.getImage();
		} else return animStill.getImage();
	}
	
}

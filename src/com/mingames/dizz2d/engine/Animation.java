package com.mingames.dizz2d.engine;

import java.awt.image.BufferedImage;

public class Animation {
	
	int count=0;
	int nextFrame=0;
	int onFrame=0;
	
	BufferedImage[] images;
	
	public Animation(BufferedImage[] images,double framesPerSecond, int miliSecondsBetweenTicks) {
		nextFrame=(int) (1000/miliSecondsBetweenTicks*framesPerSecond);
		this.images=images;
	}
	
	public Animation(String file,int size,double framesPerSecond, int miliSecondsBetweenTicks) {
		nextFrame=(int) (1000/miliSecondsBetweenTicks*framesPerSecond);
		images = new BufferedImage[size];
		for(int i=0;i<size;i++) {
			this.images[i]=TextureMap.getSprite(i, 0, file);
		}
	}
	
	public void update() {
		count++;
		if(count>=nextFrame) {
			count=0;
			onFrame++;
			if(onFrame>=images.length) {
				onFrame=0;
			}
		}
	}
	
	public BufferedImage getImage() {
		return images[onFrame];
	}
}

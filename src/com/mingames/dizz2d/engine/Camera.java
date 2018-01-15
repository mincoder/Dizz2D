package com.mingames.dizz2d.engine;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;

public class Camera {
	
	int x=0;
	int y=0;
	RenderEntity[] renderentities = new RenderEntity[10000000];
	
	public static int maxLayer=5;
	
	public RenderEntity registerRenderEntity(int a,int b, int width, int height, Image image, int layer) {
		boolean foundNumber=false;
		int number=0;
		while(!foundNumber) if(renderentities[number]==null) { foundNumber = true; } else number++;
		renderentities[number] = new RenderEntity(a,b,width,height,number,image,layer);
		return renderentities[number];
	}
	
	public void deleteRenderEntity(RenderEntity re) {
		renderentities[re.id] = null;
	}
	
	public void moveRenderEntity(int a, int b, RenderEntity re) {
		renderentities[re.id].x=a;
		renderentities[re.id].y=b;
	}
	
	public void render(Graphics g, ImageObserver obs) {
		for(int i=0;i<maxLayer;i++) {
			for(int j=0;j<renderentities.length;i++) {
				if(!(renderentities[j]==null)) {
					if(renderentities[j].layer==i) {
						g.drawImage(renderentities[j].image,renderentities[j].x,renderentities[j].y,renderentities[j].width,renderentities[j].height,obs);
					}
				}
			}
		}
	}
	
}

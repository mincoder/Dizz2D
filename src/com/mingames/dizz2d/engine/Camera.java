package com.mingames.dizz2d.engine;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

import javax.swing.JPanel;

public class Camera {
	
	int x=0;
	int y=0;
	RenderEntity[] renderentities = new RenderEntity[10000000];
	
	public static int maxLayer=1;
	public static int maxEntities=0;
	
	public RenderEntity registerRenderEntity(int a,int b, int width, int height, BufferedImage image, int layer) {
		boolean foundNumber=false;
		int number=0;
		while(!foundNumber) if(renderentities[number]==null) { foundNumber = true; } else number++;
		renderentities[number] = new RenderEntity(a,b,width,height,number,image,layer);
		maxEntities++;
		return renderentities[number];
	}
	
	public void deleteRenderEntity(RenderEntity re) {
		renderentities[re.id] = null;
	}
	
	public void moveRenderEntity(int a, int b, RenderEntity re) {
		renderentities[re.id].x=a;
		renderentities[re.id].y=b;
	}
	
	public void render(Graphics g, JPanel obs) {
		for(int i=0;i<maxLayer;i++) {
			for(int j=0;j<maxEntities;i++) {
				if(!(renderentities[j]==null)) {
					if(renderentities[j].layer==i) {
						System.out.println("c");
						g.drawImage(renderentities[j].image,renderentities[j].x+x,renderentities[j].y+y/*,renderentities[j].width,renderentities[j].height*/,obs);
					}
				}
			}
		}
	}
	
	public void setCamera(int a, int b) {
		x=a;
		y=b;
	}
	
}

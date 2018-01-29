package com.mingames.dizz2d.engine;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Camera {
	
	int x=0;
	int y=0;
	RenderEntity[] renderentities = new RenderEntity[100000];
	
	public static int maxLayer=4;
	BufferedImage io;
	
	public static final int gameWidth=500;
	public static final int gameHeight=500;
	
	public Camera() {
		try {
			io = ImageIO.read(new File("res/tiles.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public RenderEntity registerRenderEntity(int a,int b, int width, int height, BufferedImage image, int layer) {
		boolean foundNumber=false;
		int number=0;
		while(!foundNumber) {
			if(renderentities[number]==null) { foundNumber = true; } else number++;
			
			
		}
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
	
	public void render(Graphics g, JPanel obs) {

		for(int i=0;i<maxLayer;i++) {
			for(int j=0;j<renderentities.length;j++) {
				if(!(renderentities[j]==null)) {
					if(renderentities[j].layer==i) {
						g.drawImage(renderentities[j].image,renderentities[j].x+x,renderentities[j].y+y,renderentities[j].width,renderentities[j].height,null);
					}
				}
			}
		}
	}
	
	public void setCamera(int a, int b) {
		x=-a+350;
		y=-b+350;
	}
	
}

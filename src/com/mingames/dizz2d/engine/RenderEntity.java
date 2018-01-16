package com.mingames.dizz2d.engine;

import java.awt.image.BufferedImage;

public class RenderEntity {
	
	public BufferedImage image;
	public int x=0;
	public int y=0;
	public int width=0;
	public int height=0;
	public int id=0;
	public int layer=0;
	
	public RenderEntity(int a, int b, int w, int h, int number, BufferedImage img, int l) {
		x=a;
		y=b;
		width=w;
		height=h;
		id=number;
		image=img;
		layer=l;
	}
	
}

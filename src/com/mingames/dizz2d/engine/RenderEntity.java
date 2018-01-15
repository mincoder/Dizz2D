package com.mingames.dizz2d.engine;

import java.awt.Image;

public class RenderEntity {
	
	public Image image;
	public int x=0;
	public int y=0;
	public int width=0;
	public int height=0;
	public int id=0;
	public int layer=0;
	
	public RenderEntity(int a, int b, int w, int h, int number, Image img, int l) {
		x=a;
		y=b;
		width=w;
		height=h;
		id=number;
		image=img;
		layer=l;
	}
	
}

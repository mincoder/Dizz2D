package com.mingames.dizz2d.engine;

import java.awt.Rectangle;

public class Entity extends Rectangle{
	
	public int xspeed=0;
	public int yspeed=0;
	
	public void moveWithCollision(Rectangle[] areas,Level l) {
		int new_x = x + xspeed;
		int new_y = y + yspeed;
		if(l.getBlock(new_x, y)==0) {
		    new_x = x;
		    xspeed = 0;
		}
		if(l.getBlock(x, new_y)==0) {
		    new_y = y;
		    yspeed = 0;
		}
		if(l.getBlock(new_x, y)==0) {
		    new_x = x;
		    xspeed = 0;
		}
		if(l.getBlock(x, new_y)==0) {
		    new_y = y;
		    yspeed = 0;
		}
		x = new_x;
		y = new_y;
	}
	
	public void moveWithoutCollision() {
		x+=xspeed;
		y+=yspeed;
	}
	
}

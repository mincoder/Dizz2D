package com.mingames.dizz2d.engine;

import com.mingames.dizz2d.blocks.Block;

public class Level {
	
	Block[][] blocks;
	RenderEntity[][] blockRender;
	
	public Level(Block[][] blocks) {
		this.blocks = blocks;
	}
	
	public int getBlock(int x, int y) {
		return 0;
	}
	
	public void RenderToCamera(Camera cam) {
		for(int x=0;x<blocks.length;x++) {
			for(int y=0;y<blocks.length;y++) {
				try {
				cam.deleteRenderEntity(blockRender[x][y]);
				} catch(NullPointerException e) {}
				cam.registerRenderEntity(x*64, y*64, 64, 64, blocks[x][y].getImg(), 0);
			}
		}
	}
	
}

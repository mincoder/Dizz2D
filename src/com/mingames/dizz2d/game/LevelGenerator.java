package com.mingames.dizz2d.game;

import java.util.Random;

import com.mingames.dizz2d.blocks.Block;
import com.mingames.dizz2d.blocks.Grass;
import com.mingames.dizz2d.blocks.Water;
import com.mingames.dizz2d.engine.DizzNoise;

public class LevelGenerator {
	
	public static Block[][] GenerateLevel(int w,int h) {
		Block[][] response = new Block[w][h];
		int[][] level = DizzNoise.getRandomNoise(new Random(new Random().nextLong()), 5, 1, 2, 100, w, h, 10);
		for(int x=0;x<level.length;x++) {
			for(int y=0;y<level[x].length;y++) {
				if(level[x][y]>3) {
					response[x][y] = new Water();
				} else {
					response[x][y] = new Grass();
				}
			}
		}
		return response;
	}

}

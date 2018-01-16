package com.mingames.dizz2d.game;

import java.awt.Graphics;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import com.mingames.dizz2d.engine.Camera;
import com.mingames.dizz2d.engine.State;
import com.mingames.dizz2d.engine.TextureMap;

public class GameState implements State{

	Camera cam = new Camera();
	int x=0;
	
	public static Random random = new Random(new Random().nextLong());
	
	public GameState() {
		TextureMap.loadSprite("tiles");
		for(int x=0;x<10;x++) {
			for(int y=0;y<10;y++) {
				try {
					cam.registerRenderEntity(x*32, y*32, 32, 32, ImageIO.read(new File("res/tiles.png")), 0);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g,JPanel obs) {
		cam.setCamera(x, 0);
		cam.render(g, obs);
		
	}
	
}

package com.mingames.dizz2d.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import com.mingames.dizz2d.core.DizzInit;
import com.mingames.dizz2d.engine.Camera;
import com.mingames.dizz2d.engine.Level;
import com.mingames.dizz2d.engine.RenderEntity;
import com.mingames.dizz2d.engine.State;
import com.mingames.dizz2d.engine.TextureMap;

public class GameState implements State, KeyListener{

	Camera cam = new Camera();
	
	Player player = new Player(350,350,"res/player.png","res/playerwalkfront.png","res/playerwalkback.png","res/playerwalkleft.png","res/playerwalkright.png");
	RenderEntity playerren;
	
	Level l = new Level(LevelGenerator.GenerateLevel(100, 100));
	
	int x=0;
	
	public static Random random = new Random(new Random().nextLong());
	
	public GameState() {
		DizzInit.requestKeyListner(this);
		playerren = cam.registerRenderEntity(player.x, player.y, 64, 64, player.getImg(), 2);
		for(int x=0;x<10;x++) {
			for(int y=0;y<10;y++) {
				cam.registerRenderEntity(x*64, y*64, 64, 64, TextureMap.getSprite(0, 0,"res/tiles.png"), 1);
			}
		}
	}
	
	@Override
	public void update() {
		//Player updates
		player.moveWithoutCollision();
		player.update();
		
		//Render level
		l.RenderToCamera(cam);
		
		//Camera updates
		cam.setCamera(player.x+32, player.y+32);
	}

	@Override
	public void render(Graphics g) {
		
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 700, 700);
		
		cam.deleteRenderEntity(playerren);
		playerren = cam.registerRenderEntity(player.x, player.y, 64, 64, player.getImg(), 2);
		
		cam.render(g, null);
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==e.VK_LEFT) {
			player.xspeed=-3;
		}
		if(e.getKeyCode()==e.VK_RIGHT) {
			player.xspeed=3;
		}
		if(e.getKeyCode()==e.VK_UP) {
			player.yspeed=-3;
		}
		if(e.getKeyCode()==e.VK_DOWN) {
			player.yspeed=3;
		}
		if(e.getKeyCode()==e.VK_ESCAPE) {
			System.exit(0);
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode()==e.VK_LEFT) {
			if(player.xspeed<0) player.xspeed=0;
		}
		if(e.getKeyCode()==e.VK_RIGHT) {
			if(player.xspeed>0) player.xspeed=0;
		}
		if(e.getKeyCode()==e.VK_UP) {
			if(player.yspeed<0) player.yspeed=0;
		}
		if(e.getKeyCode()==e.VK_DOWN) {
			if(player.yspeed>0) player.yspeed=0;
		}
		
	}
	
}

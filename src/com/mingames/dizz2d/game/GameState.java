package com.mingames.dizz2d.game;

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
import com.mingames.dizz2d.engine.RenderEntity;
import com.mingames.dizz2d.engine.State;
import com.mingames.dizz2d.engine.TextureMap;

public class GameState implements State, KeyListener{

	Camera cam = new Camera();
	
	Player player = new Player(350,350,"res/player.png","res/playerwalk.png");
	RenderEntity playerren;
	
	int x=0;
	
	public static Random random = new Random(new Random().nextLong());
	
	public GameState() {
		//TextureMap.loadSprite("tiles");
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		player.moveWithoutCollision();
		player.update();
		cam.setCamera(player.x+32, player.y+32);
		
		cam.deleteRenderEntity(playerren);
		playerren = cam.registerRenderEntity(player.x, player.y, 64, 64, player.getImg(), 2);
		
		//cam.setCamera(x, 0);
		cam.render(g, null);
		
		//g.fillRect(0, 0, 700, 700);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==e.VK_LEFT) {
			player.xspeed=-2;
		}
		if(e.getKeyCode()==e.VK_RIGHT) {
			player.xspeed=2;
		}
		if(e.getKeyCode()==e.VK_UP) {
			player.yspeed=-2;
		}
		if(e.getKeyCode()==e.VK_DOWN) {
			player.yspeed=2;
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode()==e.VK_LEFT) {
			if(player.xspeed==-2) player.xspeed=0;
		}
		if(e.getKeyCode()==e.VK_RIGHT) {
			if(player.xspeed==2) player.xspeed=0;
		}
		if(e.getKeyCode()==e.VK_UP) {
			if(player.yspeed==-2) player.yspeed=0;
		}
		if(e.getKeyCode()==e.VK_DOWN) {
			if(player.yspeed==2) player.yspeed=0;
		}
		
	}
	
}

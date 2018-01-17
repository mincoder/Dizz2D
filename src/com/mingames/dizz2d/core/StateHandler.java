package com.mingames.dizz2d.core;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import com.mingames.dizz2d.engine.State;
import com.mingames.dizz2d.game.GameState;
import com.mingames.dizz2d.menus.DeadState;
import com.mingames.dizz2d.menus.MenuState;

public class StateHandler{
	
	State[] states = new State[3];
	int currentStateId=0;
	
	public static final int MENU = 0;
	public static final int DEAD = 1;
	public static final int GAME = 2;
	
	public StateHandler(int startState) {
		states[MENU] = new MenuState();
		states[DEAD] = new DeadState();
		states[GAME] = new GameState();
		currentStateId = startState;
	}

	public void setState(int newstate) {
		currentStateId = newstate;
	}
	
	public void update() {
		states[currentStateId].update();
	}
	
	public void render(Graphics g) {
		states[currentStateId].render(g);
	}
}

package com.mingames.dizz2d.core;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Dizz2D extends JPanel implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6169009507877465089L;
	StateHandler sh;
	Timer tim;
	
	public static final int MillisecondsBetweenTicks = 25;
	
	public Dizz2D() {
		
		sh = new StateHandler(StateHandler.GAME);
		
		//Starting game loop
		tim = new Timer(MillisecondsBetweenTicks,this);
		tim.setInitialDelay(MillisecondsBetweenTicks);
		tim.start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
	}
	
	public void paint(Graphics g) {
		/*g.fillRect(0, 0, 700, 700);
		BufferedImage image = null;
        try {
			image = ImageIO.read(new File("tiles.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		g.drawImage(image, 0, 0, null);*/
		sh.render(g);
	}
	
}

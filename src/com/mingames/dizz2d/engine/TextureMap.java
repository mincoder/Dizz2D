package com.mingames.dizz2d.engine;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;

import javax.imageio.ImageIO;

public class TextureMap {
		
    	BufferedImage imgs[][]; //Image array to hold image chunks
		
	    public TextureMap(String texture,int w, int h) {

	        File file = new File(texture); // I have bear.jpg in my working directory
	        FileInputStream fis = new FileInputStream(file);
	        BufferedImage image = ImageIO.read(fis); //reading the image fil
	        
	        imgs = new BufferedImage[w][h];

	        for (int x = 0; x < w; x++) {
	            for (int y = 0; y < w; y++) {
	                imgs[x][y] = new BufferedImage(chunkWidth, chunkHeight, image.getType());

	                Graphics2D gr = imgs[x][y].createGraphics();
	                gr.drawImage(image, 0, 0, chunkWidth, chunkHeight, chunkWidth * y, chunkHeight * x, chunkWidth * y + chunkWidth, chunkHeight * x + chunkHeight, null);
	                gr.dispose();
	            }
	        }
	    }
}

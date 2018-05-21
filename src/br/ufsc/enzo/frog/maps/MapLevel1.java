package br.ufsc.enzo.frog.maps;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class MapLevel1 implements Map{
	
	private BufferedImage background;
	private int x;
	private int y;
	
	public MapLevel1(String scnPath,int x,int y) {
		background = loadImage(scnPath);
		this.x = x;
		this.y = y;
	}

	public void update() {
		
	}

	public void draw(Graphics g) {
		g.drawImage(background, x, y, null);
	}
	
	private BufferedImage loadImage(String path) {
		try {
			BufferedImage m = ImageIO.read(new File(path));
			return m;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

}

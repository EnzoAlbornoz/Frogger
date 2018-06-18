package br.ufsc.enzo.frog.maps;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import br.ufsc.enzo.frog.utils.Utils;

public class Map {
	
	private BufferedImage background;
	private int x;
	private int y;
	
	public Map(String scnPath,int x,int y) {
		background = Utils.loadImage(scnPath);
		this.x = x;
		this.y = y;
	}

	public void update() {
		
	}

	public void draw(Graphics g) {
		g.drawImage(background, x, y, null);
	}

}

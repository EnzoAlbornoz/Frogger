package br.ufsc.enzo.frog.gfx;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import jplay.GameImage;

public class Sprite {
	
	private GameImage[] spriteList;
	private int spriteSize;
	private BufferedImage spriteSheet;
	
	public Sprite(String filePath,int size) {
		try {
			spriteSheet = ImageIO.read(new File(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
		spriteSize  = size;
	}
	
	public BufferedImage[] createSpriteList() {
		int widthFrames  = spriteSheet.getWidth()  / spriteSize;
		int heightFrames = spriteSheet.getHeight() / spriteSize;
		BufferedImage[] out = new BufferedImage[widthFrames*heightFrames];
		int n = 0;
		for(int i = 0;i < heightFrames;i++) {
			for(int j = 0;j < heightFrames;j++) {
				out[n] = spriteSheet.getSubimage(i * spriteSize,
												 j * spriteSize,
												 spriteSize,
												 spriteSize);
				n++;
			}
		}
		return out;
	}
	//ARRUMAR - TA DANDO PROBLEMA DE PEGAR PARTE INEXISTENTE
	public static BufferedImage[][] createSpriteList(String filePath,int size) {
		BufferedImage sheet = null;
		try {
			sheet = ImageIO.read(new File(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
		int widthFrames  = sheet.getWidth()  / size;
		System.out.println(widthFrames);
		int heightFrames = sheet.getHeight() / size;
		System.out.println(heightFrames);
		BufferedImage[][] out = new BufferedImage[heightFrames][widthFrames];
		for(int i = 0;i < heightFrames;i++) {
			for(int j = 0;j < widthFrames;j++) {
				out[i][j] = sheet.getSubimage(j * size, i * size, size, size);
				System.out.println("sub image "+i+j+" created");
			}
		}
		return out;
	}
}

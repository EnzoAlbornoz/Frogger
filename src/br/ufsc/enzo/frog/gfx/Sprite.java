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
	
	/**
	 * 
	 * @param filePath - Path of the file in classPath
	 * @param size - size of the 1:1 sprite
	 * @return A cropped sprite sheet in a matrix
	 */
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
	
	public static BufferedImage[] createLineOfSpriteList(String filePath,int size,int line) {
		BufferedImage[][] m = createSpriteList(filePath, size);
		BufferedImage[] sheet = new BufferedImage[m[line].length];
		sheet = m[line];
		return sheet;
	}
	
	public static BufferedImage[] getLineOfSpriteList(BufferedImage[][] sheet,int line) {
		BufferedImage[] out = new BufferedImage[sheet[line].length];
		out = sheet[line];
		return out;
	}
	
	public static BufferedImage[] createLinearSpriteList(String filePath,int size) {
		BufferedImage[][] m = createSpriteList(filePath, size);
		BufferedImage[] out = new BufferedImage[m.length*m[0].length];
		int c = 0;
		for(int i = 0;i < m.length;i++) {
			for(int j = 0;j < m[0].length;j++) {
				out[c] = m[i][j];
			}
		}
		
		return out;
	}
}

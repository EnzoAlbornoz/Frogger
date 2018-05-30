package br.ufsc.enzo.frog.utils;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Utils {
	//IMAGE-LOADER--------------------------------
	public static BufferedImage loadImage(String imagePath) {
		try {
			return ImageIO.read(new File(imagePath));
		} catch (IOException e) {
			System.err.println("Não Foi Possivel Carregar a Imagem");
			e.printStackTrace();
			return null;
		}
	}
	public static BufferedImage loadImage(String imagePath,boolean flip) {
		BufferedImage image = loadImage(imagePath);
		if(flip) {
			image = rotate(image);
		}
		return image;
	}
	public static BufferedImage loadImage(String imagePath,int width,int height) {
		BufferedImage m = loadImage(imagePath);
		return (BufferedImage) m.getScaledInstance(width,height,BufferedImage.SCALE_DEFAULT);
	}	
	public static BufferedImage loadImage(String imagePath,int width,int height,boolean flip) {
		BufferedImage m = loadImage(imagePath,flip);
		return (BufferedImage) m.getScaledInstance(width,height,BufferedImage.SCALE_DEFAULT);
	}
	//--------------------------------------------
	
	//ROTATOR-------------------------------------
	public static BufferedImage rotate(BufferedImage img) {  
		try {
			if(img != null) {
				int w = img.getWidth();  
				int h = img.getHeight();  
				BufferedImage dimg = new BufferedImage(w, h, img.getType());  
				Graphics2D g = dimg.createGraphics();  
				g.drawImage(img, 0, 0, w, h, w, 0, 0, h, null);  
				g.dispose();  
				return dimg;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return img;
	}	
	//--------------------------------------------
}

package br.ufsc.enzo.frog.utils;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Utils {
	
	public static BufferedImage loadImage(String imagePath) {
		try {
			return ImageIO.read(new File(imagePath));
		} catch (IOException e) {
			System.err.println("Não Foi Possivel Carregar a Imagem");
			e.printStackTrace();
			return null;
		}
	}
	
	public static BufferedImage loadImage(String imagePath,int width,int height,int degrees) {
		BufferedImage m;
		try {
			m = (BufferedImage)ImageIO.read(new File(imagePath));
		} catch (IOException e) {
			System.err.println("Não Foi Possivel Carregar a Imagem");
			e.printStackTrace();
			return null;
		}
		rotate(m,degrees);
		return (BufferedImage) m.getScaledInstance(width,height,BufferedImage.SCALE_DEFAULT);
	}
	
	public static BufferedImage loadImage(String imagePath,int degrees) {
		BufferedImage m;
		try {
			m = (BufferedImage)ImageIO.read(new File(imagePath));
		} catch (IOException e) {
			System.err.println("Não Foi Possivel Carregar a Imagem");
			e.printStackTrace();
			return null;
		}
		rotate(m,degrees);
		return m;
	}
	
	public static BufferedImage rotate(BufferedImage image,int degrees) {
		
		AffineTransform transform = new AffineTransform();
		transform.rotate(Math.toRadians(degrees));
		
		BufferedImage img = image;
		Graphics2D g2d = img.createGraphics();
		g2d.transform(transform);
		
		return img;
	}
}

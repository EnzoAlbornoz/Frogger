package br.ufsc.enzo.frog.models;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public abstract class Mob {
	//ATRIBUTES-----------------------------------
		protected Rectangle rect;
		protected int size;
		protected double velocity = 1;
		protected BufferedImage sprite;
		protected int posX;
		protected int posY;
		//--------------------------------------------
		public abstract void draw(Graphics g);
		public abstract void update();
		public abstract void move();
}

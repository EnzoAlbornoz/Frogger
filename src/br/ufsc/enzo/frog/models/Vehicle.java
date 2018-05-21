package br.ufsc.enzo.frog.models;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import br.ufsc.enzo.frog.utils.Utils;

public class Vehicle {
	
	private Rectangle rect;
	private int size;
	private double velocity = 1;
	private BufferedImage sprite;
	private int posX;
	private int posY;
	
	public Vehicle(int type,int dificulty,int line) {
		if(type == 1) {
			sprite = Utils.loadImage("res/Sprites/Car.png");
			size = 2;
		}else if(type == 0){
			sprite = Utils.loadImage("res/Sprites/Truck.png");
			size = 3;
		}
		velocity += 0.5 * dificulty;
		if((line % 2) == 1) {
			posX = 112 - (48 * size);
		}else {
			velocity = -velocity;
			posX = 688;
		}
		posY = 552 - (48 * line);
		rect = new Rectangle(posX, posY, size*48, 48);
	}
	
	public void update() {
		move();
		rect.setLocation(posX, posY);
	}
	
	public void draw(Graphics g) {
		g.drawImage(sprite, posX, posY, null);
	}
	
	public void move() {
		posX += velocity;
	}
	
	public Rectangle getRect() {
		return rect;
	}
	
	//COLISION---------------------------------
	public boolean colides(Player player) {
		if(rect.intersects(player.getRect())) {
			return true;
		}
		return false;
	}
	
}

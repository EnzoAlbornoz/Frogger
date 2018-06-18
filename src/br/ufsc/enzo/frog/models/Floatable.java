package br.ufsc.enzo.frog.models;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.Random;

import br.ufsc.enzo.frog.utils.Utils;

public class Floatable extends Mob {
	private static Random r = new Random();
	
	//CONSTRUCTORS--------------------------------
	public Floatable(int type,int dificulty,int line) {
		if(type == 1) {
			sprite = Utils.loadImage("res/Sprites/Turtle.png");
			size = 1;
		}else if(type == 0){
			sprite = Utils.loadImage("res/Sprites/Trunk.png");
			size = 2 + (r.nextInt(2) % 2);
		}
		velocity += 0.5 * dificulty;
		if((line % 2) == 1) {
			posX = 112 - (48 * size);
		}else {
			velocity = -velocity;
			sprite = Utils.rotate(sprite);
			posX = 688;
		}
		posY = 552 - (48 * line);
		rect = new Rectangle(posX, posY, size*48, 48);
	}
	public Floatable(int type, int dificulty,int line,int initPreset) {
		if(type == 1) {
			sprite = Utils.loadImage("res/Sprites/Turtle.png");
			size = 1;
		}else if(type == 0){
			sprite = Utils.loadImage("res/Sprites/Trunk.png");
			size = 2 + (r.nextInt(2) % 2);
			initPreset++;
		}
		velocity += 0.5 * dificulty;
		if((line % 2) == 1) {
			posX = 112 - (48 * size) + (48 * initPreset);
		}else {
			velocity = -velocity;
			sprite = Utils.rotate(sprite);
			posX = 688 - (48 * initPreset);
		}
		posY = 552 - (48 * (line+6));
		rect = new Rectangle(new Point(posX, posY),new Dimension(48 * size, 48));
	}
	
	//--------------------------------------------
	
	//GAME-LOOP-----------------------------------
	public void update() {
		move();
	}
	public void draw(Graphics g) {
		for(int i = 0;i < size;i++) {
			g.drawImage(sprite, (posX+(48*i)), posY, null);
		}
	}	
	public void move() {
		posX += velocity;
		rect.setLocation(posX, posY);
	}
	//--------------------------------------------
	
	//GETTERS-&&-SETTERS--------------------------
		public int getPosX() {
			return posX;
		}	
		public int getSize() {
			return size;
		}
		public void setPosX(int newPos) {
			posX = newPos;
		}
		public Rectangle getBounds() {
			return new Rectangle(posX+6, posY+6, 48*size-12, 36);
		}
		//--------------------------------------------

}

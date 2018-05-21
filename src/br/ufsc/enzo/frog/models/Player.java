package br.ufsc.enzo.frog.models;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

import br.ufsc.enzo.frog.gfx.Animation;
import br.ufsc.enzo.frog.gfx.Sprite;
import jplay.GameImage;
import jplay.Keyboard;
import jplay.URL;

@SuppressWarnings("serial")
public class Player {
	//RECT-COLISOR
	private Rectangle rect;
	//VARIÁVEIS DE POSIÇÃO
	private int posX;
	private int posY;
	private int line;
	//GRAFICOS
	private static final int SCALE  = 48;
	private static final int WIDTH  = 48;
	private static final int HEIGHT = 48;
	//MOVIMENTAÇÃO
	private boolean     up = false;
	private boolean  right = false;
	private boolean   left = false;
	private boolean   down = false;
	private int direction    = 0;
	private int before = 0; 
	private boolean moved = false;
	//ANIMATION
	private Animation anim;
	private BufferedImage[] spriteList;
	private int dx;
	private int dy;
	//--------------------------------------------

	//CONSTRUCTOR---------------------------------
	public Player(int x,int y) {
		posX = x;
		posY = y;
		rect = new Rectangle();
		rect.setBounds(posX, posX, WIDTH, HEIGHT);
		spriteList = Sprite.createLinearSpriteList("res/Player/Frog Color 1.png", 48);		
		anim = new Animation(200, spriteList);
	}
	//--------------------------------------------

	
	//UPDATE--------------------------------------
	public void update() {
		move();
		rect.setLocation(posX, posY);
	}
	//--------------------------------------------
	
	
	//DRAW----------------------------------------
	public void draw(Graphics g) {
		//ANIMATION-VIEW--------------------------
			g.drawImage(getCurrentAnimationFrame(), posX+dx, posY+dy, null);
		//----------------------------------------
	}
	//--------------------------------------------
	
	
	//KEY-LISTENERS-------------------------------
	public void keyPressed(int k) {
		if(!moved) {
			if(k == Keyboard.UP_KEY) {
				up = true;
				direction = 0;
				return;
				
			}
			if(k == Keyboard.RIGHT_KEY){
				right = true;
				direction = 1;
				return;
				
			}
			if(k == Keyboard.LEFT_KEY) {
				direction = 2;
				left = true;
				return;
				
			}
			if(k == Keyboard.DOWN_KEY) {
				down = true;
				direction = 3;
				return;
				
			}
		}
	}
	
	public void keyReleased(int k) {
		if(moved) {
		if (k == Keyboard.UP_KEY)    {
			up     = false;
			moved  = false;
			before = 0;
			dy = 0;
			return;

		}
		if (k == Keyboard.RIGHT_KEY) {
			right = false;
			moved = false;
			before = 1;
			dx = 0;
			return;

		}
		if (k == Keyboard.LEFT_KEY)  {
			left  = false;
			moved = false;
			before = 2;
			dx = 0;
			return;

		}
		if (k == Keyboard.DOWN_KEY)  {
			down  = false;
			moved = false;
			before = 3;
			dy = 0;
			return;

		}
		}
	}
	
	public void keyTyped(int k) {}
	//--------------------------------------------
	
	
	//MOVEMENT------------------------------------
	private void move() {
		if(!moved) {
			if(up    && posY > HEIGHT) {
				dy = +24; 
				moved = true;
				direction=0;
				posY -= 1 * SCALE;
				line += 1;
				return;
			}
			if(right && posX+WIDTH < 700-WIDTH) {
				dx = -24;
				moved = true;
				direction=1;
				posX += 1 * SCALE;
				return;
			}	
			if(left  && posX > 100 + WIDTH) {
				dx = +24;
				moved = true;
				direction=2;
				posX -= 1 * SCALE;
				return;
			}
			if(down  && posY+HEIGHT < 600-HEIGHT) {
				dy = -24;
				moved = true;
				direction=3;
				posY += 1 * SCALE;
				line -= 1;
				return;
			}
		}
	}
	//--------------------------------------------
	
	
	//ANIMATION-METHODS---------------------------
	private BufferedImage getCurrentAnimationFrame() {
		if(moved) {
			return anim.getThisImage(9-(3*direction));
		}else {
			return anim.getThisImage(10-(3*before));
		}
	}
	//--------------------------------------------
	
	//COLLISIONS 
	public boolean collided(Rectangle other) {
		if(rect.intersects(other)) {
			return true;
		}
		return false;
	}
	//--------------------------------------------

}
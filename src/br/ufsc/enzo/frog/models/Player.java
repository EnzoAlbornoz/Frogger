package br.ufsc.enzo.frog.models;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

import br.ufsc.enzo.frog.gfx.Sprite;
import br.ufsc.enzo.frog.states.GameOverState;
import br.ufsc.enzo.frog.states.GameStateManager;
import jplay.GameImage;
import jplay.Keyboard;
import jplay.URL;

@SuppressWarnings("serial")
public class Player {
	//RECT-COLISOR
	private Rectangle rect;
	//VARIÃ�VEIS DE POSIÃ‡ÃƒO
	private int posX;
	private int posY;
	private int line;
	//GRAFICOS
	private static final int SCALE  = 48;
	private static final int WIDTH  = 48;
	private static final int HEIGHT = 48;
	//MOVIMENTAÃ‡ÃƒO
	private boolean     up = false;
	private boolean  right = false;
	private boolean   left = false;
	private boolean   down = false;
	private int direction    = 0;
	private int before = 0; 
	private boolean moved = false;
	//ANIMATION
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
	}
	//--------------------------------------------

	
	//UPDATE--------------------------------------
	public void update(GameStateManager gsm,Points points) {
		move();
		rect.setLocation(posX, posY);
		verifyBounds(gsm,points);
	}
	public void lockBoundsWith(Floatable f) {
		posX += f.velocity;
		rect.setLocation(posX, posY);
	}
	private void verifyBounds(GameStateManager gsm,Points points) {
		if(line > 6 && line < 12) {
			if(posX < 112 - WIDTH || posX > 700) {
				gsm.setState(new GameOverState(gsm,points));
			}
		}
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
			if(k == KeyEvent.VK_UP) {
				up = true;
				direction = 0;
				return;
				
			}
			if(k == KeyEvent.VK_RIGHT){
				right = true;
				direction = 1;
				return;
				
			}
			if(k == KeyEvent.VK_LEFT) {
				direction = 2;
				left = true;
				return;
				
			}
			if(k == KeyEvent.VK_DOWN) {
				down = true;
				direction = 3;
				return;
				
			}
			if(true) {
				
			}

		}
	}
	
	public void keyReleased(int k) {
		if(moved) {
			if(k == KeyEvent.VK_UP) {
			up     = false;
			moved  = false;
			before = 0;
			dy = 0;
			return;

		}
			if(k == KeyEvent.VK_RIGHT){
			right = false;
			moved = false;
			before = 1;
			dx = 0;
			return;

		}
			if(k == KeyEvent.VK_LEFT) {
			left  = false;
			moved = false;
			before = 2;
			dx = 0;
			return;

		}
			if(k == KeyEvent.VK_DOWN) {
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
			}else 
			if(right && posX+WIDTH < 700-WIDTH) {
				dx = -24;
				moved = true;
				direction=1;
				posX += 1 * SCALE;
				return;
			}else
			if(left  && posX > 100 + WIDTH) {
				dx = +24;
				moved = true;
				direction=2;
				posX -= 1 * SCALE;
				return;
			}else
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
			return spriteList[9-(3*direction)];
		}else {
			return spriteList[10-(3*before)];
		}
	}
	//--------------------------------------------
	
	//GETTERS-------------------------------------
	public int getLine() {
		return line;
	}
	
	public Rectangle getRect() {
		return rect;
	}
	public int getPosX() {
		return posX;
	}
	public int getPosY() {
		return posY;
	}
	public Rectangle getBounds() {
		return (new Rectangle(posX+6,posY+6,WIDTH-12, HEIGHT-12));
	}
	//--------------------------------------------


}
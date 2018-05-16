package br.ufsc.enzo.frog.models;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

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
	//GRAFICOS
	private static final int SCALE  = 10;
	private static final int WIDTH  = 48;
	private static final int HEIGHT = 48;
	private BufferedImage[] spriteList;
	//MOVIMENTAÇÃO
	private boolean     up = false;
	private boolean  right = false;
	private boolean   left = false;
	private boolean   down = false;
	private int before = 0;
	
	public Player(int x,int y) {
		posX = x;
		posY = y;
		rect = new Rectangle();
		rect.setBounds(posX, posX, WIDTH, HEIGHT);
		spriteList = Sprite.createSpriteList("res/Player/Frog Color 1.png", 48);
	}
	
	public void update() {
			move();
	}

	
	public void draw(Graphics g) {
		g.drawImage(spriteList[0], 0, 0, null);
	}

	
	public void keyPressed(int k) {
		if (k == Keyboard.UP_KEY)    {
			up = true;
			return;

		}
		if (k == Keyboard.RIGHT_KEY) {
			right = true;
			return;

		}
		if (k == Keyboard.LEFT_KEY)  {
			left = true;
			return;

		}
		if (k == Keyboard.DOWN_KEY)  {
			down = true;
			return;
		}
	}
	
	public void keyReleased(int k) {
		if (k == Keyboard.UP_KEY)    {
			up    = false;

		}
		if (k == Keyboard.RIGHT_KEY) {
			right = false;

		}
		if (k == Keyboard.LEFT_KEY)  {
			left  = false;

		}
		if (k == Keyboard.DOWN_KEY)  {
			down  = false;

		}
	}
	
	private void move() {
		if(up    && posY > 0  ) {
			posY -= 1 * SCALE;
			before=0;
		}
		if(right && posX < 700) {
			posX += 1 * SCALE;
			before=1;
		}
		if(left  && posX > 100) {
			posX -= 1 * SCALE;
			before=2;
		}
		if(down  && posY < 600) {
			posY += 1 * SCALE;
			before=3;
		}
	}
}

package br.ufsc.enzo.frog.states;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import br.ufsc.enzo.frog.FrogGame;
import br.ufsc.enzo.frog.gfx.Sprite;
import br.ufsc.enzo.frog.utils.Utils;

public class ControlsState extends GameState {

	private BufferedImage menuTitle;
	private BufferedImage[] spriteList;
	
	public ControlsState(GameStateManager gsm) {
		super(gsm);
	}

	
	public void init() {
		menuTitle = Utils.loadImage("res/menuTitle.png");	
		spriteList = Sprite.createLinearSpriteList("res/Player/Frog Color 1.png", 48);
	}

	
	public void update() {

		
	}

	
	public void draw(Graphics g) {
		//SHOW-BACKGROUND-WITH-ESC-OPTION---------
		g.setColor(Color.DARK_GRAY);
		g.fillRect(0, 0, FrogGame.WIDTH, FrogGame.HEIGHT);
		g.drawImage(menuTitle, 100, 0,Color.DARK_GRAY, null);
		g.setColor(Color.BLACK);
		g.fillRect(110, 10, 100, 30);
		g.setColor(Color.GREEN);
		g.setFont(new Font("Verdana",Font.BOLD,25));
		g.drawString("< ESC", 117, 35);
		//SHOW-CONTROLS---------------------------
		showControls(g,299,349);
	}

	
	public void keyPressed(int k) {
		switch(k) {
			case KeyEvent.VK_ESCAPE:
				gsm.setState(new MenuState(gsm));
				break;
		}
	}

	
	public void keyReleased(int k) {

		
	}
	
	public void keyTyped(int k) {}
	
	//SHOW-CONTROLS-------------------------------
	private void showControls(Graphics g,int posX,int posY) {
		g.setColor(Color.BLACK);
		g.fillRect(posX, posY, 200, 200);
		g.setColor(Color.WHITE);
		g.drawRect(posX, posY, 200, 200);
		g.setColor(Color.GREEN);
		g.setFont(new Font("Verdana",Font.BOLD,25));
		g.drawString("Up", posX+5, posY+45);
		g.drawString("Right", posX+5, posY+95);
		g.drawString("Left", posX+5, posY+145);
		g.drawString("Down", posX+5, posY+195);
		for(int i = 0;i < 4;i++) {
			g.drawString("->", posX+100, posY+45+(50*i));
			g.drawImage(spriteList[9-(3*i)], posX+145, posY+5+(50*i), null);
		}
	}
}

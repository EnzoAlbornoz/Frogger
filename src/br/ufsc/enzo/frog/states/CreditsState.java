package br.ufsc.enzo.frog.states;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import br.ufsc.enzo.frog.FrogGame;
import br.ufsc.enzo.frog.utils.LastGames;
import br.ufsc.enzo.frog.utils.Utils;

public class CreditsState extends GameState {
	
	private BufferedImage menuTitle;

	public CreditsState(GameStateManager gsm) {
		super(gsm);
	}

	
	public void init() {
		menuTitle = Utils.loadImage("res/menuTitle.png");		
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
		//SHOW-LASTGAMES-INFO
		LastGames.show(g,299,349);
		
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
	
}

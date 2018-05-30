package br.ufsc.enzo.frog.states;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import br.ufsc.enzo.frog.FrogGame;
import br.ufsc.enzo.frog.utils.LastGames;

public class CreditsState extends GameState {

	public CreditsState(GameStateManager gsm) {
		super(gsm);
	}

	
	public void init() {

		
	}

	
	public void update() {

		
	}

	
	public void draw(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, FrogGame.WIDTH, FrogGame.HEIGHT);
		LastGames.show(g);
		
	}

	
	public void keyPressed(int k) {

		
	}

	
	public void keyReleased(int k) {

		
	}

	public void keyTyped(int k) {}
	
}

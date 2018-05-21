package br.ufsc.enzo.frog.states;

import java.awt.Graphics;

public class GameOverState extends GameState{

	private int points;
	
	public GameOverState(GameStateManager gsm,int points) {
		super(gsm);
		this.points = points;
	}


	public void init() {
		loadPoints("");
		
	}

	
	public void update() {
		
		
	}

	
	public void keyPressed(int k) {
		
		
	}

	
	public void draw(Graphics g) {
		
		
	}

	
	public void keyReleased(int k) {
		
		
	}

	
	public void keyTyped(int k) {
		
		
	}
	
	private String loadPoints(String filePath) {
		
	}
}

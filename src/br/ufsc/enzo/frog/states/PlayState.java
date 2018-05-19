package br.ufsc.enzo.frog.states;

import java.awt.Graphics;

import br.ufsc.enzo.frog.models.Player;
import jplay.Scene;
import jplay.URL;

public class PlayState extends GameState {
	
	private Scene scene;
	private Player player;

	public PlayState(GameStateManager gsm) {
		super(gsm);
		
		
	}

	
	public void init() {
		player = new Player(16, 16);

	}

	
	public void update() {
		player.update();

	}

	
	public void draw(Graphics g) {
		player.draw(g);
	}

	
	public void keyPressed(int k) {
		player.keyPressed(k);

	}

	
	public void keyReleased(int k) {
		player.keyReleased(k);

	}
	
	public void keyTyped(int k) {
		player.keyTyped(k);
	}
	
}

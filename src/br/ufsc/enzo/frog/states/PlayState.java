package br.ufsc.enzo.frog.states;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import br.ufsc.enzo.frog.maps.Map;
import br.ufsc.enzo.frog.maps.MapLevel1;
import br.ufsc.enzo.frog.models.Vehicle;
import br.ufsc.enzo.frog.models.Player;
import br.ufsc.enzo.frog.utils.Utils;

public class PlayState extends GameState {
	
	private Player player;
	private MapLevel1 map;
	private Vehicle en1;
	

	public PlayState(GameStateManager gsm) {
		super(gsm);
		
	}

	
	public void init() {
		player = new Player(111, 545);
		map = new MapLevel1("res/Scenes/Mapa1.png",111,24);
		en1 = new Vehicle(0, 0, 1);
	}

	
	public void update() {
		en1.update();
		player.update();

	}

	
	public void draw(Graphics g) {
		map.draw(g);
		en1.draw(g);
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

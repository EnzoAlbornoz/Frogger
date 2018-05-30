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
import br.ufsc.enzo.frog.models.Points;
import br.ufsc.enzo.frog.models.Transit;
import br.ufsc.enzo.frog.utils.Collisions;
import br.ufsc.enzo.frog.utils.Utils;

public class PlayState extends GameState {
	
	private Player player;
	private MapLevel1 map;
	private Transit transit;
	private int dificulty;
	private Points points;

	public PlayState(GameStateManager gsm) {
		super(gsm);
	}

	
	public void init() {
		player = new Player((111+(48*5)), 545);
		map = new MapLevel1("res/Scenes/Mapa1.png",111,24);
		dificulty = 0;
		transit = new Transit(dificulty);
		points = new Points();
	}

	
	public void update() {
		player.update();
		transit.update();
		transit.verifyBounds();
		colides(player,transit);
		points.update(player);
		toNextLevel();
	}

	
	public void draw(Graphics g) {
		map.draw(g);
		player.draw(g);
		transit.draw(g);
		points.draw(g);
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
	//STATE-METHODS-------------------------------
	public void colides(Player player,Transit transit) {
		if(Collisions.collides(player, transit)) {
			gsm.setState(new GameOverState(gsm,points));
		}
	}
	
	public void toNextLevel() {
		if(player.getLine() == 11) {
			dificulty++;
			player = new Player((111+(48*5)),545);
			transit = new Transit(dificulty);
			points.setDificulty(dificulty);
		}
	}
	//--------------------------------------------
}

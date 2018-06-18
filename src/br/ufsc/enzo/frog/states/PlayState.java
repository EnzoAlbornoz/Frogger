package br.ufsc.enzo.frog.states;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import br.ufsc.enzo.frog.maps.Map;
import br.ufsc.enzo.frog.models.Vehicle;
import br.ufsc.enzo.frog.models.Floatable;
import br.ufsc.enzo.frog.models.Player;
import br.ufsc.enzo.frog.models.Points;
import br.ufsc.enzo.frog.models.River;
import br.ufsc.enzo.frog.models.Transit;
import br.ufsc.enzo.frog.utils.Utils;

public class PlayState extends GameState {
	
	private Player player;
	private Map map;
	private Transit transit;
	private int dificulty;
	private Points points;
	private River river;
	
	public PlayState(GameStateManager gsm) {
		super(gsm);
	}

	
	public void init() {
		player = new Player((111+(48*5)), 545);
		map = new Map("res/Scenes/Mapa1.png",111,24);
		dificulty = 0;
		transit = new Transit(dificulty);
		points = new Points();
		river = new River(dificulty);
	}

	
	public void update() {
		player.update(gsm,points);
		transit.update(player,gsm,points);
		river.update(player,gsm,points);
		points.update(player);
		toNextLevel();
	}

	
	public void draw(Graphics g) {
		map.draw(g);
		transit.draw(g);
		points.draw(g);
		river.draw(g);
		player.draw(g);
		spawnHide(g);
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
	private void toNextLevel() {
		if(player.getLine() == 11) {
			dificulty++;
			player = new Player((111+(48*5)),545);
			transit = new Transit(dificulty);
			points.setDificulty(dificulty);
		}
	}
	//--------------------------------------------
	//HIDE-SPAWNER--------------------------------
	private void spawnHide(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 112, 600);
		g.fillRect(686, 0, 115,600);
	}
}

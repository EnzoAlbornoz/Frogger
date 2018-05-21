package br.ufsc.enzo.frog.states;

import java.awt.Graphics;
import java.awt.Graphics2D;
//ClASSE CRIADA PARA PADRONIZAR GAME-STATES (AULA XTI)
public abstract class GameState {
	
	protected GameStateManager gsm;
	
	public GameState(GameStateManager gsm) {
		this.gsm = gsm;
		init();
	}
	
	public abstract void init();
	public abstract void update();
	public abstract void keyPressed(int k);
	public abstract void draw(Graphics g);
	public abstract void keyReleased(int k);
	public abstract void keyTyped(int k);
}

package br.ufsc.enzo.frog.states;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Stack;

public class GameStateManager {
	/*ESSA PARTE(CRIAÇÃO DE PILHA) FOI RETIRADA DE UM VIDEO PARA 
	 *RESOLVER UM PROBLEMA DE GERENCIAMENTO DE ESTADOS
	 */
	private Stack<GameState> states;
	
	public GameStateManager() {
		states  = new Stack<GameState>();		
		states.push(new MenuState(this));
	}
	
	public void update() {
		states.peek().update();
	}
	
	public void draw(Graphics g) {
		states.peek().draw(g);
	}
	
	public void keyPressed  (int k) {
		states.peek().keyPressed(k);
	}
	
	public void keyReleased (int k) {
		states.peek().keyReleased(k);
	}
	
	public void setState(GameState state) {
		states.push(state);
	}
	
}

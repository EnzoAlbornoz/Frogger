package br.ufsc.enzo.frog.states;

import java.awt.Graphics2D;
import java.util.Stack;

public class GameStateManager {
	/*ESSA PARTE FOI RETIRADA DE UM VIDEO PARA 
	 *RESOLVER UM PROBLEMA DE GERENCIAMENTO DE ESTADOS
	 */
	private Stack<GameState> states;
	
	public GameStateManager() {
		states  = new Stack<GameState>();		
	}
	
	public void update() {
		states.peek().update();
	}
	
	public void draw(Graphics2D g) {
		states.peek().draw(g);
	}
	
	public void keyPressed  (int k) {
		states.peek().keyPressed(k);
	}
	
	public void keyReleased (int k) {
		states.peek().keyReleased(k);
	}
}

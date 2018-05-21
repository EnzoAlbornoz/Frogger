package br.ufsc.enzo.frog.states;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import br.ufsc.enzo.frog.FrogGame;
import jplay.GameImage;
import jplay.Keyboard;

public class MenuState extends GameState {

	private String[] options = {"Jogar","Controles","Creditos","Sair",};
	private int actualOption = 0;
	private GameImage menuTitle = new GameImage("res/menuTitle.png");
			
	public MenuState(GameStateManager gsm) {
		super(gsm);
	}

	public void init() {}

	public void update() {
		
	}

	public void draw(Graphics g) {
		//MOSTRA O FUNDO
		g.setColor(Color.DARK_GRAY);
		g.fillRect(0, 0, FrogGame.WIDTH, FrogGame.HEIGHT);
		g.drawImage(menuTitle.image, 100, 0,Color.BLACK, null);
		//DEFINE AS CONFIGS DAS OPÇÕES
		g.setColor(Color.GREEN);
		g.setFont(new Font("Arial",Font.BOLD,35));
		//DESENHA AS OPÇÕES NA TELA
		for(int i = 0;i < options.length;i++) {
			g.drawString(options[i], 325, 385 + i * 50);
	
		}
		g.drawString(">", 300, 385 + actualOption * 50);
	}
	public void keyPressed(int k) {
		if(k == Keyboard.UP_KEY) {
			if(actualOption > 0) {
				actualOption--;
			}
			return;
		}
		if(k == Keyboard.DOWN_KEY) {
			if(actualOption < options.length - 1) {
				actualOption++;
			}
			return;
		}
		//TRANSIÇÃO PARA O PRÓXIMO CENÁRIO
		if(k == Keyboard.ENTER_KEY) {
			switch(actualOption) {
				case 0:
					gsm.setState(new PlayState(gsm));
					return;
				case 1:
					gsm.setState(new ControlsState(gsm));
					return;
				case 2:
					gsm.setState(new CreditsState(gsm));
					return;
				case 3:
					System.exit(0);
					return;
			}
		}
	}

	public void keyReleased(int k) {
		
	}
	
	public void keyTyped(int k) {}
}

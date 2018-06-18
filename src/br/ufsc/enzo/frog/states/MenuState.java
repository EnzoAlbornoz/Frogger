package br.ufsc.enzo.frog.states;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import br.ufsc.enzo.frog.FrogGame;
import br.ufsc.enzo.frog.utils.Utils;

public class MenuState extends GameState {

	private String[] options = {"Play","Controls","Scores","Sair",};
	private int actualOption = 0;
	private BufferedImage menuTitle = Utils.loadImage("res/menuTitle.png");
			
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
		g.drawImage(menuTitle, 100, 0,Color.BLACK, null);
		//DEFINE AS CONFIGS DAS OPÃ‡Ã•ES
		g.setColor(Color.GREEN);
		g.setFont(new Font("Arial",Font.BOLD,35));
		//DESENHA AS OPÃ‡Ã•ES NA TELA
		for(int i = 0;i < options.length;i++) {
			g.drawString(options[i], 325, 385 + i * 50);
	
		}
		g.drawString(">", 300, 385 + actualOption * 50);
	}
	public void keyPressed(int k) {
		if(k == KeyEvent.VK_UP) {
			if(actualOption > 0) {
				actualOption--;
			}
			return;
		}
		if(k == KeyEvent.VK_DOWN) {
			if(actualOption < options.length - 1) {
				actualOption++;
			}
			return;
		}
		//TRANSIÃ‡ÃƒO PARA O PRÃ“XIMO CENÃ�RIO
		if(k == KeyEvent.VK_ENTER) {
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

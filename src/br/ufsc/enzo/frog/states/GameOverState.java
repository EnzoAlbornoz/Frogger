package br.ufsc.enzo.frog.states;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import br.ufsc.enzo.frog.FrogGame;
import br.ufsc.enzo.frog.models.Points;
import br.ufsc.enzo.frog.utils.LastGames;

public class GameOverState extends GameState{

	private Points points;
	private int charNum;
	private final int maxChars = 7;
	private String name;
	private boolean input;
	private int selectValue;
	
	public GameOverState(GameStateManager gsm,Points points) {
		super(gsm);
		this.points = points;
	}

	public void init() {
		charNum = 0;
		input = true;
		name = "";
	}

	
	public void update() {
		if(input) {
			
		}
		
	}

	public void keyPressed(int k) {
		if(input) {
			inputMap(k);
		}else {
			selectMap(k);
		}
	}

	
	public void draw(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, FrogGame.WIDTH, FrogGame.HEIGHT);
		g.setColor(Color.WHITE);
		g.setFont(new Font("Lucidas Console",Font.BOLD,100));
		g.drawString("GAME OVER", 90, 200);
		//SHOW-INPUT-TABLE
		if(input) {
			showInput(g);
		}else{
			g.setColor(Color.WHITE);
			showSelect(g);
		}
		
	}

	
	public void keyReleased(int k) {
		
		
	}

	
	public void keyTyped(int k) {
		
		
	}
	
	//INPUT-MAPPING-------------------------------
	private void inputMap(int k) {
		if(charNum < maxChars) {
			switch(k) {
			case KeyEvent.VK_A:
				name += "A";
				charNum++;
				break;
			case KeyEvent.VK_B:
				name += "B";
				charNum++;
				break;
			case KeyEvent.VK_C:
				name += "C";
				charNum++;
				break;
			case KeyEvent.VK_D:
				name += "D";
				charNum++;
				break;
			case KeyEvent.VK_E:
				name += "E";
				charNum++;
				break;
			case KeyEvent.VK_F:
				name += "F";
				charNum++;
				break;
			case KeyEvent.VK_G:
				name += "G";
				charNum++;
				break;
			case KeyEvent.VK_H:
				name += "H";
				charNum++;
				break;
			case KeyEvent.VK_I:
				name += "I";
				charNum++;
				break;
			case KeyEvent.VK_J:
				name += "J";
				charNum++;
				break;
			case KeyEvent.VK_K:
				name += "K";
				charNum++;
				break;
			case KeyEvent.VK_L:
				name += "L";
				charNum++;
				break;
			case KeyEvent.VK_M:
				name += "M";
				charNum++;
				break;
			case KeyEvent.VK_N:
				name += "N";
				charNum++;
				break;
			case KeyEvent.VK_O:
				name += "O";
				charNum++;
				break;
			case KeyEvent.VK_P:
				name += "P";
				charNum++;
				break;
			case KeyEvent.VK_Q:
				name += "Q";
				charNum++;
				break;
			case KeyEvent.VK_R:
				name += "R";
				charNum++;
				break;
			case KeyEvent.VK_S:
				name += "S";
				charNum++;
				break;
			case KeyEvent.VK_T:
				name += "T";
				charNum++;
				break;
			case KeyEvent.VK_U:
				name += "U";
				charNum++;
				break;
			case KeyEvent.VK_V:
				name += "V";
				charNum++;
				break;
			case KeyEvent.VK_W:
				name += "W";
				charNum++;
				break;
			case KeyEvent.VK_X:
				name += "X";
				charNum++;
				break;
			case KeyEvent.VK_Y:
				name += "Y";
				charNum++;
				break;
			case KeyEvent.VK_Z:
				name += "Z";
				charNum++;
				break; 
		}
	}
	switch(k) {
		case KeyEvent.VK_BACK_SPACE:
			if(charNum > 0) {
				char[] temp = new char[name.length()-1];
				for(int i=0;i < temp.length;i++) {
					temp[i] = name.charAt(i);
				}
				name = String.valueOf(temp);
				charNum--;
			}
			break;
		case KeyEvent.VK_ENTER:
				LastGames.addScore(name, points.getPoints());
				input = false;
			break;
	}
	}
	//--------------------------------------------
	
	//SELECT-MAPPING-------------------------------
	private void selectMap(int k) {
		switch(k) {
			case KeyEvent.VK_RIGHT:
				selectValue = 1;
				break;
			case KeyEvent.VK_LEFT :
				selectValue = 0;
				break;
			case KeyEvent.VK_ENTER:
				if(selectValue == 0) {
					gsm.setState(new PlayState(gsm));
				}else {
					gsm.setState(new MenuState(gsm));;
				}
				break;
		}
	}
	//--------------------------------------------
	
	//SELECTION-DRAWER
	private void showSelect(Graphics g) {
		g.setFont(new Font("Verdana",Font.BOLD,50));
		g.setColor(Color.GREEN);
		g.drawString("Play Again?", 225, 350);
		g.setFont(new Font("Verdana",Font.PLAIN,25));
		if(selectValue == 0) {
			g.drawString(" No", 400, 400);
			g.fillRect(270, 370, 100, 45);
			g.setColor(Color.BLACK);
			g.drawString("Yes", 300, 400);
		}else {
			g.drawString("Yes", 300, 400);
			g.fillRect(270+110, 370, 100, 45);
			g.setColor(Color.BLACK);
			g.drawString(" No", 400, 400);
		}
	}
	
	//INPUT-DRAWER--------------------------------
	private void showInput(Graphics g) {
		g.setColor(Color.GREEN);
		g.drawRect(90, 210, 610, 300);
		g.setFont(new Font("Verdana",Font.BOLD,40));
		g.drawString("Points", 120, 300);
		g.drawString("Name",500 , 300);
		g.drawString("Input Your Name:", 200, 250);
		g.setFont(new Font("Verdana",Font.BOLD,35));
		g.drawString(points.getPointsString(), 125, 355);
		g.drawString(name,500,355);
	}
	
}

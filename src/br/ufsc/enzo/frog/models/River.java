package br.ufsc.enzo.frog.models;

import java.awt.Graphics;
import java.util.Random;

import br.ufsc.enzo.frog.states.GameOverState;
import br.ufsc.enzo.frog.states.GameStateManager;

public class River {
	//ATRIBUTES-----------------------------------
		private Floatable[][] river;
		private Random r;
		private int dificulty;
		//--------------------------------------------
		
		//CONSTRUCTOR---------------------------------
		public River(int dificulty) {
			this.dificulty = dificulty;
			river = new Floatable[4][4];
			r = new Random();
			init();
		}
		private void init(){
			river[0][0] = new Floatable(1,dificulty,4,0);
			river[0][1] = new Floatable(0,dificulty,4,4);
			river[0][2] = new Floatable(0,dificulty,4,8);
			river[0][3] = new Floatable(0,dificulty,4,10);
			
			river[1][0] = new Floatable(0,dificulty,3,0);
			river[1][1] = new Floatable(1,dificulty,3,4);
			river[1][2] = new Floatable(1,dificulty,3,8);
			river[1][3] = new Floatable(0,dificulty,3,10);
			
			river[2][0] = new Floatable(0,dificulty,2,1);
			river[2][1] = new Floatable(1,dificulty,2,5);
			river[2][2] = new Floatable(0,dificulty,2,7);
			river[2][3] = new Floatable(0,dificulty,2,9);
			
			river[3][0] = new Floatable(0,dificulty,1,3);
			river[3][1] = new Floatable(0,dificulty,1,7);
			river[3][2] = new Floatable(1,dificulty,1,11);
			river[3][3] = new Floatable(0,dificulty,1,0);
		}
		//--------------------------------------------
		
		//GAME-LOOP-----------------------------------
			public void update(Player player,GameStateManager gsm,Points points) {
				for(int i = 0;i < river.length;i++) {
					for(int j = 0;j < river[i].length;j++) {
						if(river[i][j] != null) {
							river[i][j].update();
						}
					}
				}
				this.verifyBounds();
				this.riverFlux(player,gsm,points);
				
			}
			public void draw(Graphics g) {
				for(int i = 0;i < river.length;i++) {
					for(int j = 0;j < river[i].length;j++) {
						if(river[i][j] != null) {
							river[i][j].draw(g);
						}
					}
				}
			}
		//TRANSIT-GENERATE----------------------------
		private void verifyBounds() {
			for(int i = 0;i < river.length;i++) {
				for(int j = 0;j < river[i].length;j++) {
					if(river[i][j] != null) {
						if((river[i][j].getPosX() > 688) && (i % 2) == 1) {
							river[i][j] = new Floatable(r.nextInt(2), dificulty, 4-i,-(r.nextInt(2)+ 2));
						}else if((river[i][j].getPosX() < (112 - (48 * river[i][j].getSize()))) && ((i % 2) == 0)) {
							river[i][j] = new Floatable(r.nextInt(2), dificulty, 4-i,-(r.nextInt(2) + 2));
						}
					}
				}
			}
		}
		//--------------------------------------------
		private void riverFlux(Player player,GameStateManager gsm,Points points) {
			if(player.getLine() < 11 && player.getLine() > 6) {
				if(!overFloatable(player)) {
					gsm.setState(new GameOverState(gsm,points));
				}
			}
		}
		
		private boolean overFloatable(Player player) {
			for (int i = 0; i < river.length; i++) {
				for (int j = 0; j < river[i].length; j++) {
					if(river[i][j].getBounds().intersects(player.getBounds())) {
						player.lockBoundsWith(river[i][j]);
						return true;
					}
				}
			}
			return false;
		}
			
}

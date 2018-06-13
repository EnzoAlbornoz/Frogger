package br.ufsc.enzo.frog.models;

import java.awt.Graphics;
import java.util.Random;

import br.ufsc.enzo.frog.states.GameOverState;
import br.ufsc.enzo.frog.states.GameStateManager;

public class Transit {
	//ATRIBUTES-----------------------------------
	private Vehicle[][] transit;
	private Random r;
	private int dificulty;
	//--------------------------------------------
	
	//CONSTRUCTOR---------------------------------
	public Transit(int dificulty) {
		this.dificulty = dificulty;
		transit = new Vehicle[4][3];
		r = new Random();
		init();
	}
	private void init(){
		transit[0][0] = new Vehicle(1,dificulty,4,0);
		transit[0][1] = new Vehicle(0,dificulty,4,4);
		transit[0][2] = new Vehicle(0,dificulty,4,8);
		
		transit[1][0] = new Vehicle(0,dificulty,3,0);
		transit[1][1] = new Vehicle(1,dificulty,3,4);
		transit[1][2] = new Vehicle(1,dificulty,3,8);
		
		transit[2][0] = new Vehicle(0,dificulty,2,1);
		transit[2][1] = new Vehicle(1,dificulty,2,5);
		transit[2][2] = new Vehicle(0,dificulty,2,9);
		
		transit[3][0] = new Vehicle(0,dificulty,1,3);
		transit[3][1] = new Vehicle(0,dificulty,1,7);
		transit[3][2] = new Vehicle(1,dificulty,1,11);
	}
	//--------------------------------------------
	
	//GAME-LOOP-----------------------------------
		public void update(Player player,GameStateManager gsm,Points points) {
			for(int i = 0;i < transit.length;i++) {
				for(int j = 0;j < transit[i].length;j++) {
					if(transit[i][j] != null) {
						transit[i][j].update();
					}
				}
			}
			this.verifyBounds();
			this.crash(player,gsm,points);
		}
		public void draw(Graphics g) {
			for(int i = 0;i < transit.length;i++) {
				for(int j = 0;j < transit[i].length;j++) {
					if(transit[i][j] != null) {
						transit[i][j].draw(g);
					}
				}
			}
		}
	//TRANSIT-GENERATE----------------------------
	private void verifyBounds() {
		for(int i = 0;i < transit.length;i++) {
			for(int j = 0;j < transit[i].length;j++) {
				if(transit[i][j] != null) {
					if((transit[i][j].getPosX() > 688) && (i % 2) == 1) {
						transit[i][j] = new Vehicle(r.nextInt(2), dificulty, 4-i,-(r.nextInt(2)+ 3));
					}else if((transit[i][j].getPosX() < (112 - (48 * transit[i][j].getSize()))) && ((i % 2) == 0)) {
						transit[i][j] = new Vehicle(r.nextInt(2), dificulty, 4-i,-(r.nextInt(2) + 3));
					}
				}
			}
		}
	}
	//--------------------------------------------
	
	//GETTERS-&&-SETTERS--------------------------
	public Vehicle[][] getVehicles(){
		return transit;
	}
	//--------------------------------------------
	
	//WIP-----------------------------------------
	private boolean colided(Player player,Vehicle v) {
		if(v != null) {
			if((player.getBounds()).intersects(v.getBounds())) {
				return true;
			}
		}
		return false;
	}
	
	private boolean collides(Player player) {
		for(int i = 0;i < transit.length;i++) {
			for(int j = 0;j < transit[i].length;j++) {
				if(colided(player,transit[i][j])) {
					return true;
				}
			}
		}
		return false;
	}
	
	public void crash(Player player,GameStateManager gsm,Points points) {
		if(this.collides(player)) {
			gsm.setState(new GameOverState(gsm, points));
		}
	}
}

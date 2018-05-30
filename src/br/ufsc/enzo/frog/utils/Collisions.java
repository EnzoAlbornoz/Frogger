package br.ufsc.enzo.frog.utils;

import java.awt.Rectangle;

import br.ufsc.enzo.frog.models.Player;
import br.ufsc.enzo.frog.models.Transit;
import br.ufsc.enzo.frog.models.Vehicle;
import br.ufsc.enzo.frog.states.GameStateManager;

public class Collisions {
	//MULTI-COLLIDER------------------------------
	public static boolean collides(Player player,Transit transit) {
		for(int i = 0;i < transit.getVehicles().length;i++) {
			for(int j = 0;j < transit.getVehicles()[i].length;j++) {
				if(colided(player,transit.getVehicles()[i][j])) {
					return true;
				}
			}
		}
		return false;
	}
	//SINGLE-COLLIDER-----------------------------
	public static boolean colided(Player player,Vehicle v) {
		if(v != null) {
			if((player.getBounds()).intersects(v.getBounds())) {
				return true;
			}
		}
		return false;
	}
	//--------------------------------------------
}

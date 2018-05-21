package br.ufsc.enzo.frog.utils;

import br.ufsc.enzo.frog.models.Player;
import br.ufsc.enzo.frog.models.Vehicle;
import br.ufsc.enzo.frog.states.GameStateManager;

public class Collisions {
	
	public static boolean hasCollided(Player player,Vehicle[][] vehicles) {
		int line = player.getLine();
		for(int i = 0;i < vehicles[line].length;i++) {
			if(vehicles[line][i].colides(player)) {
				return true;
			}
		}
		return false;
	}
	
}

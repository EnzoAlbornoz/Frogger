package br.ufsc.enzo.frog.utils;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import br.ufsc.enzo.frog.FrogGame;

public class LastGames {
	private static String[][] scoreList = {
			{"A","50"},
			{"Enzo","250"},
			{"",""},
			{"",""},
			{"",""},
	};
	
	public static void addScore(String name,int points) {
		if(name != null) {
			for(int i = scoreList.length-1;i > 0;i--) {
				scoreList[i] = scoreList[i-1];
			}
			scoreList[0][0] = name;
			scoreList[0][1] = ""+points;
		}
	}
	
	public static void show(Graphics g) {
			g.setFont(new Font("Lucida Console",Font.BOLD,25));
			g.setColor(Color.GREEN);
			g.drawString("Last 5 Games", 75,75);
			for(int i = 0;i < scoreList.length;i++) {
				g.drawString(scoreList[i][1], 75+125,(100+(25*i)));
				g.drawString(scoreList[i][0], 75,(100+(25*i)));
			}
	}
}

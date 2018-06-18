package br.ufsc.enzo.frog.utils;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import br.ufsc.enzo.frog.FrogGame;

public class LastGames {
	private static String[][] scoreList = {
			{"",""},
			{"",""},
			{"",""},
			{"",""},
			{"",""},
	};
	
	public static void addScore(String name,int points) {
		if(name != null) {
			for(int i = scoreList.length-1;i > 0;i--) {
				scoreList[i][0] = scoreList[i-1][0];
				scoreList[i][1] = scoreList[i-1][1];
			}
			scoreList[0][0] = name;
			scoreList[0][1] = ""+points;
		}
	}
	
	public static void show(Graphics g,int posX,int posY) {
			g.setColor(Color.BLACK);
			g.fillRect(posX, posY, 200, 200);
			g.setColor(Color.WHITE);
			g.drawRect(posX, posY, 200, 200);
			g.setFont(new Font("Lucida Console",Font.BOLD,25));
			g.setColor(Color.GREEN);
			g.drawString("Last 5 Games", posX+5,posY+25);
			for(int i = 0;i < scoreList.length;i++) {
				g.drawString(scoreList[i][1], posX+5+125,(posY+75+(30*i)));
				g.drawString(scoreList[i][0], posX+5,(posY+75+(30*i)));
			}
	}
}

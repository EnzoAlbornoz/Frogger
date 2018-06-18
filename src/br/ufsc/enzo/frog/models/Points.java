package br.ufsc.enzo.frog.models;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Points {
	//ATRIBUTES-----------------------------------
	private int points;
	private boolean firstMid;
	private int dificulty;
	//--------------------------------------------
	
	//CONSTRUCTOR---------------------------------
	public Points() {
		points = 0;
		firstMid = true;
	}
	//--------------------------------------------
	
	//GAME-LOOP-----------------------------------
	public void update(Player player){
		if(player.getLine() == 5 && firstMid) {
			firstMid = false;
			points += ((1 + dificulty) * 5);
		}
		if(player.getLine() == 11) {
			firstMid = true;
			points += ((1 + dificulty) * 15);
		}
	}
	public void draw(Graphics g) {
		g.setColor(Color.BLACK);
		g.setFont(new Font("Lucida Console",Font.PLAIN,24));
		g.drawString(""+points, 120, 24);
	}
	//--------------------------------------------
	
	//GETTERS-&&-SETTERS--------------------------
	public int getPoints() {
		return points;
	}
	
	public String getPointsString() {
		if(points < 10) {
			return "000"+points;
		}
		if(points < 100){
			return "00"+points;
		}
		if(points < 1000) {
			return "0" + points;
		}
		return ("" + points);
	}
	public void setDificulty(int dificulty) {
		this.dificulty = dificulty;
	}
	//--------------------------------------------
}

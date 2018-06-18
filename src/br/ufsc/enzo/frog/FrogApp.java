package br.ufsc.enzo.frog;

import java.awt.Component;
import java.awt.GraphicsEnvironment;
import java.awt.Point;

import javax.swing.JFrame;

public class FrogApp {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Frogger");
		FrogGame game = new FrogGame();
		frame.getContentPane().add(game);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setResizable(false);
		frame.setVisible(true);
	}
	
}

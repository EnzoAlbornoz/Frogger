package br.ufsc.enzo.frog;

import javax.swing.JFrame;

public class FrogApp {
	public static void main(String[] args) {
		FrogGame game = new FrogGame();
		JFrame frame = new JFrame();
		frame.getContentPane().add(game);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setResizable(false);
		frame.setVisible(true);
	}
}

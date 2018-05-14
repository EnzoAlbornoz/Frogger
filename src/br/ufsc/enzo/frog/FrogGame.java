package br.ufsc.enzo.frog;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

public class FrogGame extends JPanel implements Runnable,KeyListener{
	//ARRUMAR FPS
	private int FPS = 60;
	private long targetTime = 1000 / FPS;
	//DIMENÇÕES DO JOGO
	private static final int width  = 800;
	private static final int height = 600;
	//COISAS DE THREAD
	private Thread thread;
	private boolean isPaused = false;
	
	//CONSTRUTOR
	public FrogGame() {
		setBackground(Color.BLACK);
		setPreferredSize(new Dimension(width,height));
		setFocusable(true);
		requestFocus();
		addKeyListener(this);
		//OUTRAS COISAS PARA INICIALIZAR
	}
	//AVISA QUE O PANEL FOI INICIALIZADO
	public void addNotify() {
		super.addNotify();
		startGame();
	}
	//INICALIZAÇÃO DO THREAD
	private void startGame() {
		if(thread == null) {
			thread = new Thread(this);
			thread.start();
		}
		
	}
	//LAÇO PRINCIPAL DO GAME
	public void run() {
		/* VAI INICIALIZAR ALGUMAS VARIAVEIS/OBJETOS */
		//-------
		/* DEFINIÇÃO DE VARIAVEL PARA CRIAR FPS
		   COMO FUNCIONA:
		   PEGAMOS UM TEMPO INICIAL E FAZEMOS O GAME-LOOP			
		   ENT�O MANDAMOS O THREAD 'DORMIR' PELO TEMPO
		   CALCULADO,ASSIM GERAMOS O PR�XIMO FRAME S� 
		   DEPOIS DE +- 16ms.
		   LOGO: wait = Frame[k+1] - Frame[k]
		   (wait = delta of frames)	 				*/
		long start;
		long elapsed;
		long wait;
		
		//GAME-LOOP
		while(!isPaused) {
			start = System.nanoTime();
			
			/*UPDATE DA TELA*/
			gameUpdate();
			repaint();
			/*FIM DO UPTADE*/			
			elapsed = System.nanoTime() - start;
			wait = targetTime - (elapsed / 1000000);
			
			try {
				thread.sleep(wait);
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	private synchronized void gameUpdate() {
		if (!isPaused) {
			
		}
	}
	
	protected synchronized void paintComponent(Graphics g) {
		super.paintComponent(g);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}

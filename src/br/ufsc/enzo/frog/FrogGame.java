package br.ufsc.enzo.frog;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

import br.ufsc.enzo.frog.states.GameStateManager;

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
	//GAME STATE MANAGER
	private GameStateManager gsm;
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
		   ENTÃO MANDAMOS O THREAD 'DORMIR' PELO TEMPO
		   CALCULADO,ASSIM GERAMOS O PRÓXIMO FRAME SÓ 
		   DEPOIS DE +- 16ms.
		   LOGO: wait = Frame[k+1] - Frame[k]
		   (wait = delta of frames)	 				*/
		long start;
		long elapsed;
		long wait;
		
		//INSTANCIA O GERNECIADOR DE ESTADOS
		gsm = new GameStateManager();
		
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
			gsm.update();								//Update state variables
		}
	}
	
	protected synchronized void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.clearRect(0, 0, width, height);
		gsm.draw((Graphics2D) g);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void keyPressed(KeyEvent e) {
		gsm.keyPressed(e.getKeyCode());
	}
	
	public void keyReleased(KeyEvent e) {
		gsm.keyReleased(e.getKeyCode());
	}
	
	@Override
	public void keyTyped(KeyEvent e) {}

	
}

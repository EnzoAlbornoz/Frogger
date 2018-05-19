package br.ufsc.enzo.frog.gfx;

import java.awt.image.BufferedImage;

public class Animation {
	
	private int speed;	
	private int index;
	private long lastTime;
	private long timer = 0;
	
	
	private BufferedImage[] frames;
	
	public Animation(int speed,BufferedImage[] imgs) {
		this.speed  = speed;
		this.frames = imgs;
		index = 0;
		lastTime = System.currentTimeMillis();
	}
	
	public void update() {
		timer += System.currentTimeMillis() - lastTime;
		lastTime = System.currentTimeMillis();
		
		if(timer > speed) {
			index++;
			timer = 0;
			if(index >= frames.length) {
				index = 0;
			}
		}
	}
	
	public BufferedImage getCurrentFrame() {
		return frames[index];
	}
	
	public void runAnimation() {
		
	}
}

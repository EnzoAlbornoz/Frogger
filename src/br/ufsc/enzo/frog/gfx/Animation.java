package br.ufsc.enzo.frog.gfx;

import java.awt.image.BufferedImage;

public class Animation {
	
	private int speed;	
	private int index;
	private int ending;
	
	private long lastTime;
	private long timer = 0;
	//FRAME-VECTOR--------------------------------
	private BufferedImage[] frames;
	//--------------------------------------------
	//CONSTRUCTOR---------------------------------
	public Animation(int speed,BufferedImage[] imgs) {
		this.speed  = speed;
		this.frames = imgs;
		index = 0;
		lastTime = System.currentTimeMillis();
		ending = frames.length;
	}
	//--------------------------------------------
	
	
	//METHODS-------------------------------------
	public BufferedImage getThisImage(int i) {
		return frames[i];
	}
	
	public BufferedImage getCurrentFrame() {
		return frames[index];
	}
	
	public void setCurrentFrame(int frame) {
		index = frame;
	}
	//--------------------------------------------
	
	
	
	
	
	
	//NON-USING-----------------------------------
	public void update() {
		timer += System.currentTimeMillis() - lastTime;
		lastTime = System.currentTimeMillis();
		
		if(timer > speed) {
			index++;
			timer = 0;
			if(index >= ending) {
				index = 0;
			}
		}
	}
	/*OLD-----------------------------------------
	
	
	public void runAnimation(int init,int end) {
		index = init;
		ending = end;
		if(index >= end) {
			index = init;
		}
	}
	
	public void runAnimation(int init, int end, boolean wasAnimated, boolean loop) {
		if(!wasAnimated) {
			index = init;
			ending = end;
			if(index >= end) {
				if(loop) {
					index = end;
				}else {
					index = init;				
				}
			}
		}
	}
	*/
}

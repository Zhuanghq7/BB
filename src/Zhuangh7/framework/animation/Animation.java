package Zhuangh7.framework.animation;

import java.awt.Graphics;

public class Animation {
	private Frame[] frames;
	private double[] frameEndTimes;
	private int currentFrameIndex = 0;
	
	private double totalDuration = 0;
	private double currentTime = 0;
	private boolean isStatic = false;
	
	public Animation(Frame...frames ){
		this.frames = frames;
		frameEndTimes = new double[frames.length];
		
		for(int i = 0 ;i<frames.length;i++){
			Frame f = frames[i];
			totalDuration += f.getDuration();
			if(f.getDuration() == -1)
			{
				isStatic = true;
				break;
			}
			frameEndTimes[i] = totalDuration;
		}
	}
	
	public synchronized void update(float increment){
		if(!isStatic){
		currentTime += increment;
		
		if(currentTime > totalDuration){
			wrapAnimation();//ÖØÀ´ÁË°¡= =
		}
		
		while(currentTime > frameEndTimes[currentFrameIndex]){
			currentFrameIndex++;
		}
		}
	}
	
	private synchronized void wrapAnimation(){
		currentFrameIndex = 0;
		currentTime %= totalDuration;
	}
	
	public synchronized void render(Graphics g,int x,int y){
		g.drawImage(frames[currentFrameIndex].getImage(), x, y, null);
	}
	
	public synchronized void render(Graphics g,int x,int y, int width, int height){
		g.drawImage(frames[currentFrameIndex].getImage(), x, y, width,height,null);
	}

}

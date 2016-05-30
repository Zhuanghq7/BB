package Zhuangh7.framework.animation;

import java.awt.Graphics;
import java.awt.Rectangle;

import Zhuangh7.game.main.GameMain;

public class Thing extends Animation{
	private int x,y,width,height,velX,velY;
	private Rectangle rect;
	Thing(int x,int y){
		this.x = x;
		this.y = y;
		velX = 0;
		velY = 0;
		
	}
	private boolean move(int velX,int velY){
		if(this.y>=GameMain.GAME_HEIGHT*0.85)
			return false;
		this.velX = velX;
		this.velY = velY;
		
		return true;
	}
	
	public void update(float n){
		
	}
	
	public synchronized void render(Graphics g,int x,int y){
		super.render(g, x, y);
	}
	
	public synchronized void render(Graphics g,int x,int y,int width,int height){
		super.render(g, x, y, width, height);
	}
}

package Zhuangh7.framework.animation;

import java.awt.Graphics;
import java.awt.Rectangle;

import Zhuangh7.game.main.GameMain;

public class Thing extends Animation{
	protected double x;
	protected double y;
	protected int width;
	protected int height;
	protected double velX;
	protected double velY;
	protected Rectangle rect;
	Thing(int x,int y,int width,int height,Frame...frames ){
		super(frames);
		this.x = x;
		this.y = y;
		velX = 0;
		velY = 0;
		this.width = width;
		this.height =height;
		rect = new Rectangle();
		rect.x = x-width/2;
		rect.y = y-height/2;
		rect.height = height;
		rect.width = width;
		
	}
	public int getWidth(){
		return width;
	}
	public int getHeight(){
		return height;
	}
	public int getX()
	{
		return (int)x;
	}
	public int getY(){
		return (int)y;
	}
	public boolean move(double velX,double velY){
		/*if(this.y>=GameMain.GAME_HEIGHT*0.85)
			return false;*/
		this.velX = velX;
		this.velY = velY;
		
		return true;
	}
	public boolean stop(){
		velX = 0;
		velY = 0;
		return true;
	}
	
	public void update(float n){
		x+=velX;
		y+=velY;
		updateRect();
	}

	protected void updateRect(){
		rect.x = (int)(this.x-width/2);
		rect.y = (int)(this.y-height/2);
	}
	public synchronized void render(Graphics g,int x,int y){
		super.render(g, x, y);
	}
	
	public synchronized void render(Graphics g,int x,int y,int width,int height){
		super.render(g, x, y, width, height);
	}
	public boolean setX(int x){
		this.x = x;
		return true;
	}
	public boolean setY(int y){
		this.y = y;
		return true;
	}
	public Rectangle getRect(){
		return rect;
	}
}

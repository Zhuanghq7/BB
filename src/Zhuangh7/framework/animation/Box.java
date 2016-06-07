package Zhuangh7.framework.animation;

import java.awt.Rectangle;

public class Box extends Thing{
	private int type;
	private Rectangle r1,r2,r3,r4;
	

	public Box(int type,int x, int y, int width, int height, Frame... frames) {
		super(x, y, width, height, frames);
		// TODO Auto-generated constructor stub
		updateRect();
		switch(type){
		case 0:
			r1 = new Rectangle(rect.x+rect.width,rect.y,1,1);
			r2 = new Rectangle(rect.x+rect.width,rect.y+rect.width,1,1);
			r3 = new Rectangle(rect.x,rect.y+rect.width,1,1);
			r4 = new Rectangle(rect.x,rect.y,1,1);
			break;
		case 1:
			r1 = null;
			r2 = new Rectangle(x+width/2,y+height/2,1,1);
			r3 = new Rectangle(x-width/2,y+height/2,1,1);
			r4 = new Rectangle(x-width/2,y-height/2,1,1);
			break;
		case 2:
			r1 = new Rectangle(x+width/2,y-height/2,1,1);
			r2 = null;
			r3 = new Rectangle(x-width/2,y+height/2,1,1);
			r4 = new Rectangle(x-width/2,y-height/2,1,1);
			break;
		case 3:
			r1 = new Rectangle(x+width/2,y-height/2,1,1);
			r2 = new Rectangle(x+width/2,y+height/2,1,1);
			r3 = null;
			r4 = new Rectangle(x-width/2,y-height/2,1,1);
			break;
		case 4:
			r1 = new Rectangle(x+width/2,y-height/2,1,1);
			r2 = new Rectangle(x+width/2,y+height/2,1,1);
			r3 = new Rectangle(x-width/2,y+height/2,1,1);
			r4 = null;
			break;
		}
		
	}
	
	public Rectangle getRect(){
		return rect;
	}
	public Rectangle getR1(){
		return r1;
	}
	public Rectangle getR2(){
		return r2;
	}
	public Rectangle getR3(){
		return r3;
	}
	public Rectangle getR4(){
		return r4;
	}
	@Override
	public void update(float n){
		x+=velX;
		y+=velY;
		updateRect();
	}
	@Override
	protected void updateRect(){
		rect.x = (int)(this.x-width/2);
		rect.y = (int)(this.y-height/2);
		rect.width = this.width;
		rect.height = this.width;
	}
	
}

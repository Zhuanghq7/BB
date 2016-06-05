package Zhuangh7.framework.animation;
import Zhuangh7.framework.animation.Frame;
import Zhuangh7.game.main.GameMain;
import Zhuangh7.game.state.PlayState;
public class Ball extends Thing{
	
	private int num;
	
	public void setNum(int num){
		this.num = num;
	}
	
	public void printNum(){
		System.out.println(""+num);
	}
	public Ball(int x, int y,int width,int height,Frame...frames) {
		super(x, y, width, height,frames);
		// TODO Auto-generated constructor stub
	}
	public Ball(int x, int y,int width,int height,Frame frames) {
		super(x, y, width, height,frames);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void update(float n){
		x+=velX;
		y+=velY;
		//System.out.println(""+width);
		if(this.y>PlayState.bottom+5)
		{
			ready();	
		}
		
		int i =collide();
		if(i!=-1){
			IScollide(i);
		}
		super.updateRect();
	}
	
	private synchronized void ready(){
		this.stop();
		
		PlayState.mutexAdd = 0;
		PlayState.mutexUpdate = 0;
		PlayState.mutexRender =0;
		PlayState.B.remove(this);
		PlayState.removeTag = true;
		PlayState.mutexAdd =1;
		PlayState.mutexRender = 1;
		PlayState.mutexUpdate =1;
	
	//PlayState.B.remove(this);
		PlayState.static_B.add(this);
	
		if(PlayState.firstBall){
			PlayState.setBeginX((int)x);
			System.out.println("set new begin");
		}
	
		this.x = PlayState.getBeginX();
		this.y = PlayState.getBeginY();
		PlayState.firstBall = false;
	}
	
	private int collide(){
		if((x-(int)(width*0.5))<=0)
		{
			x = 0+(int)(width*0.5)+1;
			return 1;
		}
		else if((x+(int)(width*0.5))>=GameMain.GAME_WIDTH)
		{
			x = GameMain.GAME_WIDTH-(int)(0.5*width)-1;
			return 1;
		}
		else if((y-(int)(height*0.5))<=PlayState.top)
		{
			y = PlayState.top+(int)(height*0.5)+1;
			return 2;
		}
		for(Box b:PlayState.Boxx){
			if(rect.intersects(b.getRect())){
				if(rect.intersects(b.getR1())&&(x>b.getR1().getX())&&(y<b.getR1().getY())){
					System.out.println("r1");
					return 4;
				}
				else if(rect.intersects(b.getR2())&&(x>b.getR2().getX())&&(y>b.getR2().getY())){
					System.out.println("r2");
					return 5;					
				}
				else if(rect.intersects(b.getR3())&&(x<b.getR3().getX())&&(y>b.getR3().getY())){
					System.out.println("r3");
					return 6;
				}
				else if(rect.intersects(b.getR4())&&(x<b.getR4().getX())&&(y<b.getR4().getY())){
					System.out.println("r4");
					return 7;
				}
				else if(x>b.getX()){
					if(y<b.getR2().getY()&&y>b.getR1().getY()){
						x = b.getX()+b.getWidth()/2+width/2;
						return 1;
					}
				}
				else if(x<b.getX()){
					if(y<b.getR2().getY()&&y>b.getR1().getY()){
						x = b.getX()-b.getWidth()/2-width/2;
						return 1;
					}
				}
				else if(y>b.getY()||y<b.getY()){
					if(x>b.getR3().getX()&&x<b.getR2().getX()){
						return 9;
					}
				}
				//System.out.println("normal");
			}
		}
		return -1;
	}
	private void IScollide(int i){
		if(i==1){
			velX=-velX;
		}
		else if(i==2){
			velY=-velY;
		}
		else if(i==4){
			
		}
		else if(i==5){
			
		}
		else if(i==6){
			
		}
		else if(i==7){
			
		}
		else if(i==8){
			velX = -velX;
		}
		else if(i==9){
			velY = -velY;
		}
	}
}

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
	public void update(float n){
		x+=velX;
		y+=velY;
		synchronized(this){
		if(this.y>GameMain.GAME_HEIGHT*0.85+5)
		{
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
				PlayState.setBeginX(x);
				System.out.println("set new begin");
			}
			
			this.x = PlayState.getBeginX();
			this.y = PlayState.getBeginY();
			PlayState.firstBall = false;
		}
		}
		int i =collide();
		if(i!=-1){
			IScollide(i);
		}
		super.updateRect();
	}
	private int collide(){
		if((x+velX)<=0||(x+velX)>=GameMain.GAME_WIDTH-width)
		{
			return 1;
		}
		else if((y+velY)<=0||(y+velY)>=GameMain.GAME_HEIGHT-height)
		{
			return 2;
		}
		return -1;
	}
	private void IScollide(int i){
		if(i==1){
			velX=-velX;
		}
		else{
			velY=-velY;
		}
	}
}

package Zhuangh7.game.state;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import Zhuangh7.framework.animation.Ball;
import Zhuangh7.framework.util.RandomNumberGenerator;
import Zhuangh7.game.main.GameMain;
import Zhuangh7.game.main.Resources;
import Zhuangh7.framework.animation.Frame;

public class PlayState extends State{
	
	public  static int mutexUpdate = 1;
	public  static int mutexRender = 1;
	public  static int mutexAdd = 1;
	public static int mutexRemove = 1;
	private  static int maxBallNum;
	private  static int leftBallNum;
	private static boolean haveBall = false;
	private static int Begin_X;
	private static int Begin_Y;
	private static int V = 10; 
	private static int VX = 0;
	private static int VY = 0;
	public static boolean firstBall = true; 
	public static ArrayList<Ball> B = new ArrayList<Ball>();
	public static ArrayList<Ball> static_B = new ArrayList<Ball>();
	static Ball B1;
	private static boolean go = false;
	private static int BallWidth = 15; 
	private static float Time=0;
	private static float TimeWindow = 3;
	public static boolean removeTag = false;
	
	public static int getBeginX(){
		return Begin_X;
	}
	public static void setBeginX(int x){
		Begin_X = x;
	}
	
	public static void setBeginY(int y){
		Begin_Y = y;
	}
	public static int getBeginY(){
		return Begin_Y;
	}
	@Override
	public void init(){
		System.out.println("Entered PlayState");
		/*if(!B1.move(RandomNumberGenerator.getRandIntBetween(1,10), RandomNumberGenerator.getRandIntBetween(1, 10))){
			System.out.println("setVel failed");
		}*/
		
		maxBallNum = 0;
		leftBallNum = 0;
		leftBallNum = maxBallNum;
		Begin_X = (int)(GameMain.GAME_WIDTH*0.5);
		Begin_Y = (int)(GameMain.GAME_HEIGHT*0.85);
		//addBall();
		haveBall = true;
	}
	
	@Override
	public void update(float delta){
		//B1.update(delta);
		if(mutexRender == 1){
			mutexUpdate =0;
			mutexAdd = 0;
			mutexRemove = 0;
			/*for(Ball b:B){
				b.update(delta);
			}*/
			int I = B.size();
			for(int i = 0;i<I;i++){
				Ball b = B.get(i);
				b.update(delta);
				if(removeTag){
					I = B.size();
					i--;
					removeTag = false;
				}
			}
			mutexAdd = 1;
			mutexUpdate =1;
			mutexRemove = 1;
		}
		
		Time++;
		//System.out.println(""+Time+","+TimeWindow);
		
		
		if(go==true&&Time>TimeWindow){
			Time-=TimeWindow;
			if(!static_B.isEmpty()){
				while(mutexAdd!=1){
					
				}
				mutexUpdate = 0;
				mutexRemove = 0;
				mutexRender = 0;
				
				B.add(static_B.get(0));
				static_B.get(0).move(VX, VY);
			//	System.out.println("one ball to move");
				static_B.remove(0);
			//	System.out.println("delete ");
				
				mutexRender = 1;
				mutexRemove = 1;
				mutexUpdate = 1;
			//	System.out.print("shoot one ball");
				leftBallNum--;
				}
			
			if(B.isEmpty()||leftBallNum<=0){
			//	System.out.println("shoot complete");
				go = false;
				firstBall = true;
			}
			
		}
	}
	
	@Override
	public void render(Graphics g){
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, GameMain.GAME_WIDTH,GameMain.GAME_HEIGHT);
		g.setColor(Color.WHITE);
		g.fillRect(0,(int)(GameMain.GAME_HEIGHT*0.85),GameMain.GAME_WIDTH,2);
		if(haveBall){
			g.drawImage(Resources.BB_dan,Begin_X-BallWidth/2, Begin_Y-BallWidth/2, BallWidth,BallWidth,null);
		}
	//	B1.render(g, B1.getX(), B1.getY(),B1.getWidth(),B1.getHeight());
		if(mutexUpdate == 1){
			mutexRender =0;
			mutexAdd = 0;
			mutexRemove = 0;
			for(Ball b:B){
				b.render(g, (int)(b.getX()-BallWidth*0.5),(int)( b.getY()-BallWidth*0.5),BallWidth,BallWidth);
			}
			mutexRemove = 1;
			mutexAdd = 1;
			mutexRender =1;
		}
		
		g.setColor(Color.red);
		g.drawString(""+maxBallNum, 10, 10);
		g.drawString(""+leftBallNum+","+static_B.size() , 10, 30);
		g.drawString(""+B.size(), 10, 50);
		g.drawString(""+VY, 10, 70);
	}
	
	@Override 
	public void onClick(MouseEvent e){
		if(e.getY()<GameMain.GAME_HEIGHT*0.84){
		addBall();
		int Dx = Math.abs(e.getX()-Begin_X);
		int Dy = Math.abs(e.getY()-Begin_Y);
		double z = Math.sqrt(Dx*Dx+Dy*Dy);
		VX = (int)((V/z)*Dx);
		VY = (int)((V/z)*Dy);
	//	System.out.println(""+Dx+","+Dy);
		VY = -VY;
		if(e.getX()<=Begin_X){
			VX = -VX;
		}
		Time = 0;
		leftBallNum = static_B.size();
		go = true;
		System.out.println("go");
	//	Bn.move(RandomNumberGenerator.getRandIntBetween(1,10), RandomNumberGenerator.getRandIntBetween(1,10));
	}}
	
	@Override 
	public void onKeyPress(KeyEvent e){
		for(Ball b:B){
			b.printNum();
		}
	}
	
	@Override 
	public void onKeyRelease(KeyEvent e){
		
	}
	
	public void addBall(){
		maxBallNum++;
		Ball Bn = new Ball(Begin_X,Begin_Y,15,15,Resources.BB_dann);
		Bn.setNum(maxBallNum);
		static_B.add(Bn);
		//System.out.println("add one ball");
	}
}

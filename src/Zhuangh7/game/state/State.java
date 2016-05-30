package Zhuangh7.game.state;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import Zhuangh7.game.main.GameMain;

public abstract class State {
	
	public void init(){
		
	}
	
	public void update(float delta){
		
	}
	
	public void render(Graphics g){
		
	}
	
	public void onClick(MouseEvent e){
		
	}
	
	public void onKeyPress(KeyEvent e){
		
	}
	
	public void onKeyRelease(KeyEvent e){
		
	}
	
	public void setCurrentState(State newState){
		GameMain.sGame.setCurrentState(newState);
	}
}

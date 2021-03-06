package Zhuangh7.game.state;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import Zhuangh7.game.main.Resources;

public class MenuState extends State{
	
	@Override
	public void init(){
		System.out.println("Entered MenuState");
	}
	
	@Override
	public void update(float delta){
		
	}
	
	@Override
	public void render(Graphics g){
		g.drawImage(Resources.welcome, 0, 0, null);
	}
	
	@Override 
	public void onClick(MouseEvent e){
		setCurrentState(new PlayState());
	}
	
	@Override 
	public void onKeyPress(KeyEvent e){
		
	}
	
	@Override 
	public void onKeyRelease(KeyEvent e){
		
	}
}

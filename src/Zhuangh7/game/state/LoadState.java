package Zhuangh7.game.state;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import Zhuangh7.game.main.Resources;

public class LoadState extends State{
	
	@Override 
	public void init(){
		System.out.println("begin load");
		Resources.load();
		System.out.println("Loaded Successfully");
	}
	
	@Override
	public void update(float delta){
		setCurrentState(new MenuState());
	}
	
	@Override
	public void render(Graphics g){
		
	}
	
	@Override
	public void onClick(MouseEvent e){
		
	}
	
	@Override
	public void onKeyPress(KeyEvent e){
		
	}
	
	@Override
	public void onKeyRelease(KeyEvent e){
		
	}
}

package Zhuangh7.game.main;

import javax.swing.JFrame;
import Zhuangh7.game.main.Game;

public class GameMain {
	private static final String GAME_TITLE = "Ellio";
	public static final int GAME_WIDTH = 400;
	public static final int GAME_HEIGHT = 700;
	public static Game sGame;
	
	public static void main(String[] args){
		JFrame BB = new JFrame(GAME_TITLE);
		BB.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		BB.setResizable(false);
		BB.setVisible(true);
		sGame = new Game(GAME_WIDTH,GAME_HEIGHT);
		BB.add(sGame);
		BB.pack();
		
		BB.setVisible(true);
		sGame.requestFocus();
		//Ellio.setIconImage(Resources.iconimage);
	}
}

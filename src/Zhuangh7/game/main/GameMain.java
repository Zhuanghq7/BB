package Zhuangh7.game.main;

import javax.swing.JFrame;
import Zhuangh7.game.main.Game;

public class GameMain {
	private static final String GAME_TITLE = "Ellio";
	public static final int GAME_WIDTH = 500;
	public static final int GAME_HEIGHT = 800;
	public static Game sGame;
	
	public static void main(String[] args){
		JFrame Ellio = new JFrame(GAME_TITLE);
		Ellio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Ellio.setResizable(false);
		Ellio.setVisible(true);
		sGame = new Game(GAME_WIDTH,GAME_HEIGHT);
		Ellio.add(sGame);
		Ellio.pack();
		
		Ellio.setVisible(true);
		sGame.requestFocus();
		//Ellio.setIconImage(Resources.iconimage);
	}
}

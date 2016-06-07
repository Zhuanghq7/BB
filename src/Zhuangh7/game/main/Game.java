package Zhuangh7.game.main;


import java.awt.Image;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

import Zhuangh7.game.state.LoadState;
import Zhuangh7.game.state.State;
import Zhuangh7.framework.util.InputHandler;

@SuppressWarnings("serial")

public class Game extends JPanel implements Runnable {
	
	private int gameWidth;
	private int gameHeight;
	private Image gameImage;
	
	public volatile int tag;
	
	private Thread gameThread;
	private volatile boolean running;
	private volatile State currentState;
	private InputHandler inputHandler;
	
	public Game(int gameWidth,int gameHeight){
		this.gameWidth = gameWidth;
		this.gameHeight = gameHeight;
		setPreferredSize(new Dimension(gameWidth,gameHeight));
		setBackground(Color.BLACK);
		setFocusable(true);
		requestFocus();
		
		tag = 0;
	}
	@Override
	public void run() {
		long updateDurationMillis = 0;
		long sleepDurationMillis = 0;
		
		while(running){
			long beforeUpdateRender = System.nanoTime();
			long deltaMillis = updateDurationMillis + sleepDurationMillis;
			
			updateAndRender(deltaMillis);
			
			updateDurationMillis = (System.nanoTime()-beforeUpdateRender)/1000000L;
			/*sleepDurationMillis = Math.max(2, 17-updateDurationMillis);
			try{
				Thread.sleep(sleepDurationMillis);
				
			}catch(InterruptedException e){
				e.printStackTrace();
			}*/
		}
		System.exit(0);
		// TODO Auto-generated method stub
		
	}
	private void updateAndRender(long deltaMillis) {
		while(currentState == null){
			System.out.println("waiting for currentState");
		}
		currentState.update(deltaMillis/1000f);
		prepareGameImage();
		currentState.render(gameImage.getGraphics());
		renderGameImage(getGraphics());
	}
	
	private void prepareGameImage(){
		if(gameImage == null){
			gameImage = createImage(gameWidth,gameHeight);
		}
		Graphics g = gameImage.getGraphics();
		g.clearRect(0, 0, gameWidth, gameHeight);
	}
 	
	@Override
	public void addNotify(){
		super.addNotify();
		initInput();
		System.out.println("InitInput");
		setCurrentState(new LoadState());
		initGame();
	}
	
	private void initInput(){
		inputHandler = new InputHandler();
		addKeyListener(inputHandler);
		addMouseListener(inputHandler);
	}
	
	private void initGame(){
		running = true;
		gameThread = new Thread(this,"Game Thread");
		gameThread.start();
	}
	
	public void exit(){
		running = false;
	}
	
	
	private void renderGameImage(Graphics g){
		if(gameImage != null){
			g.drawImage(gameImage, 0, 0, null);
		}
		g.dispose();
	}
	
	public void setCurrentState(State newState){
		System.gc();
		tag = 0;
		currentState = newState;
		newState.init();
		tag = 1;
		inputHandler.setCurrentState(currentState);
	}
}

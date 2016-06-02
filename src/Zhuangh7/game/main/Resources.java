package Zhuangh7.game.main;

import java.applet.Applet;
import java.applet.AudioClip;
import Zhuangh7.framework.animation.Frame;
import java.awt.image.BufferedImage;
import java.net.URL;

import javax.imageio.ImageIO;

public class Resources {
	
	public static BufferedImage welcome,iconimage,BB_dan;
	public static Frame BB_dann;
	
	public static void load(){
		welcome = loadImage("BB_Welcome.jpg");
		//iconimage = loadImage("iconimage.png");
		BB_dan = loadImage("BB_dan.png");
		BB_dann = new Frame(BB_dan);
	}
	
	private static AudioClip loadSound(String filname){
		URL fileURL = Resources.class.getResource("/resources/"+filname);
		return Applet.newAudioClip(fileURL);
	}
	
	private static BufferedImage loadImage(String filename){
		BufferedImage img = null;
		try{
			img = ImageIO.read(Resources.class.getResourceAsStream("/resources/"+filename));
		}
		catch(Exception e){
			System.out.println("Error while reading : "+filename);
			e.printStackTrace();
		}
		return img;
	}
}

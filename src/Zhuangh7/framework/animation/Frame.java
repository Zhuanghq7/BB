package Zhuangh7.framework.animation;

import java.awt.Image;

public class Frame {
	private Image image;
	private double duration;
	
	public Frame(Image image,double duration){
		this.image = image;
		this.duration = duration;
	}
	public Frame(Image image){
		this.image = image;
		this.duration = -1;
	}
	
	public double getDuration(){
		return duration;
	}
	
	public Image getImage(){
		return image;
	}

}

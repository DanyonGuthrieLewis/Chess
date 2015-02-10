package primary;

import greenfoot.GreenfootImage;

import java.awt.Color;

public class SpaceBoarder extends Space {
	public SpaceBoarder(){
		GreenfootImage image = new GreenfootImage(50,50);
		image.setColor(Color.blue);
		image.fill();
		setImage(image);
	}
	public void act(){
		occupied = true;
	}
}

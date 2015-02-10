package primary;

import java.awt.Color;

import greenfoot.GreenfootImage;

public class SpaceBlack extends Space {
	public SpaceBlack(){
		GreenfootImage image = new GreenfootImage(50,50);
		image.setColor(Color.gray);
		image.fill();
		setImage(image);
	}
}

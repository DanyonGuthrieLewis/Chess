package primary;

import java.awt.Color;

import greenfoot.GreenfootImage;

public class SpaceWhite extends Space {
	public SpaceWhite(){
		GreenfootImage image = new GreenfootImage(50,50);
		image.setColor(Color.white);
		image.fill();
		setImage(image);
	}
}

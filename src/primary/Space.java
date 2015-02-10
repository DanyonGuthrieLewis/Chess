package primary;

import java.util.ArrayList;

import greenfoot.Actor;

public abstract class Space extends Actor {
	public boolean occupied = false;
	public Piece piece = null;
	public void act(){
		Actor p = getOneIntersectingObject(Piece.class);
		if(p != null){
			piece = (Piece) p;
			occupied = true;
		}
		else{
			piece = null;
			occupied = false;
		}
	}
}

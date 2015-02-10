package primary;

import java.awt.Color;
import java.util.List;

import greenfoot.Actor;
import greenfoot.Greenfoot;

public class SpacePossible extends Space {
	public void act(){
		if (Greenfoot.mouseClicked(this)){
			Piece taken = null;
			List<Space> spaceCheck = getWorld().getObjectsAt(getX(), getY(), Space.class);
			for (Space sc : spaceCheck){
				if (sc.occupied && sc.piece != null){
					taken = sc.piece;
					getWorld().removeObject(sc.piece);
				}
			}
			String oldSpace ="(" + Board.getSelected().getX() + ", " + Board.getSelected().getY() + ")";
			Board.getSelected().setLocation(getX(), getY());
			Board.getSelected().setHasMoved(true);
			if (taken != null){
				Board.addMove(Board.getSelected().toString() + " moved from " + oldSpace + " and took " + taken.toString() + " at (" + getX() + ", " + getY() + ")");
			}
			else {
				Board.addMove(Board.getSelected().toString() + " moved from " + oldSpace + " to (" + getX() + ", " + getY() + ")");
			}
			Board.setSelected(null);
			List<Actor> toRemove = getWorld().getObjects(SpacePossible.class);
			for (Actor a : toRemove){
				a.getWorld().removeObject(a);
			}
		}
	}
}

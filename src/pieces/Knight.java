package pieces;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import enums.PIECE;
import enums.TEAM;
import greenfoot.Actor;
import greenfoot.Greenfoot;
import primary.Board;
import primary.Piece;
import primary.Space;
import primary.SpacePossible;

public class Knight extends Piece {

	public Knight(TEAM t) {
		super(t);
		if (t == TEAM.BLACK){
			setImage("Chess/BlackKnight.png");
		}
		else{
			setImage("Chess/WhiteKnight.png");
		}
		stepX = 1;
		stepY = 2;
		stepNum = 1;
		stepDiagnal = true;
		stepHorizantal = false;
		stepVertical = false;
		type = PIECE.KNIGHT;
	}
	@Override
	public void act(){
		if (Greenfoot.mouseClicked(this)){
			if (Board.getSelected() == null || (ID != Board.getSelected().getID())){
				Board.setSelected(this);
				getImage().setColor(Color.green);
				getImage().drawRect(0, 0, getImage().getWidth() - 1, getImage().getHeight() - 1);
				
				spawnPossible(stepX, stepY);
				spawnPossible(-stepX, stepY);
				spawnPossible(stepX, -stepY);
				spawnPossible(-stepX, -stepY);
				spawnPossible(stepY, stepX);
				spawnPossible(-stepY, stepX);
				spawnPossible(stepY, -stepX);
				spawnPossible(-stepY, -stepX);
			}
			else{
				Board.setSelected(null);
				List<Actor> toRemove = getWorld().getObjects(SpacePossible.class);
				for (Actor a : toRemove){
					a.getWorld().removeObject(a);
				}
			}
		}
		if (Board.getSelected() == null || ID != Board.getSelected().getID()){
			getImage().setColor(Color.white);
			getImage().drawRect(0, 0, getImage().getWidth() - 1, getImage().getHeight() - 1);
		}
	}
}

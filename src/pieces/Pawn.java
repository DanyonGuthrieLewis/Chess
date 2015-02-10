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

public class Pawn extends Piece{
	public Pawn(TEAM t) {
		super(t);
		if (t == TEAM.BLACK){
			setImage("Chess/BlackPawn.png");
		}
		else{
			setImage("Chess/WhitePawn.png");
		}
		stepX = 1;
		stepY = 1;
		stepNum = 1;
		stepDiagnal = true;
		stepHorizantal = false;
		stepVertical = true;
		type = PIECE.PAWN;
	}
	@Override
	public void act(){
		if (Greenfoot.mouseClicked(this)){
			if (Board.getSelected() == null || (ID != Board.getSelected().getID())){
				Board.setSelected(this);
				getImage().setColor(Color.green);
				getImage().drawRect(0, 0, getImage().getWidth() - 1, getImage().getHeight() - 1);
				if (hasMoved){
					if (stepDiagnal){
						if(team == TEAM.BLACK){
							spawnPossible(stepX, stepY);
							spawnPossible(-stepX, stepY);
						}
						else {
							spawnPossible(stepX, -stepY);
							spawnPossible(-stepX, -stepY);
						}
					}
					if (stepVertical){
						if (team == TEAM.BLACK){
							spawnPossible(0, stepX);
						}
						else{
							spawnPossible(0, -stepY);
						}
					}
				}
				else {
					if (team == TEAM.BLACK){
						spawnPossible(0, stepY);
						spawnPossible(0, stepY*2);
						spawnPossible(stepX, stepY);
						spawnPossible(-stepX, stepY);
					}
					else {
						spawnPossible(0, -stepY);
						spawnPossible(0, -stepY*2);
						spawnPossible(stepX, -stepY);
						spawnPossible(-stepX, -stepY);
					}
				}
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
	@Override
	public ArrayList<Space> getPossible(int sCount, ArrayList<Space> spaces, int x, int y){
		x = sCount * x;
		y = sCount * y;
		List<Space> spaceCheck = getWorld().getObjectsAt(x + getX(), y + getY(), Space.class);
		if (spaceCheck != null){
			for (Space a : spaceCheck){
				if (x == 0 && a.occupied){
					sCount = stepNum;
				}
				else if (x != 0 && a.piece != null && a.piece.getTeam() != Board.getSelected().getTeam()){
					spaces.add(a);
					sCount = stepNum;
				}
				else if (!a.occupied && x == 0){
					spaces.add(a);
				}
				else {
					sCount = stepNum;
				}
			}
		}
		x = x/sCount;
		y = y/sCount;
		sCount++;
		return (sCount >= stepNum) ? spaces : getPossible(sCount, spaces, x, y);
	}
}

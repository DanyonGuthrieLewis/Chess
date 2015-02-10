package primary;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import greenfoot.Actor;
import greenfoot.Greenfoot;
import enums.*;
public abstract class Piece extends Actor{
	protected TEAM team;
	protected PIECE type;
	protected int stepX;
	protected int stepY;
	protected int stepNum;
	protected boolean stepHorizantal = false;
	protected boolean stepVertical = false;
	protected boolean stepDiagnal = false;
	protected boolean hasMoved = false;
	protected static int ID = 0;
	public Piece(TEAM t){
		ID = ID++;
		team = t;
	}
	public int getStepX() {
		return stepX;
	}
	public int getStepY() {
		return stepY;
	}
	public int getStepNum() {
		return stepNum;
	}
	public TEAM getTeam(){
		return team;
	}
	public PIECE getType(){
		return type;
	}
	@Override
	public String toString(){
		return team + " " + type;
	}
	public void setHasMoved(boolean move){
		hasMoved = move;
	}
	public boolean isStepHorizantal() {
		return stepHorizantal;
	}
	public boolean isStepVertical() {
		return stepVertical;
	}
	public boolean isStepDiagnal() {
		return stepDiagnal;
	}
	public Piece clicked(){
		return this;
	}
	public void act(){
		if (Greenfoot.mouseClicked(this)){
			if (Board.getSelected() == null || (ID != Board.getSelected().getID())){
				Board.setSelected(this);
				getImage().setColor(Color.green);
				getImage().drawRect(0, 0, getImage().getWidth() - 1, getImage().getHeight() - 1);
				
				if (stepHorizantal){
					spawnPossible(stepX, 0);
					spawnPossible(-stepX, 0);
				}
				if (stepDiagnal){
					spawnPossible(stepX, stepY);
					spawnPossible(-stepX, stepY);
					spawnPossible(stepX, -stepY);
					spawnPossible(-stepX, -stepY);
				}
				if (stepVertical){
					spawnPossible(0, stepY);
					spawnPossible(0, -stepY);
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
	public ArrayList<Space> getPossible(int sCount, ArrayList<Space> spaces, int x, int y){
		x = sCount * x;
		y = sCount * y;
		List<Space> spaceCheck = getWorld().getObjectsAt(x + getX(), y + getY(), Space.class);
		if (spaceCheck != null){
			for (Space a : spaceCheck){
				if (!a.occupied){
					spaces.add(a);
				}
				else if (a.piece != null && a.piece.getTeam() != Board.getSelected().getTeam()){
					spaces.add(a);
					sCount = stepNum;
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
	public void spawnPossible(int x, int y){
		ArrayList<Space> spaces = getPossible(1, new ArrayList<Space>(), x, y);
		for (Space s : spaces){
			getWorld().addObject(new SpacePossible(), s.getX(), s.getY());
		}
	}
	public int getID(){
		return ID;
	}
}

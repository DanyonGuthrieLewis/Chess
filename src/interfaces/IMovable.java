package interfaces;

import java.util.ArrayList;

import enums.TEAM;
import primary.SpacePossible;

public interface IMovable {
	public int getStepX();
	public int getStepY();
	public int getStepNum();
	public TEAM getTeam();
	public boolean isStepHorizantal();
	public boolean isStepVertical();
	public boolean isStepDiagnal();
}

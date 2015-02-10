package pieces;

import java.util.ArrayList;

import interfaces.IMovable;
import enums.PIECE;
import enums.TEAM;
import primary.Piece;
import primary.SpacePossible;

public class Bishop extends Piece implements IMovable{
	
	public Bishop(TEAM t) {
		super(t);
		if (t == TEAM.BLACK){
			setImage("Chess/BlackBishop.png");
		}
		else{
			setImage("Chess/WhiteBishop.png");
		}
		stepX = 1;
		stepY = 1;
		stepNum = 10;
		stepDiagnal = true;
		stepHorizantal = false;
		stepVertical = false;
		type = PIECE.BISHOP;
	}
}

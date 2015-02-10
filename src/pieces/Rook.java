package pieces;

import enums.PIECE;
import enums.TEAM;
import primary.Piece;

public class Rook extends Piece {

	public Rook(TEAM t) {
		super(t);
		if (t == TEAM.BLACK){
			setImage("Chess/BlackRook.png");
		}
		else{
			setImage("Chess/WhiteRook.png");
		}
		stepX = 1;
		stepY = 1;
		stepNum = 8;
		stepDiagnal = false;
		stepHorizantal = true;
		stepVertical = true;
		type = PIECE.ROOK;
	}
}

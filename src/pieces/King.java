package pieces;

import enums.PIECE;
import enums.TEAM;
import primary.Piece;

public class King extends Piece {
	public King(TEAM t) {
		super(t);
		if (t == TEAM.BLACK){
			setImage("Chess/BlackKing.png");
		}
		else{
			setImage("Chess/WhiteKing.png");
		}
		stepX = 1;
		stepY = 1;
		stepNum = 1;
		stepDiagnal = true;
		stepHorizantal = true;
		stepVertical = true;
		type = PIECE.KING;
	}
}

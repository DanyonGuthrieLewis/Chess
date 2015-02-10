package pieces;

import enums.PIECE;
import enums.TEAM;
import primary.Piece;

public class Queen extends Piece {

	public Queen(TEAM t) {
		super(t);
		if (t == TEAM.BLACK){
			setImage("Chess/BlackQueen.png");
		}
		else{
			setImage("Chess/WhiteQueen.png");
		}
		stepX = 1;
		stepY = 1;
		stepNum = 10;
		stepDiagnal = true;
		stepHorizantal = true;
		stepVertical = true;
		type = PIECE.QUEEN;
	}
}

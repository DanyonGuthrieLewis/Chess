package primary;

import java.util.ArrayList;
import java.util.List;

import other.StatisticsWindow;
import enums.TEAM;
import pieces.*;
import greenfoot.World;

public class Board extends World {
	private static ArrayList<String> gameLog = new ArrayList<String>();
	private final static int worldWidth = 10;
	private final static int worldHeight = 10;
	private final static int cellSize = 50;
	private final static int frontRow = 1;
	private final static int backRow = worldHeight - 2;
	private static Piece selected = null;
	private static TEAM turn = TEAM.WHITE;
	private boolean end = false;
	public Board() {
		super(worldWidth, worldHeight, cellSize);
		
		boolean black = true;
		
		for (int i = 0; i < worldWidth - 1; i++){
			addObject(new SpaceBoarder(), i, 0);
			addObject(new SpaceBoarder(), 0, i + 1);
			addObject(new SpaceBoarder(), worldWidth - 1, i);
			addObject(new SpaceBoarder(), i + 1, worldHeight - 1);
		}
		for (int x = 1; x < worldWidth - 1; x++){
			black = !black;
			for (int y = 1; y < worldHeight - 1; y++){
				addObject((black) ? new SpaceBlack(): new SpaceWhite(), x, y);
				black = !black;
			}
		}
		
		for (int i = 1; i < worldWidth - 1; i++){
			addObject(new Pawn(TEAM.BLACK), i, frontRow+1);
			addObject(new Pawn(TEAM.WHITE), i, worldHeight-3);
		}
		
		addObject(new King(TEAM.BLACK), 5, frontRow);
		addObject(new Queen(TEAM.BLACK), 4, frontRow);
		addObject(new Knight(TEAM.BLACK), 2, frontRow);
		addObject(new Knight(TEAM.BLACK), 7, frontRow);
		addObject(new Bishop(TEAM.BLACK), 3, frontRow);
		addObject(new Bishop(TEAM.BLACK), 6, frontRow);
		addObject(new Rook(TEAM.BLACK), 1, frontRow);
		addObject(new Rook(TEAM.BLACK), 8, frontRow);
	
		addObject(new King(TEAM.WHITE), 4, backRow);
		addObject(new Queen(TEAM.WHITE), 5, backRow);
		addObject(new Knight(TEAM.WHITE), 2, backRow);
		addObject(new Knight(TEAM.WHITE), 7, backRow);
		addObject(new Bishop(TEAM.WHITE), 3, backRow);
		addObject(new Bishop(TEAM.WHITE), 6, backRow);
		addObject(new Rook(TEAM.WHITE), 1, backRow);
		addObject(new Rook(TEAM.WHITE), 8, backRow);
	}
	public void act(){
		List<King> kings = getObjects(King.class);
		if (kings.size() < 2 && !end){
			String moves = "";
			end = true;
			for (String s : gameLog){
				moves += s + "\n";
			}
			new StatisticsWindow(moves);
		}
	}
	public static void setSelected(Piece piece){
		selected = piece;
	}
	public static Piece getSelected(){
		return selected;
	}
	public static void addMove(String newMove){
		gameLog.add(newMove);
	}
}

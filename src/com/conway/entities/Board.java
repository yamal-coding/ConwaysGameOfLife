package com.conway.entities;

import java.util.List;

public class Board {
	public static final int WIDTH = 40;
	public static final int HEIGHT = 40;
	
	public static String UPPER_BAR;
	public static String UNDER_BAR;
	
	static {
		UPPER_BAR = " ";
		for (int i = 0; i < Board.WIDTH; i++)
			UPPER_BAR += '_';
		UPPER_BAR += ' ';
		
		UNDER_BAR = " ";
		for (int i = 0; i < Board.WIDTH; i++)
			UNDER_BAR += '_';
		UNDER_BAR += ' ';
	}
	
	private Cell[][] board;
	
	public Board(List<Coordinate> coordinates) {
		initBoard(coordinates);
	}
	
	public Cell getCell(int x, int y) {
		return x < 0 || x >= HEIGHT || y < 0 || y >= WIDTH ? null : board[x][y];
	}
	
	public boolean isCellAlive(int x, int y) {
		return x < 0 || x >= HEIGHT || y < 0 || y >= WIDTH || !board[x][y].isAlive() ? false : true;
	}
	
	private void initBoard(List<Coordinate> coordinates) {
		board = new Cell[HEIGHT][WIDTH];

		for (int i = 0; i < HEIGHT; i++)
			for (int j = 0; j < WIDTH; j++)
				board[i][j] = new Cell();

		for (Coordinate c : coordinates)
			board[c.getX()][c.getY()].setState(Cell.State.ALIVE);
	}
	
	public boolean setCellState(int x, int y, Cell.State state) {
		boolean ret = true;
		
		if (x < 0 || x >= HEIGHT || y < 0 || y >= WIDTH )
			ret = false;
		else
			board[x][y].setState(state);
		
		return ret;
	}
	
	public boolean setCellChangeInNextTurn(int x, int y, boolean change) {
		boolean ret = true;
		
		if (x < 0 || x >= HEIGHT || y < 0 || y >= WIDTH )
			ret = false;
		else
			board[x][y].setChangeInNextTurn(change);
		
		return ret;
	}
	
	@Override
	public String toString(){
		String ret = "";
		
		ret += UPPER_BAR + "\n";
		
		for (Cell[] row : board) {
			ret += ((char)124);
			for (Cell cell : row) {
				ret += cell;
			}
			ret += ((char)124) + "\n";
		}
		
		return ret + UNDER_BAR + "\n";
	}
}

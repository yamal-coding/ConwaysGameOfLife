package com.conway.model.thread;

import com.conway.entities.Board;

public class ChangeCellStateThread extends Thread {
	private Board board;
	private int boardRow;

	public ChangeCellStateThread(Board board, int boardRow) {
		this.board = board;
		this.boardRow = boardRow;
	}

	@Override
	public void run() {
		for (int i = 0; i < Board.WIDTH; i++)
			if (board.getCell(boardRow, i).mustChangeInNextTurn())
				board.getCell(boardRow, i).changeState();
	}
}

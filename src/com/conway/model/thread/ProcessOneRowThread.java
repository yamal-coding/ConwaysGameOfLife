package com.conway.model.thread;

import com.conway.entities.Board;

public class ProcessOneRowThread extends Thread {
	private Board board;
	private int boardRow;

	public ProcessOneRowThread(Board board, int boardRow) {
		this.board = board;
		this.boardRow = boardRow;
	}

	@Override
	public void run() {
		int aliveAround;

		for (int i = 0; i < Board.WIDTH; i++) {
			aliveAround = 0;

			// 1 0 0
			// 0 - 0
			// 0 0 0
			if (board.isCellAlive(boardRow - 1, i - 1))
				aliveAround++;
			
			// 0 1 0
			// 0 - 0
			// 0 0 0
			if (board.isCellAlive(boardRow - 1, i))
				aliveAround++;
			
			// 0 0 1
			// 0 - 0
			// 0 0 0
			if (board.isCellAlive(boardRow - 1, i + 1))
				aliveAround++;

			// 0 0 0
			// 1 - 0
			// 0 0 0
			if (board.isCellAlive(boardRow, i - 1))
				aliveAround++;
			
			// 0 0 0
			// 0 - 1
			// 0 0 0
			if (board.isCellAlive(boardRow, i + 1))
				aliveAround++;

			// 0 0 0
			// 0 - 0
			// 1 0 0
			if (board.isCellAlive(boardRow + 1, i - 1))
				aliveAround++;

			// 0 0 0
			// 0 - 0
			// 0 1 0
			if (board.isCellAlive(boardRow + 1, i))
				aliveAround++;

			// 0 0 0
			// 0 - 0
			// 0 0 1
			if (board.isCellAlive(boardRow + 1, i + 1))
				aliveAround++;

			if ((!board.getCell(boardRow, i).isAlive() && aliveAround == 3)
					|| (board.getCell(boardRow, i).isAlive() && (aliveAround != 3 && aliveAround != 2)))
				board.setCellChangeInNextTurn(boardRow, i, true);
		}
	}
}

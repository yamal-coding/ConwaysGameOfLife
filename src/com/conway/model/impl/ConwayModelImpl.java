package com.conway.model.impl;

import com.conway.controller.ConwayController.ViewObserver;
import com.conway.entities.Board;
import com.conway.model.ConwayModel;
import com.conway.model.thread.ChangeCellStateThread;
import com.conway.model.thread.ProcessOneRowThread;

public class ConwayModelImpl implements ConwayModel {

	private Board board;

	private ViewObserver viewObserver;
	
	public ConwayModelImpl(Board board) {
		this.board = board;
	}

	public void setViewObserver(ViewObserver viewObserver) {
		this.viewObserver = viewObserver;
	}
	
	@Override
	public void processBoard() {
		try {
			ProcessOneRowThread[] processThreads = new ProcessOneRowThread[Board.HEIGHT];
			
			for (int i = 0; i < Board.HEIGHT; i++) {
				processThreads[i] = new ProcessOneRowThread(board, i);
				processThreads[i].start();
			}
			
			for (int i = 0; i < Board.HEIGHT; i++)
				processThreads[i].join();
			
			ChangeCellStateThread[] chageStateThreads = new ChangeCellStateThread[Board.HEIGHT];
			
			for (int i = 0; i < Board.HEIGHT; i++) {
				chageStateThreads[i] = new ChangeCellStateThread(board, i);
				chageStateThreads[i].start();
			}
			
			for (int i = 0; i < Board.HEIGHT; i++)
				chageStateThreads[i].join();
			
			viewObserver.onShowBoard(board);
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}

	@Override
	public void showBoard() {
		viewObserver.onShowBoard(board);
	}
}

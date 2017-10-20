package com.conway.controller;

import com.conway.entities.Board;

public interface ConwayController {
	
	public interface ViewObserver {
		void onShowBoard(final Board board);
	}
	
	void setViewObserver(ViewObserver viewObserver);
	
	void processBoard();
	
	void showBoard();
}

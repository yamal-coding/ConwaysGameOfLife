package com.conway.model;

import com.conway.controller.ConwayController.ViewObserver;

public interface ConwayModel {
	void processBoard();
	
	void showBoard();
	
	void setViewObserver(ViewObserver viewObserver);
}

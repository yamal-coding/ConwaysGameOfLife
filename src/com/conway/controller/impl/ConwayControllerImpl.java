package com.conway.controller.impl;

import com.conway.controller.ConwayController;
import com.conway.model.ConwayModel;

public class ConwayControllerImpl implements ConwayController {
	private ConwayModel conwayModel;
	
	public ConwayControllerImpl(ConwayModel conwayModel) {
		this.conwayModel = conwayModel;
	}
	
	@Override
	public void processBoard() {
		conwayModel.processBoard();
	}

	@Override
	public void showBoard() {
		conwayModel.showBoard();
	}

	@Override
	public void setViewObserver(ViewObserver viewObserver) {
		conwayModel.setViewObserver(viewObserver);
	}
}

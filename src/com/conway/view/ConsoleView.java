package com.conway.view;

import com.conway.controller.ConwayController;
import com.conway.entities.Board;

public class ConsoleView implements ConwayController.ViewObserver {
	private ConwayController conwayController;
	//private Scanner in;
	
	public ConsoleView(ConwayController conwayController) {
		//in = new Scanner(System.in);
		this.conwayController = conwayController;
		this.conwayController.setViewObserver(this);
	}
	
	public void init() {
		conwayController.showBoard();
		conwayController.processBoard();
	}
	
	@Override
	public void onShowBoard(final Board board) {
		
		System.out.print(board);
		
		//in.nextLine();
		//conwayController.processBoard();
		
		try {
			Thread.sleep(200);
			conwayController.processBoard();
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

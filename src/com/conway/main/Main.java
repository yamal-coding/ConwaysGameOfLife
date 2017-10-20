package com.conway.main;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import com.conway.controller.ConwayController;
import com.conway.controller.impl.ConwayControllerImpl;
import com.conway.entities.Board;
import com.conway.entities.Coordinate;
import com.conway.model.ConwayModel;
import com.conway.model.impl.ConwayModelImpl;
import com.conway.view.ConsoleView;
import com.conway.view.GUIView;

public class Main {

	public static void main(String[] args) {
		List<Coordinate> initialCoordinates = new ArrayList<Coordinate>();
		
		//   00     
		//    00    
		//    0     
		initialCoordinates.add(new Coordinate(14, 14));
		initialCoordinates.add(new Coordinate(13, 14));
		initialCoordinates.add(new Coordinate(13, 13));
		initialCoordinates.add(new Coordinate(14, 15));
		initialCoordinates.add(new Coordinate(15, 14));
		
		//    00
		//   0  0
		//  0    0
		// 0      0
		// 0      0
		//  0    0
		//   0  0
		//    00
		/*initialCoordinates.add(new Coordinate(7, 7));
		initialCoordinates.add(new Coordinate(7, 8));
		initialCoordinates.add(new Coordinate(8, 6));
		initialCoordinates.add(new Coordinate(8, 9));
		initialCoordinates.add(new Coordinate(9, 5));
		initialCoordinates.add(new Coordinate(9, 10));
		initialCoordinates.add(new Coordinate(10, 4));
		initialCoordinates.add(new Coordinate(10, 11));
		initialCoordinates.add(new Coordinate(11, 4));
		initialCoordinates.add(new Coordinate(11, 11));
		initialCoordinates.add(new Coordinate(12, 5));
		initialCoordinates.add(new Coordinate(12, 10));
		initialCoordinates.add(new Coordinate(13, 6));
		initialCoordinates.add(new Coordinate(13, 9));
		initialCoordinates.add(new Coordinate(14, 7));
		initialCoordinates.add(new Coordinate(14, 8));*/
		
		
		Board board = new Board(initialCoordinates);
		
		ConwayModel conwayModel = new ConwayModelImpl(board);
		
		ConwayController conwayController = new ConwayControllerImpl(conwayModel);
		
		//ConsoleView consoleView = new ConsoleView(conwayController);
		//consoleView.init();
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIView frame = new GUIView(conwayController);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

}

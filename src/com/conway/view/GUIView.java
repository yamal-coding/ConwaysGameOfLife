package com.conway.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.conway.controller.ConwayController;
import com.conway.entities.Board;

public class GUIView extends JFrame implements ConwayController.ViewObserver {

	private JPanel contentPane;

	private JLabel[][] board;

	private ConwayController conwayController;

	public GUIView() {

	}

	private void initGui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout());
		setContentPane(contentPane);
		setResizable(false);
		// setSize(10 * Board.WIDTH, 10 * Board.HEIGHT);

		JPanel boardPanel = new JPanel();
		boardPanel.setLayout(new GridLayout(Board.HEIGHT, Board.WIDTH));
		board = new JLabel[Board.HEIGHT][Board.WIDTH];

		for (int i = 0; i < Board.HEIGHT; i++) {
			for (int j = 0; j < Board.WIDTH; j++) {
				board[i][j] = new JLabel();
				board[i][j].setIcon(new ImageIcon("dead.jpg"));
				// board[i][j].setSize(10, 10);
				boardPanel.add(board[i][j]);
			}
		}
		
		contentPane.add(boardPanel, BorderLayout.CENTER);
		
		pack();
	}

	public GUIView(ConwayController conwayController) {
		initGui();
		this.conwayController = conwayController;
		this.conwayController.setViewObserver(this);
		
		this.conwayController.processBoard();
	}

	@Override
	public void onShowBoard(final Board realBoard) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					for (int i = 0; i < Board.HEIGHT; i++)
						for (int j = 0; j < Board.WIDTH; j++)
							board[i][j].setIcon((realBoard.isCellAlive(i, j)) ? new ImageIcon(
									"alive.jpg") : new ImageIcon("dead.jpg"));
					
					Thread.sleep(50);

				} catch (Exception e) {
					e.printStackTrace();
				}
				
				conwayController.processBoard();
			}
		});
	}
}

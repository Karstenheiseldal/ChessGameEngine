package com.company;

import javax.imageio.plugins.jpeg.JPEGImageReadParam;
import javax.swing.*;
import java.awt.*;

public class Main {

	public static void main(String[] args) {

		/*Boardgrid myBoard = new Boardgrid();
		Spot spotfromindex = myBoard.spotArray[0][2];
		Spot spotfromindex2 = myBoard.spotArray[2][0];
		System.out.println(spotfromindex.getPiece());
		System.out.println("x: " + spotfromindex.getX());
		System.out.println("y: " + spotfromindex.getY());
		System.out.println("White: " + spotfromindex.piece.getWhite());
		Player1 player1 = new Player1(true);
		Move firstmove = new Move(player1, spotfromindex, spotfromindex2);
		System.out.println(spotfromindex2.getPiece());
		firstmove.makeMove();
		System.out.println(spotfromindex2.getPiece());*/
		Boardgrid myBoard = new Boardgrid();

		JFrame frame = new JFrame("Chess board");
		frame.setBounds(10, 10, 512, 512);
		frame.setUndecorated(true);
		JPanel panel = new JPanel() {
			@Override
			public void paint(Graphics g) {
				boolean white = true;
				for (int i = 0; i < 8; i++) {
					for (int j = 0; j < 8; j++) {
						Spot spot = myBoard.spotArray[j][i];
						if (white) {
							g.setColor(Color.white.darker());
						} else {
							g.setColor(Color.black.brighter());
						}
						g.fillRect(i * 64, j * 64, 64, 64);
						white = !white;
					}
					white = !white;
				}
			}
		};
		frame.add(panel);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
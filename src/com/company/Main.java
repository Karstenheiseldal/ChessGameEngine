package com.company;

public class Main {

	public static void main(String[] args) {

		Boardgrid myBoard = new Boardgrid();
		Spot spotfromindex = myBoard.spotArray[0][2];
		Spot spotfromindex2 = myBoard.spotArray[2][0];
		System.out.println(spotfromindex.getPiece());
		System.out.println("x: " + spotfromindex.getX());
		System.out.println("y: " + spotfromindex.getY());
		System.out.println("White: " + spotfromindex.piece.getWhite());
		Player1 player1 = new Player1(true);

		Move firstmove = new Move(myBoard, player1, spotfromindex, spotfromindex2);
		System.out.println(spotfromindex2.getPiece());

		try {
			for (int j = 0; j < myBoard.spotArray.length; j++){
				for (int i = 0; i < myBoard.spotArray.length; i++) {
					Spot spot = myBoard.spotArray[j][i];
					System.out.println(spot.getPiece() + " " + spot.piece.white);
				}

			}
		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
	}
}
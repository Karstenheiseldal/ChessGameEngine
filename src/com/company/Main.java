package com.company;

public class Main {

	public static void main(String[] args) {

		Boardgrid myBoard = new Boardgrid();
		Spot spotfromindex = myBoard.spotArray[0][2];
		Spot spotfromindex2 = myBoard.spotArray[2][0];
		System.out.println(spotfromindex.getPiece());
		System.out.println("x: "+spotfromindex.getX());
		System.out.println("y: " +spotfromindex.getY());
		System.out.println("White: " +spotfromindex.piece.getWhite());
		Player1 player1 = new Player1(true);
		Move firstmove = new Move(player1, spotfromindex, spotfromindex2);
		System.out.println(spotfromindex2.getPiece());
		firstmove.makeMove();
		System.out.println(spotfromindex2.getPiece());
	}
}
package com.company;

public class Main {

	public static void main(String[] args) {

		Boardgrid myBoard = new Boardgrid();
		Spot spotfromindex = myBoard.spotArray[6][1];
		System.out.println(spotfromindex.piece.getClass().getSimpleName());
		System.out.println("x: "+ spotfromindex.getX());
		System.out.println("y: " + spotfromindex.getY());
		System.out.println("White: " + spotfromindex.piece.getWhite());
	}
}
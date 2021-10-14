package com.company;

public class Main {

	public static void main(String[] args) {
		Piece pawn = new Pawn(true);
		pawn.setWhite(true);
		pawn.setCoordinates(1, 2);

		Spot spots = new Spot();
		Spot.makeCoordinates();

		if (pawn.getWhite()) {
			System.out.println("Hvid");
		} else {
			System.out.println("black");
		}
	}

}
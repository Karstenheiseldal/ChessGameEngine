package com.company;

public class Main {

	public static void main(String[] args) {
		makeCoordinates();
		Piece pawn = new Pawn(true);
		pawn.setCoordinates(4,5);
		pawn.setWhite(true);

		System.out.println("pawns coordinate (" + pawn.getX() + ", " + pawn.getY() + ")");

		if (pawn.getWhite()) {
			System.out.println("Hvid");
		} else {
			System.out.println("black");
		}
	}

	public static void makeCoordinates() {
		int y; //spot on the y-axis
		int x; //spot on the x-axis


		int spots = 0; //initial name for spot [0][0]
		//the range for the array
		//the i (x-axis) goes up one, and then the j (y-axis) goes up 8 and so on
		for (x = 0; x < 8; x++) {

			for (y = 0; y < 8; y++) {
				Spot tile = new Spot(x, y);


			}
			System.out.println();//makes a new line everytime i=8.
		}
	}
}
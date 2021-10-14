package com.company;

public class Main {

	public static void main(String[] args) {
		Piece pawn = new Pawn(true);
		pawn.setWhite(false);
		Spot spots = new Spot(1,1, pawn);


		if (pawn.getWhite()) {
			System.out.println("White");
		} else {
			System.out.println("black");
		}
	}

}
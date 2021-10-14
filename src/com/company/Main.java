package com.company;

public class Main {

    public static void main(String[] args) {
	Spot tiles = new Spot();
	tiles.makeSpots();
	Piece pawn = new Pawn(true);

	pawn.setWhite(true);

	if(pawn.getWhite()){
		System.out.println("Hvid");
	}

	else{
		System.out.println("black");
	}

    }

}

package com.company;

public class Main {

    public static void main(String[] args) {
	Spot tiles = new Spot();
	tiles.makeCoordinates();

	//tiles.addpawn[x][y]
		//print pawn.xy coordinates

	Piece pawn = new Pawn(true);

	pawn.setWhite(true);

	if(pawn.getWhite()){
		System.out.println("Hvid");
	}

	else{
		System.out.println("black");
	}

		System.out.println("x" + tiles.x+ " Y" + tiles.y);

    }

}
package com.company;

public class Main {

	public static void main(String[] args) {

		Boardgrid myBoard = new Boardgrid();
		Spot moveFrom = myBoard.spotArray[6][0];
		Spot moveTo = myBoard.spotArray[5][0];

		Player1 player1 = new Player1(true);

		Move move = new Move(myBoard, player1, moveFrom, moveTo);
		move.makeMove();

		moveFrom = myBoard.spotArray[1][1];
		moveTo = myBoard.spotArray[3][1];

		move.makeMove();



		try {
			for (int j = 0; j < myBoard.spotArray.length; j++){
				for (int i = 0; i < myBoard.spotArray.length; i++) {
					Spot spot = myBoard.spotArray[j][i];
					if(spot.piece != null)
					System.out.print(" | "+spot.getX()+ ", " + spot.getY() + " " + spot.getPieceName());

					else System.out.print(" | "+spot.x + ", " + spot.y + " free");
				}
				System.out.println();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
package com.company;

public class Main {

	public static void main(String[] args) {

		Boardgrid myBoard = new Boardgrid();
		Spot firstmoveSpot1 = myBoard.spotArray[6][0];
		Spot firstmoveSpot2 = myBoard.spotArray[4][0];
		Spot firstmoveSpot3 = myBoard.spotArray[1][1];
		Spot firstmoveSpot4 = myBoard.spotArray[4][1];
		Player player1 = new Player1(true);
		Player player2 = new Player2(false);

		Move firstmove = new Move(myBoard, player1, firstmoveSpot1, firstmoveSpot2);
		firstmove.makeMove();

		Move secondmove = new Move(myBoard, player2, firstmoveSpot3, firstmoveSpot4);
		secondmove.makeMove();



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
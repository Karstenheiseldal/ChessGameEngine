package com.company;

public class Main {

	public static void main(String[] args) {

		Boardgrid myBoard = new Boardgrid();
		Spot spotfromindex = myBoard.spotArray[6][0];
		Spot spotfromindex2 = myBoard.spotArray[4][0];
		Spot spotfromindex3 = myBoard.spotArray[1][1];
		Spot spotfromindex4 = myBoard.spotArray[3][1];
		Spot spotfromindex5 = myBoard.spotArray[4][0];
		Spot spotfromindex6 = myBoard.spotArray[3][1];

		Player player1 = new Player1(true);
		Player player2 = new Player2(false);

		Move firstmove = new Move(myBoard, player1, spotfromindex, spotfromindex2);
		Move secondmove = new Move(myBoard,player2, spotfromindex3, spotfromindex4);
		Move thirdmove = new Move(myBoard,player1,spotfrominjkldex5, spotfromindex6);

		firstmove.makeMove();
		secondmove.makeMove();
		thirdmove.makeMove();

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
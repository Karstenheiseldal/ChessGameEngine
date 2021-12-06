package com.company;
public class Main {

	public static void main(String[] args) throws Exception {
		boolean gamestart = true;
		Boardgrid myboard = new Boardgrid();
		Player player1 = new Player1(true);
		Player player2 = new Player2(false);
		Display display = new Display();

		display.display(myboard);
		System.out.println("choose new move");

		while (gamestart) {

			try {
				Display.moveList.clear();
				while(Display.moveList.size()<3) Thread.sleep(1000);
				Move move = new Move(myboard,player1,myboard.spotArray[Display.moveList.get(0)][Display.moveList.get(1)], myboard.spotArray[Display.moveList.get(2)][Display.moveList.get(3)]);
				move.makeMove();
				System.out.println(move.movingPieceName + " " + Display.moveList.get(0) + "," + Display.moveList.get(1) + " to " + Display.moveList.get(2) + "," + Display.moveList.get(3));
				display.updateFrame();

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
package com.company;

import java.io.IOException;

public class InitializeGame {

    boolean gameStart = true;
    Boardgrid myboard = new Boardgrid();
    Player player1 = new Player1(true);
    Player player2 = new Player2(false);
    Display display = new Display();
    Integer gamePhase = 1;

    public InitializeGame() throws IOException {
        display.display(myboard);
        System.out.println("choose new move");
        while (gameStart) {
            if (gamePhase == 1)
                try {
                    System.out.println("Player 1 Turn");
                    Display.moveList.clear();
                    while (Display.moveList.size() < 3) Thread.sleep(1000);
                    Move move = new Move(myboard, player1, myboard.spotArray[Display.moveList.get(0)][Display.moveList.get(1)], myboard.spotArray[Display.moveList.get(2)][Display.moveList.get(3)]);
                    move.makeMove();
                    if (move.movingPiece.getWhite() != player1.white && move.illegal) {
                        System.out.println("Player one has White pieces");
                        Display.moveList.clear();
                        gamePhase = 1;
                    }
                    if (move.illegal) {
                        gamePhase = 1;
                    } else {
                        Display.moveList.clear();
                        display.updateFrame();
                        gamePhase = 2;
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            if (gamePhase == 2) {
                try { //Player 2 turn
                    System.out.println("Player 2 turn");
                    Display.moveList.clear();
                    while (Display.moveList.size() < 3) Thread.sleep(1000);
                    Move move = new Move(myboard, player2, myboard.spotArray[Display.moveList.get(0)][Display.moveList.get(1)], myboard.spotArray[Display.moveList.get(2)][Display.moveList.get(3)]);
                    move.makeMove();
                    if (move.movingPiece.getWhite() != player2.white) {
                        System.out.println("Player two has Black pieces");
                        Display.moveList.clear();
                        gamePhase = 2;
                    }
                    if (move.illegal) {
                        gamePhase = 2;
                    } else {

                        System.out.println(move.movingPieceName + " " + Display.moveList.get(0) + "," + Display.moveList.get(1) + " to " + Display.moveList.get(2) + "," + Display.moveList.get(3));
                        display.updateFrame();
                        gamePhase = 1;
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}

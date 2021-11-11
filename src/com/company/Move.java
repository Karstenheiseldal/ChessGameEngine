package com.company;

import java.util.ArrayList;
public class Move {
    Player player;
    Piece movingPiece;
    Spot start;
    Spot end;
    Boardgrid myBoard;

    public Move(Boardgrid myBpard, Player player, Spot start, Spot end) {
        this.player = player;
        this.start = start;
        this.end = end;
        this.movingPiece = start.getPiece();
        this.myBoard = myBpard;

    }

    public void makeMove() {
        this.end.piece = this.start.piece;
        this.start.piece = null;
    }

    public ArrayList<Spot> possibleMoves(Spot start) { //possible moves bishop
        int row = start.getX();
        int column = start.getY();

        //all possible moves in the down positive diagonal
        for (int i = row + 1; i < myBoard.spotArray.length; i++) {
            for (int j = column + 1; j < myBoard.spotArray.length; j++) {

                if (start.getPiece() == null) {
                    possibleMoves(start).add(start);
                    System.out.println(start.getPiece() + " til " + start.getX() + " , " + start.getY());
                }

                if (movingPiece.getWhite() == player.isWhite()) {
                    possibleMoves(start).add(start);
                    break;
                } else {
                    break;
                }
            }
        }
        return possibleMoves(start);
    }
}
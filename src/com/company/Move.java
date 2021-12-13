package com.company;

import java.util.ArrayList;
public class Move {
    Player player;
    String movingPieceName;
    Piece movingPiece;
    Spot start;
    Spot end;
    Boardgrid myBoard;
    boolean illegal = false;


    public Move(Boardgrid myBoard, Player player, Spot start, Spot end) {
        this.player = player;
        this.start = start;
        this.end = end;
        this.movingPiece = start.getPiece();
        this.myBoard = myBoard;
        this.movingPieceName = start.getPieceName();
    }

    public void makeMove() {
        if (movingPiece.legalMoveCheck(start, end, myBoard)) {
            if (this.end.piece != this.start.piece && this.player.white == this.start.piece.getWhite()) {

                if (end.isOccupied && end.getPieceName().equals("King")) {
                    System.out.println("Game over");
                    System.exit(0);
                }
                if (end.isOccupied) {
                    this.end.piece.setKilled(true);
                    if (end.piece.getWhite()) {
                        System.out.println("White" + this.end.getPieceName() + " is killed");
                    }
                    if (!end.piece.getWhite()) {
                        System.out.println("Black" + this.end.getPieceName() + " is killed");
                    }
                }
                this.end.piece = this.start.piece;
                this.end.piece.hasMoved = true;
                this.start.piece = null;

                System.out.println("Legal move");
                this.movingPiece.hasMoved = true;
                this.end.setOccupied(true);
                this.start.setOccupied(false);
            }
        } else {
            System.out.println("Illegal move");
            this.illegal = true;
        }
    }
}

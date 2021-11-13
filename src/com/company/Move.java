package com.company;

import java.util.ArrayList;
public class Move {
    Player player;
    String movingPieceName;
    Piece movingPiece;
    Spot start;
    Spot end;
    Boardgrid myBoard;

    public Move(Boardgrid myBoard, Player player, Spot start, Spot end) {
        this.player = player;
        this.start = start;
        this.end = end;
        this.movingPiece = start.getPiece();
        this.myBoard = myBoard;
    }

    public void makeMove() {
        if (movingPiece.legalMoveCheck(start,end)) {
            this.end.piece = this.start.piece;
            this.start.piece = null;
            this.end.piece.hasMoved = true;
            System.out.println(end.getX());
            System.out.println("Legal move");
        } else {
            System.out.println("illegal move!");
        }
    }
}
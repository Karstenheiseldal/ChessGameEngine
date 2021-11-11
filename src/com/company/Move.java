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
}
package com.company;

public class Move {
    Player player;
    Piece movingPiece;
    Spot start;
    Spot end;

    public Move(Player player, Spot start, Spot end){
        this.player = player;
        this.start = start;
        this.end = end;
        this.movingPiece = start.getPiece();
    }
}

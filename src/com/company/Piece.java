package com.company;

public abstract class Piece {
    Boolean whitePiece = false;
    Boolean killedPiece = false;

    public Piece(boolean whitePiece){
        this.giveWhite(whitePiece);
    }

    public boolean giveWhite(boolean white){
        return this.whitePiece = white;
    }

}

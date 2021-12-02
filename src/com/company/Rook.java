package com.company;

public class Rook extends Piece{

    public Rook(boolean white){ //Rook constructor
        super(white); //inherited boolean
    }

    @Override
    public boolean legalMoveCheck(Spot start, Spot end, Boardgrid boardgrid) {
        return false;
    }
}

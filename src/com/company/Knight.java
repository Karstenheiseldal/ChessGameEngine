package com.company;

public class Knight extends Piece{

    public Knight(boolean white){ //pawn constructor
        super(white); //inherited boolean
    }

    @Override
    public boolean legalMoveCheck(Spot start, Spot end, Boardgrid boardgrid) {
        return false;
    }
}

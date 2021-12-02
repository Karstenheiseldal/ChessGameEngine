package com.company;

public class King extends Piece{
    public King(boolean white){ //King constructor
        super(white); //inherited boolean
    }

    @Override
    public boolean legalMoveCheck(Spot start, Spot end, Boardgrid boardgrid) {
        return false;
    }
}

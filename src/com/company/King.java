package com.company;

import static java.lang.Math.abs;

public class King extends Piece{
    public King(boolean white){ //King constructor
        super(white); //inherited boolean
    }

    @Override
    public boolean legalMoveCheck(Spot start, Spot end, Boardgrid boardgrid) {
        if (end.isOccupied){
            if (end.piece.getWhite() == start.piece.getWhite())return false;
            else return true;
        }
        return abs(start.getX() - end.getX()) <= 1 && abs(start.getY() - end.getY()) <= 1;
    }
}

package com.company;

import static java.lang.Math.abs;

public class King extends Piece{
    public King(boolean white){ //King constructor
        super(white); //inherited boolean
    }

    @Override
    public boolean legalMoveCheck(Spot start, Spot end, Boardgrid boardgrid) {
        if (abs(start.getX() - end.getX()) <= 1 && abs(start.getY() - end.getY()) <= 1) {
            if (end.isOccupied) {
                if (end.piece.getWhite() == start.piece.getWhite()){
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}

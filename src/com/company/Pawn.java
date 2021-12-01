package com.company;

public class Pawn extends Piece {

    public Pawn(boolean white) { //pawn constructor
        super(white); //inherited boolean
    }

    @Override
    public boolean legalMoveCheck(Spot start, Spot end) {
        if (!hasMoved) {
            //if ((start.getY() - end.getY()) <= 2 && start.getY() + && start.getX() != end.getX()) {
                return super.legalMove = true;

        }
        return false;
    }
}
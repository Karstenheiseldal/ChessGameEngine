package com.company;

public class Pawn extends Piece {

    public Pawn(boolean white) { //pawn constructor
        super(white); //inherited boolean
    }

    @Override
    public boolean legalMoveCheck(Spot start, Spot end) {

        if ((start.getX() - end.getX()) == 1 && start.getX() != end.getX() ){
            return super.legalMove = true;
        }
        return super.legalMove = false;
    }
}
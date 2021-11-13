package com.company;

public class Pawn extends Piece {

    public Pawn(boolean white) { //pawn constructor
        super(white); //inherited boolean
    }

    @Override
    public boolean legalMoveCheck(Spot start, Spot end) {

        if (hasMoved) {
            if ((start.getX() - end.getX()) == 1 && start.getX() != end.getX()) {
                return super.legalMove = true;
            }
        }

        if (!hasMoved){
            if ((start.getX() - end.getX()) <= 2 && start.getX() != end.getX() ){
                return super.legalMove = true;
            }
        }

        if(end.isOccupied){
            if(end)
        }
        return super.legalMove = false;
    }
}
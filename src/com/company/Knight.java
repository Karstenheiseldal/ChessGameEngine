package com.company;
import static java.lang.Math.abs;

public class Knight extends Piece{

    public Knight(boolean white){ //pawn constructor
        super(white); //inherited boolean
    }

    @Override
    public boolean legalMoveCheck(Spot start, Spot end, Boardgrid boardgrid) {
        if(end.isOccupied && end.piece.getWhite() == start.piece.getWhite()){
            return false;
        }

        if (abs(start.getY() - end.getY()) == 1 && abs(start.getX() - end.getX()) == 2){
            return true;
        }

        if (!end.isOccupied && abs(start.getY() - end.getY()) == 2 && abs(start.getX() - end.getX()) == 1){
            return true;
        }

        return false;
    }
}

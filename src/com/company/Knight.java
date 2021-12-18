package com.company;
import static java.lang.Math.abs;

public class Knight extends Piece{

    public Knight(boolean white){ //pawn constructor
        super(white); //inherited boolean
    }
    /*
    Check if the end piece is of the same color than the moving knight
    Then check if the absolute value between start and end position is correct
    If the value of x is 2 then the value of y has to be 1.
    if the value of y is 2 then the value of x has to be 1.
    */
    @Override
    public boolean legalMoveCheck(Spot start, Spot end, Boardgrid boardgrid) {
        if(end.isOccupied && end.piece.getWhite() == start.piece.getWhite()){
            return false;
        }
        if (abs(start.getY() - end.getY()) == 1 && abs(start.getX() - end.getX()) == 2){
            return true;
        }
        if (abs(start.getY() - end.getY()) == 2 && abs(start.getX() - end.getX()) == 1){
            return true;
        }
        return false;
    }
}
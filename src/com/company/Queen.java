package com.company;

public class Queen extends Piece{

    public Queen(boolean white){ //Queen constructor
        super(white); //inherited boolean
    }

    @Override
    public boolean legalMoveCheck(Spot start, Spot end) {
        return false;
    }
}

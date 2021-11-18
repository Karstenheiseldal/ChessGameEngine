package com.company;

public class Pawn extends Piece{

    public Pawn(boolean white){ //pawn constructor
        super(white); //inherited boolean
    }

    @Override
    public boolean legalMoveCheck(Spot start, Spot end) {
        return false;
    }

    public boolean legalMove(Spot start, Spot end){
        if(start.getX()+end.getX() <=2 && start.getY() == end.getY()){
            return true;
        }
        return false;
    }

/*
    public static
}*/}
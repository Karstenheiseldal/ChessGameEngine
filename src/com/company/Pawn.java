package com.company;

public class Pawn extends Piece{
    public Pawn(boolean white){ //pawn constructor
        super(white); //inherited boolean
    }

    public boolean legalMove(Spot start, Spot end){
        if(start.getX()+end.getX() <=2 && start.getY() == end.getY()){
            return true;
        }
        return false;
    }
}
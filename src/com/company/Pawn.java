package com.company;

import static java.lang.Math.abs;

public class Pawn extends Piece {

    public Pawn(boolean white) { //pawn constructor
        super(white); //inherited boolean
    }

    @Override

    public boolean legalMoveCheck(Spot start, Spot end, Boardgrid b) {
            //If pawn hasn't moved, and it moves with less than two on the y-axis and none on the x-axis
            if (!hasMoved && abs(start.getY() - end.getY()) <= 2 && start.getX() == end.getX()) {
                if(start.piece.getWhite() && start.getY() > end.getY()){
                    return true;
                }
                return !start.piece.getWhite() && start.getY() < end.getY();
            }
            //If pawn has moved, and it
        // moves with less than one on the y-axis and none on the x-axis
            if (abs(start.getY() - end.getY()) <= 1 && start.getX() == end.getX() && !end.isOccupied) {
                return true;
            }
            /*
            If the end spot is occupied, and by a different color
            the start piece can move to a new location diagonally.

            First we check, if it's occupied and from a different color
            then we check if's white, it can only move y minus one and either one left or right on the x-axis.
            if it's black it can only move y plus one, and either one left or right on the x-axis.
             */
            if (end.isOccupied && start.piece.getWhite() != end.piece.getWhite()) {

                if (start.piece.getWhite()) {
                    if (start.getY() - 1 == end.getY() && start.getX() + 1 == end.getX()) {
                        return true;
                    }
                    return start.getY() - 1 == end.getY() && start.getX() - 1 == end.getX();
                } else if (!start.piece.getWhite()) {
                    if (start.getY() + 1 == end.getY() && start.getX() + 1 == end.getX()) {
                        return true;
                    }
                    return start.getY() + 1 == end.getY() && start.getX() - 1 == end.getX();
                }
            }
        return false;
    }
}
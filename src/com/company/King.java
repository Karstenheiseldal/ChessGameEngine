package com.company;

import static java.lang.Math.abs;

public class King extends Piece{

    public King(boolean white){ //King constructor
        super(white); //inherited boolean
    }
    @Override
    public boolean legalMoveCheck(Spot start, Spot end, Boardgrid boardgrid) {
        if(abs(start.getX() - end.getX()) <= 1 && abs(start.getY() - end.getY()) <= 1){
            if (end.isOccupied){
                return end.piece.getWhite() != start.piece.getWhite();
            }
            return true;
        }

        if(!hasMoved) {
            if (end.getX() == start.getX() + 2 && !boardgrid.spotArray[start.getY()][7].piece.hasMoved) {
                for (int i = start.getX() + 1; i <= end.getX(); i++) {
                    if (boardgrid.spotArray[start.getY()][i].isOccupied) {
                        this.obstacles = true;
                    }
                    this.castle = true;
                    return checkObstacles(start, end, obstacles);
                }
            }

            if (end.getX() == start.getX() - 2 && !boardgrid.spotArray[start.getY()][0].piece.hasMoved) {
                for (int i = start.getX() - 1; i >= end.getX() - 1; i--) {
                    if (boardgrid.spotArray[start.getY()][i].isOccupied) {
                        this.obstacles = true;
                    }
                    this.castle = true;
                    return checkObstacles(start, end, obstacles);
                }
            }
        }
    return false;
    }
}
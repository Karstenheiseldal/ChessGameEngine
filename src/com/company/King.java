package com.company;
import static java.lang.Math.abs;

public class King extends Piece{

    public King(boolean white){ //King constructor
        super(white); //inherited boolean
    }
    /*
    The king has to check for different moves
    First we check if the king is moving one spot in every direction
    and checking whether it's occupied.
     */
    @Override
    public boolean legalMoveCheck(Spot start, Spot end, Boardgrid boardgrid) {
        if(abs(start.getX() - end.getX()) <= 1 && abs(start.getY() - end.getY()) <= 1){
            if (end.isOccupied){
                return end.piece.getWhite() != start.piece.getWhite();
            }
            return true;
        }
        /*
        This is for castling rights
        Using the hasMoved boolean, we can declare if the king has moved
        If false, we can check whether the king is moving either two left or right
        Checking for obstacles and setting castle boolean to true.
         */
        if(!hasMoved) {
            //The king is moving two spots to the right
            if (end.getX() == start.getX() + 2 && !boardgrid.spotArray[start.getY()][7].piece.hasMoved) {
                //looping through the spots between start and end, and checking if it's occupied
                for (int i = start.getX() + 1; i <= end.getX(); i++) {
                    if (boardgrid.spotArray[start.getY()][i].isOccupied) {
                        this.obstacles = true;
                    }
                    this.castle = true;
                    return checkObstacles(start, end, obstacles);
                }
            }
            //the king is moving two spots to the left.
            if (end.getX() == start.getX() - 2 && !boardgrid.spotArray[start.getY()][0].piece.hasMoved) {
                //looping through the spots between start and end, and checking if it's occupied
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
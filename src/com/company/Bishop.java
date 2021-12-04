package com.company;

import java.lang.reflect.Array;
import java.util.Collection;

import static java.lang.Math.abs;

public class Bishop extends Piece {

    public Bishop(boolean white) { //Bishop constructor
        super(white); //inherited boolean
    }
    boolean obstacles;
    @Override
    public boolean legalMoveCheck(Spot start, Spot end, Boardgrid b) {

        if (abs(start.getX() - end.getX()) == abs(start.getY() - end.getY())) { //if the absolute difference between the x-move and y-move

            if (start.getY() < end.getY()) { //When the y-axis goes down (higher number)
                if (start.getX() < end.getX()) { //and the x-axis goes right (higher number)
                    //looping through the spots between start and end, and checking if it's occupied
                    for (int y = start.getY() + 1, x = start.getX() + 1; y < end.getY() && x < end.getX(); y++, x++) {
                        if (b.spotArray[y][x].isOccupied) {
                            obstacles = true;
                            break;
                        }
                    }
                    return checkObs(start, end, obstacles, 1, 1);
                }
                if (start.getX() > end.getX()) { //and when the x-axis goes left (lower number)
                    //looping through the spots between start and end, and checking if it's occupied
                    for (int y = start.getY() + 1, x = start.getX() - 1; y < end.getY() && x > end.getX(); y++, x--) {
                        if (b.spotArray[y][x].isOccupied) {
                            obstacles = true;
                            break;
                        }
                    }
                    return checkObs(start, end, obstacles, 1, -1);
                }
            }
            if (start.getY() > end.getY()) { //when the y-axis goes up (lower number)
                if (start.getX() < end.getX()) { //and the x-axis goes right (higher number)
                    //looping through the spots between start and end, and checking if it's occupied
                    for (int y = start.getY() - 1, x = start.getX() + 1; y > end.getY() && x < end.getX(); y--, x++) {
                        if (b.spotArray[y][x].isOccupied) {
                            obstacles = true;
                            break;
                        }
                    }
                    return checkObs(start, end, obstacles, -1, 1);
                }
                if (start.getX() > end.getX()) { //and when the x-axis goes left (lower number)
                    //looping through the spots between start and end, and checking if it's occupied
                    for (int y = start.getY() - 1, x = start.getX() - 1; y > end.getY() && x > end.getX(); y--, x--) {
                        if (b.spotArray[y][x].isOccupied) { //double negation
                            obstacles = true;
                            break;
                        }
                    }
                    return checkObs(start, end, obstacles, -1, -1);
                }
            }

        }
        return false;
    }//end of legalMoveCheck
    public boolean checkObs (Spot start, Spot end, boolean obstacles, int directionY, int directionX) {
        if (this.obstacles){
            this.obstacles = false;
            if (start.getX()== end.getX()+directionX && end.piece.getWhite()!=start.piece.getWhite()){
                return true;
            } else return start.getY() == end.getY() + directionY && end.piece.getWhite() != start.piece.getWhite();
        }
        if (!this.obstacles) {
            try {
                if (start.piece.getWhite() != end.piece.getWhite()) {
                    return true;
                }
            } catch (Exception e) {
                return true;
            }
        }
        return false;
    }
}


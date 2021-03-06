package com.company;
import static java.lang.Math.abs;

public class Bishop extends Piece {

    public Bishop(boolean white) { //Bishop constructor
        super(white); //inherited boolean
    }

    @Override
    public boolean legalMoveCheck(Spot start, Spot end, Boardgrid b) {
        /*
        First, check if the bishop is moving on the diagonal,
        by checking if the absolute value of startX - endX == absolute value of startY - endY.
        afterwards go into the different diagonals, and loop through each spot on the trajectory
        between the start spot and end spot.
         */
         //if the absolute difference between the x-move and y-move
        if (abs(start.getX() - end.getX()) == abs(start.getY() - end.getY())) {
            //When the y-axis goes down (higher number)
            if (start.getY() < end.getY()) {
                //and the x-axis goes right (higher number)
                if (start.getX() < end.getX()) {
                    //looping through the spots between start and end, and checking if it's occupied
                    for (int y = start.getY() + 1, x = start.getX() + 1; y < end.getY() && x < end.getX(); y++, x++) {
                        //if a spot is occupied, the obstacles boolean is set to true.
                        if (b.spotArray[y][x].isOccupied) {
                            this.obstacles = true;
                            break;
                        }
                    }
                    return checkObstacles(start, end, this.obstacles);
                }
                //and when the x-axis goes left (lower number)
                if (start.getX() > end.getX()) {
                    //looping through the spots between start and end, and checking if it's occupied
                    for (int y = start.getY() + 1, x = start.getX() - 1; y < end.getY() && x > end.getX(); y++, x--) {
                        //if a spot is occupied, the obstacles boolean is set to true.
                        if (b.spotArray[y][x].isOccupied) {
                            this.obstacles = true;
                            break;
                        }
                    }
                    return checkObstacles(start, end, this.obstacles);
                }
            }
            //when the y-axis goes up (lower number)
            if (start.getY() > end.getY()) {
                //and the x-axis goes right (higher number)
                if (start.getX() < end.getX()) {
                    //looping through the spots between start and end, and checking if it's occupied
                    for (int y = start.getY() - 1, x = start.getX() + 1; y > end.getY() && x < end.getX(); y--, x++) {
                        //if a spot is occupied, the obstacles boolean is set to true.
                        if (b.spotArray[y][x].isOccupied) {
                            this.obstacles = true;
                            break;
                        }
                    }
                    return checkObstacles(start, end, this.obstacles);
                }
                //and when the x-axis goes left (lower number)
                if (start.getX() > end.getX()) {
                    //looping through the spots between start and end, and checking if it's occupied
                    for (int y = start.getY() - 1, x = start.getX() - 1; y > end.getY() && x > end.getX(); y--, x--) {
                        //if a spot is occupied, the obstacles boolean is set to true.
                        if (b.spotArray[y][x].isOccupied) {
                            this.obstacles = true;
                            break;
                        }
                    }
                    return checkObstacles(start, end, this.obstacles);
                }
            }
        }
        return false;
    }
}
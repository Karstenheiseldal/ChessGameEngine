package com.company;

import static java.lang.Math.abs;

public class Queen extends Piece {

    public Queen(boolean white) { //Queen constructor
        super(white); //inherited boolean
    }

    @Override
    public boolean legalMoveCheck(Spot start, Spot end, Boardgrid b) {

        if (start.getY() != end.getY() && start.getX() == end.getX()) { //If first mouseclick Y is not the same as the second mouseclick Y, and the x is the same. The rook are moving upwards or downwards the y
            if (start.getY() < end.getY()) { //is start less than end (higher on the board)
                //Iterate through spotarray to find out if there is pieces on the

                for (int y = start.getY() + 1; y < end.getY(); y++) { //count array down the chessboard from start y + 1
                    if (b.spotArray[y][start.getX()].isOccupied) {
                        this.obstacles = true;
                        break;
                    }
                }
                return checkObstacles(start, end, this.obstacles);
            }

            if (start.getY() > end.getY()) { //If start y is bigger than end y
                for (int y = start.getY() - 1; y > end.getY(); y--) { //count array downwards
                    if (b.spotArray[y][start.getX()].isOccupied) {
                        this.obstacles = true;
                        break;
                    }
                }
                return checkObstacles(start, end, this.obstacles);
            }
        }

        if (start.getX() != end.getX() && start.getY() == end.getY()) {

            if (start.getX() > end.getX()) { //if the start x is to the right of end x
                for (int x = start.getX() - 1; x > end.getX(); x--) { //count the array downwards from the square next to start x to the end x.
                    if (b.spotArray[start.getY()][x].isOccupied) {
                        this.obstacles = true;
                        break;
                    }
                }
                return checkObstacles(start, end, this.obstacles);
            }

            if (start.getX() < end.getX()) { //if the start x is less than the end (to the left for end)
                for (int x = start.getX() + 1; x < end.getX(); x++) { //Count array upwards to end x to see if any obstacles
                    if (b.spotArray[start.getY()][x].isOccupied) {
                        this.obstacles = true;
                        break;
                    }
                }
                return checkObstacles(start, end, this.obstacles);
            }
        }else if (abs(start.getX() - end.getX()) == abs(start.getY() - end.getY())) { //if the absolute difference between the x-move and y-move

            if (start.getY() < end.getY()) { //When the y-axis goes down (higher number)
                if (start.getX() < end.getX()) { //and the x-axis goes right (higher number)
                    //looping through the spots between start and end, and checking if it's occupied
                    for (int y = start.getY() + 1, x = start.getX() + 1; y < end.getY() && x < end.getX(); y++, x++) {
                        if (b.spotArray[y][x].isOccupied) {
                            this.obstacles = true;
                            break;
                        }
                    }
                    return checkObstacles(start, end, this.obstacles);
                }
                if (start.getX() > end.getX()) { //and when the x-axis goes left (lower number)
                    //looping through the spots between start and end, and checking if it's occupied
                    for (int y = start.getY() + 1, x = start.getX() - 1; y < end.getY() && x > end.getX(); y++, x--) {
                        if (b.spotArray[y][x].isOccupied) {
                            this.obstacles = true;
                            break;
                        }
                    }
                    return checkObstacles(start, end, this.obstacles);
                }
            }
            if (start.getY() > end.getY()) { //when the y-axis goes up (lower number)
                if (start.getX() < end.getX()) { //and the x-axis goes right (higher number)
                    //looping through the spots between start and end, and checking if it's occupied
                    for (int y = start.getY() - 1, x = start.getX() + 1; y > end.getY() && x < end.getX(); y--, x++) {
                        if (b.spotArray[y][x].isOccupied) {
                            this.obstacles = true;
                            break;
                        }
                    }
                    return checkObstacles(start, end, this.obstacles);
                }
                if (start.getX() > end.getX()) { //and when the x-axis goes left (lower number)
                    //looping through the spots between start and end, and checking if it's occupied
                    for (int y = start.getY() - 1, x = start.getX() - 1; y > end.getY() && x > end.getX(); y--, x--) {
                        if (b.spotArray[y][x].isOccupied) { //double negation
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


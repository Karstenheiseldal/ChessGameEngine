package com.company;

import static java.lang.Math.abs;

public class Queen extends Piece {

    public Queen(boolean white) { //Queen constructor
        super(white); //inherited boolean
    }

    boolean obstacles;

    @Override
    public boolean legalMoveCheck(Spot start, Spot end, Boardgrid b) {
        /*
        if (start.getY() != end.getY() && start.getX() == end.getX()) {
            int diffWithSignsY = abs(start.getY() + end.getY()) / (start.getY() + end.getY());

            System.out.println("diff y" + diffWithSignsY);

            for (int y = start.getY() + diffWithSignsY; y <= end.getY() - diffWithSignsY; y += diffWithSignsY) {
                if (b.spotArray[y][start.getX()].isOccupied) {
                    System.out.println("diff y" + diffWithSignsY);
                    obstacles = true;
                    if (start.getY() + diffWithSignsY == end.getY() && start.piece.getWhite() != end.piece.getWhite()) {
                        return true;
                    }
                }
                System.out.println("1 returning " + obstacles);
            }
            return checkObsR(start, end, obstacles);
        } else if (start.getX() != end.getX() && start.getY() == end.getY()) {

            int diffWithSignsX = abs(start.getX() + end.getX()) / (start.getX() + end.getX());

            for (int x = start.getX() + diffWithSignsX; x <= end.getX() - diffWithSignsX; x += diffWithSignsX) {

                if (b.spotArray[start.getY()][x].isOccupied) {
                    obstacles = true;

                    if (start.getX() + diffWithSignsX == end.getX() && start.piece.getWhite() != end.piece.getWhite()) {
                        return true;
                    }
                }
                System.out.println("2 returning " + obstacles);
            }
            return checkObsR(start, end, obstacles);
        }
        if (abs(start.getX() - end.getX()) == abs(start.getY() - end.getY())) { //if the absolute difference between the x-move and y-move

            if (start.getY() < end.getY()) { //When the y-axis goes down (higher number)
                if (start.getX() < end.getX()) { //and the x-axis goes right (higher number)
                    //looping through the spots between start and end, and checking if it's occupied
                    for (int y = start.getY() + 1, x = start.getX() + 1; y < end.getY() && x < end.getX(); y++, x++) {
                        if (b.spotArray[y][x].isOccupied) {
                            obstacles = true;
                        }
                    }
                    return checkObsB(start, end, obstacles, 1, 1);
                }
                if (start.getX() > end.getX()) { //and when the x-axis goes left (lower number)
                    //looping through the spots between start and end, and checking if it's occupied
                    for (int y = start.getY() + 1, x = start.getX() - 1; y < end.getY() && x > end.getX(); y++, x--) {
                        if (b.spotArray[y][x].isOccupied) { //double negation
                            obstacles = true;
                        }
                    }
                    return checkObsB(start, end, obstacles, 1, -1);
                }
            } else if (start.getY() > end.getY()) { //when the y-axis goes up (lower number)
                if (start.getX() < end.getX()) { //and the x-axis goes right (higher number)
                    //looping through the spots between start and end, and checking if it's occupied
                    for (int y = start.getY() - 1, x = start.getX() + 1; y > end.getY() && x < end.getX(); y--, x++) {
                        if (b.spotArray[y][x].isOccupied) {
                            obstacles = true;
                        }
                    }
                    return checkObsB(start, end, obstacles, -1, 1);
                }
                if (start.getX() > end.getX()) { //and when the x-axis goes left (lower number)
                    //looping through the spots between start and end, and checking if it's occupied
                    for (int y = start.getY() - 1, x = start.getX() - 1; y > end.getY() && x > end.getX(); y--, x--) {
                        if (b.spotArray[y][x].isOccupied) { //double negation
                            obstacles = true;
                        }
                    }
                    return checkObsB(start, end, obstacles, -1, -1);
                }
            }
        }
        return false;

    }
        public boolean checkObsB (Spot start, Spot end, boolean obstacles, int directionY, int directionX) {
            if (this.obstacles){
                if (start.getX()== end.getX()+directionX && end.piece.getWhite()!=start.piece.getWhite()){
                    return true;
                } else if (start.getY() == end.getY() + directionY && end.piece.getWhite()!= start.piece.getWhite()) {
                    return true;
                }
                obstacles = false;
                return false;
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
    public boolean checkObsR (Spot start, Spot end, boolean obstacles){
        //methods for returning if obstacles are not true. we check if the end piece is a different color.
        if (!this.obstacles) {
            try {
                if (start.piece.getWhite() != end.piece.getWhite()) {
                    System.out.println("1 i'm returning true");
                    return true;
                }
            } catch (NullPointerException e) {
                return true;
            }
        }
        //method for returning false if there are obstacles.
        if (obstacles) {
            System.out.println("1:  it's true since obstacles " + obstacles);
            this.obstacles = false;
            return false;
        }
        return false;
    }

         */
        return false;
    }
}

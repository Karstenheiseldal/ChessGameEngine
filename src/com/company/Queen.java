package com.company;

import static java.lang.Math.abs;

public class Queen extends Piece {

    public Queen(boolean white) { //Queen constructor
        super(white); //inherited boolean
    }

    boolean obstacles = false;

    @Override
    public boolean legalMoveCheck(Spot start, Spot end, Boardgrid b) {

        if (abs(start.getX() - end.getX()) == abs(start.getY() - end.getY())) { //if the absolute difference between the x-move and y-move

            if (start.getY() < end.getY()) { //When the y-axis goes down (higher number)
                if (start.getX() < end.getX()) { //and the x-axis goes right (higher number)
                    //looping through the spots between start and end, and checking if it's occupied
                    for (int y = start.getY() + 1, x = start.getX() + 1; y <= end.getY() && x <= end.getX(); y++, x++) {
                        if (b.spotArray[y][x].isOccupied) {
                            if (start.getY() + 1 != end.getY() && start.getX() + 1 != end.getX() && start.piece.getWhite() == end.piece.getWhite()) {
                                return false;
                            }
                            return false;
                        }
                        if (!b.spotArray[y][x].isOccupied) {
                            return true;
                        }

                    }
                }
            }
            if (start.getX() > end.getX()) { //and when the x-axis goes left (lower number)
                //looping through the spots between start and end, and checking if it's occupied
                for (int y = start.getY() + 1, x = start.getX() - 1; y <= end.getY() && x >= end.getX(); y++, x--) {
                    if (b.spotArray[y][x].isOccupied) {
                        if (start.getY() + 1 == end.getY() && start.getX() - 1 == end.getX() && start.piece.getWhite() != end.piece.getWhite()) {
                            return true;
                        }
                        System.out.println("2  it's true since y is " + y + " and x is " + x);
                        return false;

                    }
                    if (!b.spotArray[y][x].isOccupied) {
                        return start.piece.getWhite() != end.piece.getWhite();
                    }
                }
            }
            if (start.getY() > end.getY()) { //when the y-axis goes up (lower number)
                if (start.getX() < end.getX()) { //and the x-axis goes right (higher number)
                    //looping through the spots between start and end, and checking if it's occupied
                    for (int y = start.getY() - 1, x = start.getX() + 1; y >= end.getY() && x <= end.getX(); y--, x++) {
                        if (b.spotArray[y][x].isOccupied) {

                            if (start.getY() - 1 == end.getY() && start.getX() + 1 == end.getX() && start.piece.getWhite() != end.piece.getWhite()) {
                                return true;
                            }
                            System.out.println("3  it's true since y is " + y + " and x is " + x);
                            return false;
                        }
                        if (!b.spotArray[y][x].isOccupied) {
                            return true;
                        }
                    }
                }
                if (start.getX() > end.getX()) { //and when the x-axis goes left (lower number)
                    //looping through the spots between start and end, and checking if it's occupied
                    for (int y = start.getY() - 1, x = start.getX() - 1; y >= end.getY() && x >= end.getX(); y--, x--) {
                        if (b.spotArray[y][x].isOccupied) {

                            if (start.getY() == end.getY() && abs(start.getX() - 1) == end.getX() && start.piece.getWhite() != end.piece.getWhite()) {
                                return true;
                            }
                            if (start.piece.getWhite() == end.piece.getWhite()) {
                                return false;
                            }
                        }
                        if (!b.spotArray[y][x].isOccupied) {
                            return true;
                        }
                    }
                }
            }
        }

        if (!obstacles && start.getY() != end.getY() && start.getX() == end.getX()) { //If first mouseclick Y is not the same as the second mouseclick Y, and the x is the same. Going up or down
            //System.out.println("diff y" + diffWithSignsY);
            if (start.getY() < end.getY()) { //If start y is less than the end y
                //Iterate through spotarray to find out if there is pieces on the
                for (int y = start.getY() + 1; y <= end.getY(); y++) { //count array upwards from start y + 1
                    if (b.spotArray[y][start.getX()].isOccupied) {

                        if (start.piece.getWhite() != end.piece.getWhite()) {
                            return true;
                        }
                        if (start.piece.getWhite() == b.spotArray[y][start.getX()].piece.getWhite()) {
                            return false;
                        }
                    }

                    if (!b.spotArray[y][start.getX()].isOccupied) {
                        return true;
                    }


                    if (!obstacles && start.getY() > end.getY()) { //If start y is bigger than end y
                        for (int y2 = start.getY() - 1; y2 >= end.getY(); y2--) { //count array downwards
                            if (b.spotArray[y][start.getX()].isOccupied) {
                                if (start.getY() + 1 == end.getY() && start.getX() + 1 == end.getX() && start.piece.getWhite() != end.piece.getWhite()) {
                                    return true;
                                }
                                System.out.println("1:  it's true since y is " + y + " and x is " + start.getX());
                                return false;
                            }
                            if (!b.spotArray[y][start.getX()].isOccupied) {
                                try {
                                    if (start.piece.getWhite() != end.piece.getWhite()) {
                                        return true;
                                    }
                                } catch (Exception e) {
                                    System.out.println(e.getMessage());
                                }
                                return !obstacles;
                            }
                        }
                    }
                    return false;
                }
                return false;
            }
        }
        return false;
    }
}

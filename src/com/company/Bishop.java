package com.company;

import java.lang.reflect.Array;
import java.util.Collection;

import static java.lang.Math.abs;
public class Bishop extends Piece {

    public Bishop(boolean white) { //Bishop constructor
        super(white); //inherited boolean
    }

    @Override
    public boolean legalMoveCheck(Spot start, Spot end, Boardgrid b) {

        if (abs(start.getX() - end.getX()) == abs(start.getY() - end.getY())) { //if the absolute difference between the x-move and y-move

            if (start.getY() < end.getY()) { //When the y-axis goes down (higher number)
                if (start.getX() < end.getX()) { //and the x-axis goes right (higher number)
                    //looping through the spots between start and end, and checking if it's occupied
                    for (int y = start.getY() + 1, x = start.getX() + 1; y <= end.getY() && x <= end.getX(); y++, x++) {
                        if (b.spotArray[y][x].isOccupied) {
                            if (start.getY()+1==end.getY() && start.getX()+1== end.getX() && start.piece.getWhite() != end.piece.getWhite()){
                                return true;
                            }
                            System.out.println("1:  it's true since y is " + y + " and x is " + x);
                            return false;
                        }
                        if (!b.spotArray[y][x].isOccupied) {
                            try {
                                if (start.piece.getWhite() != end.piece.getWhite()) {
                                    return true;
                                }
                            } catch (Exception e) {
                            }
                        }
                    }
                }
                if (start.getX() > end.getX()) { //and when the x-axis goes left (lower number)
                    //looping through the spots between start and end, and checking if it's occupied
                    for (int y = start.getY() + 1, x = start.getX() - 1; y <= end.getY() && x >= end.getX(); y++, x--) {
                        if (b.spotArray[y][x].isOccupied) { //double negation
                            if (start.getY()+1==end.getY() && start.getX()-1== end.getX() && start.piece.getWhite() != end.piece.getWhite()){
                                return true;
                            }
                            System.out.println("2  it's true since y is " + y + " and x is " + x);
                            return false;
                        }
                        if (!b.spotArray[y][x].isOccupied) {
                            try {
                                if (start.piece.getWhite() != end.piece.getWhite()) {
                                    return true;
                                }
                            } catch (Exception e) {
                            }
                        }
                    }
                }
            }
            if (start.getY() > end.getY()) { //when the y-axis goes up (lower number)
                if (start.getX() < end.getX()) { //and the x-axis goes right (higher number)
                    //looping through the spots between start and end, and checking if it's occupied
                    for (int y = start.getY() - 1, x = start.getX() + 1; y >= end.getY() && x <= end.getX(); y--, x++) {
                        if (b.spotArray[y][x].isOccupied) {
                            if (start.getY()-1==end.getY() && start.getX()+1== end.getX() && start.piece.getWhite() != end.piece.getWhite()){
                                return true;
                            }
                            System.out.println("3  it's true since y is " + y + " and x is " + x);
                            return false;
                        }
                        if (!b.spotArray[y][x].isOccupied) {
                            try {
                                if (start.piece.getWhite() != end.piece.getWhite()) {
                                    return true;
                                }
                            } catch (Exception e) {
                            }
                        }
                    }
                }
                if (start.getX() > end.getX()) { //and when the x-axis goes left (lower number)
                    //looping through the spots between start and end, and checking if it's occupied
                    for (int y = start.getY() - 1, x = start.getX() - 1; y >= end.getY() && x >= end.getX(); y--, x--) {
                        if (b.spotArray[y][x].isOccupied) { //double negation
                            if (start.getY()-1==end.getY() && start.getX()-1== end.getX() && start.piece.getWhite() != end.piece.getWhite()){
                                return true;
                            }
                            System.out.println("4 it's true since y is " + y + " and x is " + x);
                            return false;
                        }
                        if (!b.spotArray[y][x].isOccupied) {
                            try {
                                if (start.piece.getWhite() != end.piece.getWhite()) {
                                    return true;
                                }
                            } catch (Exception e) {
                            }
                        }
                    }
                }
            }
            return true;
        }
        return false;
    }//end of legalMoveCheck
}
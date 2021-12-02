package com.company;

public class Rook extends Piece{

    public Rook(boolean white){ //Rook constructor
        super(white); //inherited boolean
    }

    @Override
    public boolean legalMoveCheck(Spot start, Spot end, Boardgrid b) {
        if (start.getY()!=end.getY() && start.getX()==end.getX()){
            for (int y = start.getY() + 1; y <= end.getY(); y++) {
                if (b.spotArray[y][start.getX()].isOccupied) {
                    if (start.getY()+1==end.getY() && start.getX()== end.getX() && start.piece.getWhite() != end.piece.getWhite()){
                        return true;
                    }
                    if (start.getY()-1==end.getY() && start.getX()== end.getX() && start.piece.getWhite() != end.piece.getWhite()){
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
                    }
                }
            }
            return true;
        }
        if (start.getX()!=end.getX() && start.getY()==end.getY()){
            for (int x = start.getX() + 1; x <= end.getY(); x++) {
                if (b.spotArray[start.getY()][x].isOccupied) {
                    if (start.getX()+1==end.getX() && start.getY()== end.getY() && start.piece.getWhite() != end.piece.getWhite()){
                        return true;
                    }
                    if (start.getX()-1==end.getX() && start.getY()== end.getY() && start.piece.getWhite() != end.piece.getWhite()){
                        return true;
                    }
                    System.out.println("1:  it's true since y is " + start.getY() + " and x is " + x);
                    return false;
                }
                if (!b.spotArray[start.getY()][x].isOccupied) {
                    try {
                        if (start.piece.getWhite() != end.piece.getWhite()) {
                            return true;
                        }
                    } catch (Exception e) {
                    }
                }
            }
            return true;
        }
        return false;
    }
}

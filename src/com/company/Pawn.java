package com.company;

public class Pawn extends Piece {

    public Pawn(boolean white) { //pawn constructor
        super(white); //inherited boolean
    }

    @Override

    public boolean legalMoveCheck(Spot start, Spot end, Boardgrid b) {

            if (!hasMoved && start.getY() - end.getY() <= 2 && start.getY() - end.getY() >= (-2) && start.getX() == end.getX()) {
                return true;
            }
            if (start.getY() - end.getY() <= 1 && start.getY() - end.getY() >= (-1) && start.getX() == end.getX()) {
                return true;
            }
            if (end.isOccupied && start.piece.getWhite() != end.piece.getWhite()) {
                if (start.piece.getWhite()) {
                    if (start.getY() - 1 == end.getY() && start.getX() + 1 == end.getX()) {
                        return true;
                    }
                    if (start.getY() - 1 == end.getY() && start.getX() - 1 == end.getX()) {
                        return true;
                    }
                } else if (!start.piece.getWhite()) {
                    if (start.getY() + 1 == end.getY() && start.getX() + 1 == end.getX()) {
                        return true;
                    }
                    if (start.getY() + 1 == end.getY() && start.getX() - 1 == end.getX()) {
                        return true;
                    }
                }
            }
        return false;
    }
}

/*
    public static
}*/
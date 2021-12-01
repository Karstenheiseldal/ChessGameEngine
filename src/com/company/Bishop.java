package com.company;

import java.lang.reflect.Array;
import java.util.Collection;

public class Bishop extends Piece {

    public Bishop(boolean white) { //Bishop constructor
        super(white); //inherited boolean
    }

    @Override
    public boolean legalMoveCheck(Spot start, Spot end, Boardgrid b) {

        for (int y = start.getY(), x = start.getX(); x <= end.getX() && y <= end.getY(); y++, x++) {
            if (b.spotArray[y][x] != null) {
                return false;
            }
        }
        return true;
    }
}

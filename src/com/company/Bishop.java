package com.company;

import java.lang.reflect.Array;
import java.util.Collection;

public class Bishop extends Piece {

    public Bishop(boolean white) { //Bishop constructor
        super(white); //inherited boolean
    }

    @Override
    public boolean legalMoveCheck(Spot start, Spot end, Boardgrid b) {
        int x = start.getX();
        if (start.getY() < end.getY() && start.getX() < end.getX()){ //down and right
            for (int y = start.getY(); y <= end.getY(); y++ ){
                if (b.spotArray[y][x]==null){
                        return true;
                    }
                x = x +1;
                }
            }

        if (start.getY() < end.getY() && start.getX() > end.getX()){ //down and left

        }
        if (start.getY() > end.getY() && start.getX() < end.getX()){ //up and right

        }
        if (start.getY() > end.getY() && start.getX() > end.getX()){ //up and left

        }
        return false;
    }
}

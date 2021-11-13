package com.company;

import java.lang.reflect.Array;
import java.util.Collection;

public class Bishop extends Piece {

    public Bishop(boolean white) { //Bishop constructor
        super(white); //inherited boolean
    }

    @Override
    public boolean legalMoveCheck(Spot start, Spot end) {
        return false;
    }
}

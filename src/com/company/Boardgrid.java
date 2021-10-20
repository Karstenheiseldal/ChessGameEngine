package com.company;

public class Boardgrid {

    Spot[][] spotArray = new Spot[8][8];

    public Boardgrid() {
        this.boardReset();
    }

    public Spot getspot(int x, int y) {
        return spotArray[x][y];
    }

    public void boardReset() {
        spotArray[0][0] = new Spot (0,0, new Pawn(true));
        spotArray[0][1] = new Spot (0,1, new Pawn(true));
        spotArray[0][2] = new Spot (0,2, new Pawn(true));
        spotArray[0][3] = new Spot (0,3, new Pawn(true));
        spotArray[0][4] = new Spot (0,4, new Pawn(true));
        spotArray[0][5] = new Spot (0,5, new Pawn(true));
        spotArray[0][6] = new Spot (0,6, new Pawn(true));
        spotArray[0][7] = new Spot (0,7, new Pawn(true));
        spotArray[1][0] = new Spot (1,0, new Pawn(true));
        spotArray[1][1] = new Spot (1,1, new Pawn(true));
        spotArray[1][2] = new Spot (1,2, new Pawn(true));
        spotArray[1][3] = new Spot (1,3, new Pawn(true));
        spotArray[1][4] = new Spot (1,4, new Pawn(true));
        spotArray[1][5] = new Spot (1,5, new Pawn(true));
        spotArray[1][6] = new Spot (1,6, new Pawn(true));
        spotArray[1][7] = new Spot (1,7, new Pawn(true));

        spotArray[6][0] = new Spot (6,0, new Pawn(false));
        spotArray[6][1] = new Spot (6,1, new Pawn(false));
        spotArray[6][2] = new Spot (6,2, new Pawn(false));
        spotArray[6][3] = new Spot (6,3, new Pawn(false));
        spotArray[6][4] = new Spot (6,4, new Pawn(false));
        spotArray[6][5] = new Spot (6,5, new Pawn(false));
        spotArray[6][6] = new Spot (6,6, new Pawn(false));
        spotArray[6][7] = new Spot (6,7, new Pawn(false));
        spotArray[7][0] = new Spot (7,0, new Pawn(false));
        spotArray[7][1] = new Spot (7,1, new Pawn(false));
        spotArray[7][2] = new Spot (7,2, new Pawn(false));
        spotArray[7][3] = new Spot (7,3, new Pawn(false));
        spotArray[7][4] = new Spot (7,4, new Pawn(false));
        spotArray[7][5] = new Spot (7,5, new Pawn(false));
        spotArray[7][6] = new Spot (7,6, new Pawn(false));
        spotArray[7][7] = new Spot (7,7, new Pawn(false));


        for (int i = 2; i < 6; i++) {
            for (int j = 0; j < 8; j++) {
                spotArray[i][j] = new Spot(i, j, null);
            }
        }
    }
}
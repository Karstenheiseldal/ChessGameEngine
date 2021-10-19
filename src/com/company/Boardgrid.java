package com.company;

public class Boardgrid {

    Spot[][] spotArray;

    public Boardgrid() {
        this.boardreset();
    }

    public Spot getspot(int x, int y) {
        return spotArray[x][y];
    }

    public void boardreset() {

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                spotArray[i][j] = new Spot(i, j, null);
            }
        }
    }
}
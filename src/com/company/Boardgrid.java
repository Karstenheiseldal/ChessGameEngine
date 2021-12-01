package com.company;

public class Boardgrid {

    Spot[][] spotArray = new Spot[8][8];
    public Boardgrid() {
        this.boardReset();
    }
    public Spot getSpot(int y, int x) {
        return spotArray[y][x];
    }

    public void boardReset() {
        spotArray[0][0] = new Spot (0,0, new Rook(false));
        spotArray[0][1] = new Spot (0,1, new Knight(false));
        spotArray[0][2] = new Spot (0,2, new Bishop(false));
        spotArray[0][3] = new Spot (0,3, new Queen(false));
        spotArray[0][4] = new Spot (0,4, new King(false));
        spotArray[0][5] = new Spot (0,5, new Bishop(false));
        spotArray[0][6] = new Spot (0,6, new Knight(false));
        spotArray[0][7] = new Spot (0,7, new Rook(false));
        spotArray[1][0] = new Spot (1,0, new Pawn(false));
        spotArray[1][1] = new Spot (1,1, new Pawn(false));
        spotArray[1][2] = new Spot (1,2, new Pawn(false));
        spotArray[1][3] = new Spot (1,3, new Pawn(false));
        spotArray[1][4] = new Spot (1,4, new Pawn(false));
        spotArray[1][5] = new Spot (1,5, new Pawn(false));
        spotArray[1][6] = new Spot (1,6, new Pawn(false));
        spotArray[1][7] = new Spot (1,7, new Pawn(false));

        spotArray[6][0] = new Spot (6,0, new Pawn(true));
        spotArray[6][1] = new Spot (6,1, new Pawn(true));
        spotArray[6][2] = new Spot (6,2, new Pawn(true));
        spotArray[6][3] = new Spot (6,3, new Pawn(true));
        spotArray[6][4] = new Spot (6,4, new Pawn(true));
        spotArray[6][5] = new Spot (6,5, new Pawn(true));
        spotArray[6][6] = new Spot (6,6, new Pawn(true));
        spotArray[6][7] = new Spot (6,7, new Pawn(true));
        spotArray[7][0] = new Spot (7,0, new Rook(true));
        spotArray[7][1] = new Spot (7,1, new Knight(true));
        spotArray[7][2] = new Spot (7,2, new Bishop(true));
        spotArray[7][3] = new Spot (7,3, new Queen(true));
        spotArray[7][4] = new Spot (7,4, new King(true));
        spotArray[7][5] = new Spot (7,5, new Bishop(true));
        spotArray[7][6] = new Spot (7,6, new Knight(true));
        spotArray[7][7] = new Spot (7,7, new Rook(true));


        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (spotArray[i][j] == null){
                    spotArray[i][j] = new Spot(i, j, null);
                }
                if(spotArray[i][j].getPiece()!= null){
                    spotArray[i][j].setOccupied(true);
                }
            }
        }




    }
}
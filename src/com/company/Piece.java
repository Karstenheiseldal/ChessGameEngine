package com.company;

public abstract class Piece {

    public boolean hasMoved = false;
    boolean white = true; //Boolean to determine white/black (true/false)
    boolean obstacles = false;
    boolean killedPiece = false; //to determine killed or not.
    boolean castle;

    public Piece(boolean p){ //Constructor for pieces, white piece true or false
        this.setWhite(p);
    }
    public void setWhite(boolean white){ //to set piece white to true
        this.white = white;
    }
    public boolean getWhite(){ //to return white a white or black piece
        return this.white;
    }
    public void setKilled(boolean killedPiece){
        this.killedPiece = killedPiece;
    }

    public abstract boolean legalMoveCheck(Spot start, Spot end, Boardgrid boardgrid);
    public boolean checkObstacles(Spot start, Spot end, boolean obstacles) {
        //methods for returning if obstacles are not true. we check if the end piece is a different color.
        if (!this.obstacles) {
            try {
                if (start.piece.getWhite() != end.piece.getWhite()) {
                    return true;
                }
            } catch (NullPointerException e) {
                return true;
            }
        }
        //method for returning false if there are obstacles.
        if (this.obstacles) {
            this.obstacles = false;
        }
        return false;
    }
}

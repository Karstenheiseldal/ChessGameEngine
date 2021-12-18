package com.company;

public abstract class Piece {

    //to determine if the piece has moved or not
    public boolean hasMoved = false;
    //to determine white/black (true/false)
    boolean white = true;
    //to determine if legalMoveCheck found any obstacles between the start and end position
    boolean obstacles = false;
    //to determine if the piece is killed or not.
    boolean killedPiece = false;
    //to determine if castling is happening or not.
    boolean castle;

    //Constructor for pieces, white piece true or false
    public Piece(boolean p){
        this.setWhite(p);
    }
    //to set piece white to true
    public void setWhite(boolean white){
        this.white = white;
    }
    //to return the white boolean for white or black piece
    public boolean getWhite(){
        return this.white;
    }
    //to set if the piece is killed or not
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

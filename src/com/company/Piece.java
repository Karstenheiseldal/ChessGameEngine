package com.company;

public abstract class Piece {

    public boolean legalMove;
    public boolean hasMoved = false;
    Boolean white = true; //Boolean to determine white/black (true/false)
    Boolean killedPiece = false; //to determine killed or not.


    public Piece(boolean p){ //Constructor for pieces, white piece true or false
        this.setWhite(p);
    }

    public void setWhite(boolean white){ //to set piece white to true
        this.white = white;
    }
    public boolean getWhite(){ //to return white a white or black piece
        return this.white;
    }

    public abstract boolean legalMoveCheck(Spot start, Spot end);

    /*public boolean isKilled ()  { //return killed piece
        return this.killedPiece;
    }

    public void setKilledPiece(boolean killedPiece){ //kill a piece
        this.killedPiece = killedPiece;
    }*/

}

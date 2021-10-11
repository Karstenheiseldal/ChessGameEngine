package com.company;

public abstract class Piece {
    Boolean white = true; //Boolean to determine white/black (true/false)
    Boolean killedPiece = false; //to determine killed or not.

    public Piece(boolean p){ //Constructor for pieces, white piece true or false
        this.setWhite(p);
    }

    public void setWhite(boolean white){ //to set piece white to true
        this.white = white;
    }

    public boolean getWhite(){ //to return white piece
        return this.white;
    }

    public boolean isKilled ()  { //return killed piece
        return this.killedPiece;
    }

    public void setKilledPiece(boolean killedPiece){ //kill a piece
        this.killedPiece = killedPiece;
    }


}

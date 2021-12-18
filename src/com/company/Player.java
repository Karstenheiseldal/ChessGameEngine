package com.company;

public abstract class Player {
    /*
    holds info about the player
    which player has the turn
    and which player is black or white
     */
    public boolean currentTurn;
    public boolean white;
    public boolean player1;
    public boolean isWhite() {
        return this.white;
     }
}

class Player1 extends Player{
    public Player1(boolean white){
        this.white = true;
        this.player1 = true;
        this.currentTurn = true;
    }
}

class Player2 extends Player{
    public Player2(boolean white){
        this.white = false;
        this.player1 = false;
        this.currentTurn= false;
    }
}
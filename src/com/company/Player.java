package com.company;

public abstract class Player {
    public boolean white;
    public boolean player1;

    public boolean isWhite() {
        return this.white;
     }

    public boolean isPlayer1()
    {
        return this.player1;
    }
}

class Player1 extends Player{
    public Player1(boolean white){
        this.white = white;
        this.player1 = true;
    }
}

class Player2 extends Player{
    public Player2(boolean white){
        this.white = white;
        this.player1 = false;
    }
}

package com.company;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class Match {
    Player1 player1;
    Player2 player2;
    Boardgrid b;
    Display d;


    boolean gameON;

    public Match(Player1 player1, Player2 player2, Boardgrid b){
        this.player1 = player1;
        this.player2 = player2;
        this.b = b;
        gameON = true;
        this.d = new Display();

    }


    public void startMatch() throws IOException, InterruptedException {
        d.display(b);
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("choose new move");

        while (gameON){

            if(player1.turn){
                int startY = d.mouseclickY;
                int startX = d.mouseclickX;

            }

            if (player1.turn = false){

            }
            System.out.println();
        }
    }

    public void endMatch(){
        gameON = false;
        System.exit(1);
    }
}

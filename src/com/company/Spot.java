package com.company;

import java.util.ArrayList;
import java.util.List;

public class Spot{
int x;
int y;
boolean isOccupied;

    public Spot()
    {
        this.isOccupied = false;
        }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    public void setX(int x){
        this.x = x;}
    public void setY(int y){
        this.y = y;}

    public int getX(){
        return this.x;
    }
    public int getY(){ return this.y;}

    public static void makeCoordinates() {

        int[][] array = new int[8][8];

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {

                Spot spott = new Spot();
                spott.setX(i);
                spott.setY(j);

                array[i][j] = array[spott.x][spott.y];
                System.out.print(array[i][j]);
                if (spott.isOccupied) System.out.println(1);
            }
            System.out.println();
        }
    }
}

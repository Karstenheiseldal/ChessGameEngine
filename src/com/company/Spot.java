package com.company;

public class Spot {

    int x;
    int y;
    boolean isOccupied = false;

    public void makeCoordinates() {
        int y; //spot on the y-axis
        int x; //spot on the x-axis
        int spot = 0; //initial name for spot [0][0]
        int[][] arr = new int[8][8]; //the range for the array
            //the i (x-axis) goes up one, and then the j (y-axis) goes up 8 and so on
        for (x = 0; x < 8; x++) {
            //for hver x
            //hvis x < 8 så gi den en bokstav (a,b,c,d,e,f,g,h)
            this.x = x;

            for (y = 0; y < 8; y++) {
                spot=spot+1; // everytime the spot goes up, the assigned number goes up
                arr[x][y]=spot; //new spot number assaigned to the array spot
                System.out.println("y" + y);
                this.y = y;
            } 
            System.out.println();//makes a new line everytime i=8.
        }
    }
}

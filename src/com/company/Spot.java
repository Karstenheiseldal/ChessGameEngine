package com.company;

public class Spot {

    public static void spot() {
        int i; //spot on the y-axis
        int j; //spot on the x-axis
        int spot = 0; //initial name for spot [0][0]
        int[][] arr = new int[8][8]; //the range for the array
            //the i (x-axis) goes up one, and then the j (y-axis) goes up 8 and so on
        for (i = 0; i < 8; i++) {
            for (j = 0; j < 8; j++) {
                spot=spot+1; // everytime the spot goes up, the assigned number goes up
                arr[i][j]=spot; //new spot number assaigned to the array spot
                System.out.print(arr[i][j] + " "); //print out
            } 
            System.out.println();//makes a new line everytime i=8.
        }
    }
}

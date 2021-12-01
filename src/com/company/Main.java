package com.company;

import javax.swing.*;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {

		Boardgrid myBoard = new Boardgrid();
		Spot spotfromindex = myBoard.spotArray[1][1];
		Spot spotfromindex2 = myBoard.spotArray[2][1];

		Player1 player1 = new Player1(true);

		Move firstmove = new Move(myBoard, player1, spotfromindex, spotfromindex2);


		firstmove.makeMove();

		Scanner inp = new Scanner(System.in);
		System.out.println("X value of start");
		int startX = inp.nextInt();
		System.out.println("y value of start");
		int startY = inp.nextInt();
		System.out.println("end x");
		int endX = inp.nextInt();
		System.out.println("end y");
		int endY = inp.nextInt();
		Spot spotStart = myBoard.spotArray[startY][startX];
		System.out.println(spotStart.getPieceName());
		Spot spotEnd = myBoard.spotArray[endY][endX];
		System.out.println(spotEnd.getPieceName());
		Move secMove = new Move(myBoard, player1,spotStart, spotEnd);


	}
}
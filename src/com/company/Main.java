package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.io.File;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {


		Boardgrid myBoard = new Boardgrid();

		/*
		Spot spotfromindex = myBoard.spotArray[0][2];
		Spot spotfromindex2 = myBoard.spotArray[2][0];
		System.out.println(spotfromindex.getPiece());
		System.out.println("x: " + spotfromindex.getX());
		System.out.println("y: " + spotfromindex.getY());
		System.out.println("White: " + spotfromindex.piece.getWhite());
		Player1 player1 = new Player1(true);
		Move firstmove = new Move(player1, spotfromindex, spotfromindex2);
		System.out.println(spotfromindex2.getPiece());
		firstmove.makeMove();
		System.out.println(spotfromindex2.getPiece());

		 */
		Display.display();

		//Boardgrid myBoard = new Boardgrid();

	}
}
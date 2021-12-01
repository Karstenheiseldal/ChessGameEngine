package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
Boolean gamePlay =true;
		Boardgrid myboard = new Boardgrid();

		Player player1 = new Player1(true);
		Player player2 = new Player2(false);
		Display display = new Display();
		display.display(myboard);
		while (gamePlay){
			Scanner scanner1 = new Scanner(System.in);
			display.updateFrame();
			System.out.println("choose new move");
			int startY = scanner1.nextInt();
			int startX = scanner1.nextInt();
			int endY = scanner1.nextInt();
			int endX = scanner1.nextInt();

			Move nextMove = new Move(myboard,player1,myboard.spotArray[startY][startX], myboard.spotArray[endY][endX]);
			nextMove.makeMove();


		}
	}
}
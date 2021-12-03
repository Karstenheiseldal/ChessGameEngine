package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		boolean gamestart = true;
		Boardgrid myboard = new Boardgrid();
		Player player1 = new Player1(true);
		Player player2 = new Player2(false);
		Display display = new Display();
		display.display(myboard);
		System.out.println("choose new move");


		System.out.println("choose new move");
		while (gamestart) {
			try {
				Move move = new Move(myboard,player1,myboard.spotArray[display.moveList.get(0)][display.moveList.get(1)],myboard.spotArray[display.moveList.get(2)][display.moveList.get(3)]);
				move.makeMove();

			} catch (Exception e) {
			}
		}
	}
}
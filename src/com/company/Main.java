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

	public static void main(String[] args) throws IOException, InterruptedException {
		Boolean gamePlay = true;
		Boardgrid myboard = new Boardgrid();
		Player1 player1 = new Player1(true);
		Player2 player2 = new Player2(false);
		Match match = new Match(player1,player2,myboard);
		match.startMatch();

	}
}
package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.io.File;
import java.io.IOException;

public class Display {

    public static void display(Boardgrid b) throws IOException {
         /*
First, we load all the images from the pics file. We do this with buffered image with the piece name.
 */
        String bkingPath = ("pics/bking.png");
        BufferedImage bking = ImageIO.read(new File(bkingPath));

        String bqueenPath = ("pics/bqueen.png");
        BufferedImage bqueen = ImageIO.read(new File(bqueenPath));

        String brookPath = ("pics/brook.png");
        BufferedImage brook = ImageIO.read(new File(brookPath));

        String bknightPath = ("pics/bknight.png");
        BufferedImage bknight = ImageIO.read(new File(bknightPath));

        String bbishopPath = ("pics/bbishop.png");
        BufferedImage bbishop = ImageIO.read(new File(bbishopPath));

        String bpawnPath = ("pics/bpawn.png");
        BufferedImage bpawn = ImageIO.read(new File(bpawnPath));

        String wkingPath = ("pics/wking.png");
        BufferedImage wking = ImageIO.read(new File(wkingPath));

        String wqueenPath = ("pics/wqueen.png");
        BufferedImage wqueen = ImageIO.read(new File(wqueenPath));

        String wrookPath = ("pics/wrook.png");
        BufferedImage wrook = ImageIO.read(new File(wrookPath));

        String wknightPath = ("pics/wknight.png");
        BufferedImage wknight = ImageIO.read(new File(wknightPath));

        String wbishopPath = ("pics/wbishop.png");
        BufferedImage wbishop = ImageIO.read(new File(wbishopPath));

        String wpawnPath = ("pics/wpawn.png");
        BufferedImage wpawn = ImageIO.read(new File(wpawnPath));
        /*
        creating panels, which we color white and black, and add pictures
        */
        JPanel panel = new JPanel() {
            @Override
            public void paint(Graphics g) {
                boolean white = true;

                for (int y = 0; y <= 7; y++) {
                    for (int x = 0; x <=7; x++) {

                        if (white) {
                            g.setColor(new Color(222, 184, 135));
                        } else {
                            g.setColor(new Color(139, 69, 19));

                        }
                        g.fillRect(x * 64, y * 64, 64, 64);
                        /*
                        setting the spot from spotArray to spotFromIndex, and checking the spot if white or black. Then calling showPics method.
                         */
                        Spot spotFromIndex = b.spotArray[y][x];

                        try {
                            if (spotFromIndex.piece.getWhite()) {
                                showPics(g, y, x, spotFromIndex, wking, wqueen, wbishop, wrook, wknight, wpawn);
                            } else if (!spotFromIndex.piece.getWhite()) {
                                showPics(g, y, x, spotFromIndex, bking, bqueen, bbishop, brook, bknight, bpawn);
                            }
                        } catch (Exception e){}
                        white = !white;
                    }
                    white = !white;
                }
            }
            /*
            Method that shows the pictures, depending on the x and y. if the spot contains a king it will show king.
             */
            private void showPics(Graphics g, int y, int x, Spot spotFromIndex, BufferedImage king, BufferedImage queen, BufferedImage bishop, BufferedImage rook, BufferedImage knight, BufferedImage pawn) {
                if (spotFromIndex.getPieceName().equalsIgnoreCase("king")) {
                    g.drawImage(king,  x*64,  y*64, 64, 64, this);
                } else if (spotFromIndex.getPieceName().equalsIgnoreCase("queen")) {
                    g.drawImage(queen,  x*64,  y*64, 64, 64, this);
                } else if (spotFromIndex.getPieceName().equalsIgnoreCase("bishop")) {
                    g.drawImage(bishop,  x*64,  y*64, 64, 64, this);
                } else if (spotFromIndex.getPieceName().equalsIgnoreCase("rook")) {
                    g.drawImage(rook,  x*64,  y*64, 64, 64, this);
                } else if (spotFromIndex.getPieceName().equalsIgnoreCase("knight")) {
                    g.drawImage(knight,  x*64,  y*64, 64, 64, this);
                } else if (spotFromIndex.getPieceName().equalsIgnoreCase("pawn")) {
                    g.drawImage(pawn,  x*64,  y*64, 64, 64, this);
                }
            }
        };
        JFrame frame = new JFrame("Chess board");
        frame.setBounds(10, 10, 512, 512);
        frame.setUndecorated(true);
        frame.add(panel); //adding the panels(squares) into the frame
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //quit the program when you close the window
        frame.setVisible(true); //makes it visible
    }
    public static void updateDisplay (){}
}
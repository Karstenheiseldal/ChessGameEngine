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

    public static void display() throws IOException {
        //trying to import images and cropping each individual piece into an array of images.
        /*Image all= ImageIO.read(new File("D:\\chess.png"));
        Image imgs[]=new Image[12];
        int ind=0;
        for (int y=0;y<400;y+=200){
            for (int x=0;x<1200;x+=200){
                imgs[ind]=all.getGraphics(x,y,200,200).getScaledInstance(64,64,BufferedImage.SCALE_SMOOTH);
                ind++;
            }
        }*/
        //Creating the frame
        JFrame frame = new JFrame("Chess board");
        frame.setBounds(10, 10, 512, 512);
        frame.setUndecorated(true);
        //adding pictures of the pieces
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

        Boardgrid boardgrid = new Boardgrid();

        //creating panels, which we color white and black

        JPanel panel = new JPanel() {
            @Override
            public void paint(Graphics g) {
                boolean white = true;

                for (int y = 0; y <= 7; y++) {
                    for (int x = 0; x <=7; x++) {
                        System.out.println("x is : " + x);
                        System.out.println("y is : " + y);

                        if (white) {
                            g.setColor(new Color(222, 184, 135));
                        } else {
                            g.setColor(new Color(139, 69, 19));

                        }
                        g.fillRect(x * 64, y * 64, 64, 64);

                        Spot spotFromIndex = boardgrid.spotArray[y][x];

                        try {
                            System.out.println(spotFromIndex.getPieceName());
                            System.out.println(spotFromIndex.piece.getWhite());
                            if (spotFromIndex.piece.getWhite()==true) {
                                if (spotFromIndex.getPieceName().equalsIgnoreCase("king")) {
                                    System.out.println("white king");
                                    g.drawImage(wking,  x*64,  y*64, 64, 64, this);
                                } else if (spotFromIndex.getPieceName().equalsIgnoreCase("queen")) {
                                    System.out.println("white queen");
                                    g.drawImage(wqueen,  x*64,  y*64, 64, 64, this);
                                } else if (spotFromIndex.getPieceName().equalsIgnoreCase("bishop")) {
                                    System.out.println("white bishop");
                                    g.drawImage(wbishop,  x*64,  y*64, 64, 64, this);
                                } else if (spotFromIndex.getPieceName().equalsIgnoreCase("rook")) {
                                    System.out.println("white rook");
                                    g.drawImage(wrook,  x*64,  y*64, 64, 64, this);
                                } else if (spotFromIndex.getPieceName().equalsIgnoreCase("knight")) {
                                    System.out.println("white knight");
                                    g.drawImage(wknight,  x*64,  y*64, 64, 64, this);
                                } else if (spotFromIndex.getPieceName().equalsIgnoreCase("pawn")) {
                                    System.out.println("white pawn");
                                    g.drawImage(wpawn,  x*64,  y*64, 64, 64, this);
                                }
                            } else if (spotFromIndex.piece.getWhite()==false) {
                                if (spotFromIndex.getPieceName().equalsIgnoreCase("king")) {
                                    System.out.println("white king");
                                    g.drawImage(bking,  x*64,  y*64, 64, 64, this);
                                } else if (spotFromIndex.getPieceName().equalsIgnoreCase("queen")) {
                                    System.out.println("white queen");
                                    g.drawImage(bqueen,  x*64,  y*64, 64, 64, this);
                                } else if (spotFromIndex.getPieceName().equalsIgnoreCase("bishop")) {
                                    System.out.println("white bishop");
                                    g.drawImage(bbishop,  x*64,  y*64, 64, 64, this);
                                } else if (spotFromIndex.getPieceName().equalsIgnoreCase("rook")) {
                                    System.out.println("white rook");
                                    g.drawImage(brook,  x*64,  y*64, 64, 64, this);
                                } else if (spotFromIndex.getPieceName().equalsIgnoreCase("knight")) {
                                    System.out.println("white knight");
                                    g.drawImage(bknight,  x*64,  y*64, 64, 64, this);
                                } else if (spotFromIndex.getPieceName().equalsIgnoreCase("pawn")) {
                                    System.out.println("white pawn");
                                    g.drawImage(bpawn,  x*64,  y*64, 64, 64, this);
                                }
                            }
                        } catch (Exception e){
                            System.out.println("spot is empty");
                        }

                        white = !white;

                    }
                    white = !white;
                }
            }
        };
        //frame.add(jPanel);
        frame.add(panel); //adding the panels(squares) into the frame
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //quit the program when you close the window
        frame.setVisible(true); //makes it visible
    }
}
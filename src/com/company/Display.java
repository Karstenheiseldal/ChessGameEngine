package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Display {
    JPanel panel; //this class has a panel and a frame
    JFrame frame;
    int firstmouseX;
    int firstmouseY;
    int secondmouseX;
    int secondmouseY;

    boolean mouseClicked = false;
    public ArrayList<Integer> moveList = new ArrayList<Integer>();


    public void display(Boardgrid b) throws IOException { //display graphics method
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
        this.panel = new JPanel() {
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
        this.frame = new JFrame("Chess board");
        this.frame.setBounds(10, 10, 512, 512);
        this.frame.setUndecorated(true);
        this.frame.add(this.panel); //adding the panels(squares) into the frame
        this.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //quit the program when you close the window
        this.frame.setVisible(true); //makes it visible
        Image icon = Toolkit.getDefaultToolkit().getImage("pics/icon.png");
        frame.setIconImage(icon);

        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {

                if (moveList.isEmpty()) {
                        int mouseX = e.getX() / 64;
                        int mouseY = e.getY() / 64;
                        moveList.add(0,mouseY);
                        moveList.add(1, mouseX);
                    }
                else if(!moveList.isEmpty()){
                        int mouseX = e.getX() / 64;
                        int mouseY = e.getY() / 64;
                        moveList.add(2, mouseY);
                        moveList.add(3, mouseX);
                    }
                    System.out.println("first click " + moveList.get(0) + "," + moveList.get(1) + " Second click" + moveList.get(2) + " " + moveList.get(3));
                }
            public void mouseReleased(MouseEvent e){
                //System.out.println(e.getClickCount());
            }
            public void mouseEntered(MouseEvent e){
                //System.out.println("here comes the mouse");
            }
        });
    }

    public void updateFrame(){ //updates the frame
        this.frame.setVisible(false);
        this.frame.setVisible(true);
    }
}
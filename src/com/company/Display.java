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

    static  ArrayList<Integer> moveList = new ArrayList<Integer>(3);

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
            public void paint(Graphics g){
                boolean white = true;
                //Looping through 8x8 squares
                //Using the white boolean, to switch between dark and light squares
                for (int y = 0; y <= 7; y++) {
                    for (int x = 0; x <=7; x++) {
                        if (white) {
                            g.setColor(new Color(222, 184, 135));
                        } else {
                            g.setColor(new Color(139, 69, 19));

                        }
                        g.fillRect(x * 64, y * 64, 64, 64);
                        /*
                        setting the spot from spotArray to spotFromIndex, and checking the spot if white or black.
                        Calling the showPics method, with either black or white piece pictures as arguments.
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
            Method that shows the pictures, depending on the piece name from spotFromIndex. if the spot contains a king it will show king.
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
        /*
        Using JFrame we get the right display.
        setBounds to get the correct placement and size
        setUndecorated(true) to remove the outline of the frame
        Adding the panel (which shows the squares and picture)
        Close the program when the window is closed.
         */
        this.frame = new JFrame("Chess board");
        this.frame.setBounds(10, 10, 512, 512);
        this.frame.setUndecorated(true);
        this.frame.add(this.panel); //adding the panels(squares) into the frame
        this.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //quit the program when you close the window
        this.frame.setVisible(true); //makes it visible
        Image icon = Toolkit.getDefaultToolkit().getImage("pics/icon.png");
        frame.setIconImage(icon);

        //adding a mouselistener to the panel
        panel.addMouseListener(new MouseAdapter(){
            //Using a mousePressed method
            @Override
            public void mousePressed(MouseEvent e) {
            /*
            Using the moveList, we add the y and x to dedicated indexes.
            This enables the makeMove method to get coordinates from the user
            To get the x- and y-coordinates of the startSpot we add to an empty list
            To get the x- and y-coordinates of the endSpot we add to a non-empty list.
             */
                if (moveList.isEmpty()) {
                    int mouseX = e.getX() / 64;
                    int mouseY = e.getY() / 64;
                    try {
                        moveList.add(0, mouseY);
                        moveList.add(1, mouseX);
                    } catch (IndexOutOfBoundsException f) {
                        System.out.println(f.getMessage());
                    }
                }
                else if(!moveList.isEmpty()){ //If the list is not empty, that means index 0 and 1 is filled, and the y and x of the second click get index 2 and 3.
                        int mouseX = e.getX() / 64;
                        int mouseY = e.getY() / 64;
                        try {
                            moveList.add(2, mouseY);
                            moveList.add(3, mouseX);

                        } catch (IndexOutOfBoundsException g){
                            System.out.println(g.getMessage());
                        }
                }
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
        this.panel.updateUI();
    }
}
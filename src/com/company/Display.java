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
        String imagePath = ("pics/bking.png");
        BufferedImage myPicture = ImageIO.read(new File(imagePath));
        JLabel picLabel = new JLabel(new ImageIcon(myPicture));
        JPanel jPanel = new JPanel();
        jPanel.add(picLabel);

        picLabel.setBounds(64,64,100,100);
        JFrame f = new JFrame();
        f.setSize(new Dimension(myPicture.getWidth(), myPicture.getHeight()));
        f.add(jPanel);
        f.setVisible(true);

        //creating panels, which we color white and black
        JPanel panel = new JPanel() {
            @Override
            public void paint(Graphics g) {
                boolean white = true;
                for (int j = 0; j < 8; j++) {
                    for (int i = 0; i < 8; i++) {

                        if (white) {
                            g.setColor(new Color(222, 184, 135));
                        } else {
                            g.setColor(new Color(139, 69, 19));
                        }
                        g.fillRect(i * 64, j * 64, 64, 64);
                        white = !white;
                    }
                    white = !white;
                }
            }
        };


        frame.add(panel); //adding the panels(squares) into the frame
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //quit the program when you close the window
        frame.setVisible(true); //makes it visible
    }
}
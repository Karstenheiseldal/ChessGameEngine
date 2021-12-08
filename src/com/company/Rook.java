package com.company;
import static java.lang.Math.abs;

public class Rook extends Piece{

    public Rook(boolean white){ //Rook constructor
        super(white); //inherited boolean
    }
    boolean obstacles;
    @Override
    public boolean legalMoveCheck(Spot start, Spot end, Boardgrid b) {

        if (start.getY() != end.getY() && start.getX() == end.getX()) {
            int diffWithSignsY = abs(start.getY() + end.getY()) / (start.getY() + end.getY());

            System.out.println("diff y" + diffWithSignsY);

            for (int y = start.getY() + diffWithSignsY; y <= end.getY() - diffWithSignsY; y+=diffWithSignsY) {
                if (b.spotArray[y][start.getX()].isOccupied) {
                    System.out.println("diff y" + diffWithSignsY);
                    if (start.getY() +diffWithSignsY == end.getY() && start.piece.getWhite() != end.piece.getWhite()) {
                        return true;
                    }
                    else return false;
                }
                System.out.println("1 returning " + obstacles);
            }
            return checkObs(start, end, obstacles);
        }

        if (start.getX() != end.getX() && start.getY() == end.getY()) {

            int diffWithSignsX = abs(start.getX() + end.getX()) / (start.getX() + end.getX());

            for (int x = start.getX() + diffWithSignsX; x <= end.getX() - diffWithSignsX; x+=diffWithSignsX) {
                System.out.println("before the x loop " + diffWithSignsX);
                if (b.spotArray[start.getY()][x].isOccupied) {
                    obstacles = true;

                    System.out.println("diff x" + diffWithSignsX + "diff y" + diffWithSignsX);
                    if (start.getX() +diffWithSignsX == end.getX() && start.piece.getWhite() != end.piece.getWhite()) {
                        return true;
                    }
                }
                System.out.println("2 returning " + obstacles);
            }
            return checkObs(start, end, obstacles);

        }
        return false;
    }
    public boolean checkObs (Spot start, Spot end, boolean obstacles){
        //methods for returning if obstacles are not true. we check if the end piece is a different color.
        if (!obstacles) {
            try {
                if (start.piece.getWhite() != end.piece.getWhite()) {
                    System.out.println("1 i'm returning true");
                    return true;
                }
            } catch (NullPointerException e) {
                return true;
            }
        }
        //method for returning false if there are obstacles.
        if (obstacles) {
            System.out.println("1:  it's true since obstacles " + obstacles);
            obstacles = false;
            return false;
        }
        return false;
    }
}
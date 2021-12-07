package com.company;
import static java.lang.Math.abs;

public class Rook extends Piece{

    public Rook(boolean white){ //Rook constructor
        super(white); //inherited boolean
    }
    boolean obstacles = false;
    @Override
    public boolean legalMoveCheck(Spot start, Spot end, Boardgrid b) { //Method to check if a move is legal or not

        if (start.getY() != end.getY() && start.getX() == end.getX()) { //If first mouseclick Y is not the same as the end Y, and the x is the same. The rook are moving upwards or downwards the y
            int diffWithSignsY = abs(start.getY() + end.getY() / (start.getY() + end.getY())); //Integer of the start Y and end Y divided by the start Y and end Y ??

            System.out.println("diff y" + diffWithSignsY);

            for (int y = start.getY() + diffWithSignsY; y <= end.getY() - diffWithSignsY; y+=diffWithSignsY) { //Iterate through spotarray to find out if there is pieces on the
                if (b.spotArray[y][start.getX()].isOccupied) { //if the spot is occupied
                    System.out.println("diff y" + diffWithSignsY);
                    this.obstacles = true;
                    if (start.getY() +diffWithSignsY == end.getY() && start.piece.getWhite() != end.piece.getWhite() && !this.obstacles) {
                        return true;
                    }
                }
            }
            return checkObs(start,end, this.obstacles);
        }

        if (start.getX() != end.getX() && start.getY() == end.getY() && !obstacles) {

            int diffWithSignsX = abs(start.getX() + end.getX()) / (start.getX() + end.getX());

            for (int x = start.getX() + diffWithSignsX; x <= end.getX() - diffWithSignsX; x+=diffWithSignsX) {
                System.out.println("before the x loop " + diffWithSignsX);
                if (b.spotArray[start.getY()][x].isOccupied) {
                    this.obstacles = true;

                    System.out.println("diff x" + diffWithSignsX + "diff y" + diffWithSignsX);
                    if (start.getX() +diffWithSignsX == end.getX() && start.piece.getWhite() != end.piece.getWhite()) {
                        return true;
                    }
                }
                System.out.println("2 returning " + obstacles);
            }
            return checkObs(start, end, this.obstacles);
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
                    System.out.println(e.getMessage());
                    return true;
                }
            }
            //method for returning false if there are obstacles.
            if (this.obstacles) {
                System.out.println("1:  it's true since obstacles " + obstacles);
                this.obstacles = false;
                return false;
            }
            return false;
        }
}

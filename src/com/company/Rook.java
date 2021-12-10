package com.company;
import static java.lang.Math.abs;

public class Rook extends Piece {

    public Rook(boolean white) { //Rook constructor
        super(white); //inherited boolean
    }
        boolean obstacles = false;

        @Override
        public boolean legalMoveCheck(Spot start, Spot end, Boardgrid b) { //Method to check if a move is legal or not

            if (start.getY() != end.getY() && start.getX() == end.getX()) { //If first mouseclick Y is not the same as the second mouseclick Y, and the x is the same. The rook are moving upwards or downwards the y
                if(start.getY() < end.getY()) { //is start less than end (higher on the board)
                    //Iterate through spotarray to find out if there is pieces on the

                    for (int y = start.getY() + 1; y <= end.getY(); y++) //count array down the chessboard from start y + 1
                        return !b.spotArray[y][start.getX()].isOccupied;
                }

                if(start.getY()>end.getY()){ //If start y is bigger than end y
                    for (int y = start.getY()-1; y >= end.getY(); y--) { //count array downwards
                        if (b.spotArray[y][start.getX()].isOccupied) {
                            this.obstacles = true;
                            return false;
                        }
                        if(!b.spotArray[y][start.getX()].isOccupied){
                            return true;
                        }
                    }
                }
            }

            if (start.getX() != end.getX() && start.getY() == end.getY()) {

                 int diffWithSignsX = abs(start.getX() + end.getX()) / (start.getX() + end.getX());

                 if(start.getX() > end.getX()) { //if the start x is to the right of end x
                     for (int x = start.getX() -1; x >= end.getX(); x--) { //count the array downwards from the square next to start x to the end x.
                         System.out.println("before the x loop " + diffWithSignsX);
                         if (b.spotArray[start.getY()][x].isOccupied) {
                             this.obstacles = true;
                             return false;
                         }
                         if(!b.spotArray[start.getY()][x].isOccupied){
                             return true;
                         }
                     }
                 }

                 if (start.getX() < end.getX()){ //if the start x is less than the end (to the left for end)
                     for (int x = start.getX() + 1; x <= end.getX(); x++) { //Count array upwards to end x to see if any obstacles
                         if (b.spotArray[start.getY()][x].isOccupied) {

                             return false;
                         }
                     }
                 }
                return !obstacles;
            }
            return false;
        }
    }

// public boolean checkObs (Spot start, Spot end, boolean obstacles){
//             //methods for returning if obstacles are not true. we check if the end piece is a different color.
//             if (!obstacles) {
//                 try {
//                     if (start.piece.getWhite() != end.piece.getWhite()) {
//                         System.out.println("1 i'm returning true");
//                         return true;
//                     }
//                 } catch (NullPointerException e) {
//                     System.out.println(e.getMessage());
//                     return true;
//                 }
//             }
//             //method for returning false if there are obstacles.
//             if (this.obstacles) {
//                 System.out.println("1:  it's true since obstacles " + obstacles);
//                 this.obstacles = false;
//                 return false;
//             }
//             return false;
//         }
// }

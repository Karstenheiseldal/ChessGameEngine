package com.company;

public class Rook extends Piece {

    public Rook(boolean white) { //Rook constructor
        super(white); //inherited boolean
    }

    @Override
    public boolean legalMoveCheck(Spot start, Spot end, Boardgrid b) { //Method to check if a move is legal or not
        /*
        first check weather it is moving on the y-axis or x-axis. then if it's moving
        up, down, left or right.
        then loop through the spots between the start spot and end spot and check if occupied.
         */
        if (start.getY() != end.getY() && start.getX() == end.getX()) {
            //is start y is higher and end y
            if (start.getY() < end.getY()) {
                //count array upwards between the start and end position
                for (int y = start.getY() + 1; y < end.getY(); y++) {
                    //if a spot is occupied, the obstacles boolean is set to true.
                    if (b.spotArray[y][start.getX()].isOccupied) {
                        this.obstacles = true;
                        break;
                    }
                }
                return checkObstacles(start, end, this.obstacles);
            }
            //If start y is below the end y
            if (start.getY() > end.getY()) {
                //count array downwards between the start and end position
                for (int y = start.getY() - 1; y > end.getY(); y--) {
                    //if a spot is occupied, the obstacles boolean is set to true.
                    if (b.spotArray[y][start.getX()].isOccupied) {
                        this.obstacles = true;
                        break;
                    }
                }
                return checkObstacles(start, end, this.obstacles);
            }
        }
        if (start.getX() != end.getX() && start.getY() == end.getY()) {
            //if the start x is to the right of end x
            if (start.getX() > end.getX()) {
                //Count array downwards between the start and end position.
                for (int x = start.getX() - 1; x > end.getX(); x--) {
                    //if a spot is occupied, the obstacles boolean is set to true.
                    if (b.spotArray[start.getY()][x].isOccupied) {
                        this.obstacles = true;
                        break;
                    }
                }
                return checkObstacles(start, end, this.obstacles);
            }
            //if the start x is left of the end x
            if (start.getX() < end.getX()) {
                //Count array upwards between the start and end position
                for (int x = start.getX() + 1; x < end.getX(); x++) {
                    //If a spot is occupied, the obstacles boolean is set to true.
                    if (b.spotArray[start.getY()][x].isOccupied) {
                        this.obstacles = true;
                        break;
                    }
                }
                return checkObstacles(start, end, this.obstacles);
            }
        }
        return false;
    }
}
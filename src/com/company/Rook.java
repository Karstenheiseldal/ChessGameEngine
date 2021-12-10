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
            if (start.getY() < end.getY()) { //is start less than end (higher on the board)
                //Iterate through spotArray to find out if there is pieces on the trajectory

                for (int y = start.getY() + 1; y < end.getY(); y++) { //count array down the chessboard from start y + 1
                    //if a spot is occupied, the obstacles boolean is set to true, and we return the checkObstacles method.
                    if (b.spotArray[y][start.getX()].isOccupied) {
                        this.obstacles = true;
                        break;
                    }
                }
                return checkObstacles(start, end, this.obstacles);
            }

            if (start.getY() > end.getY()) { //If start y is bigger than end y
                for (int y = start.getY() - 1; y > end.getY(); y--) { //count array downwards
                    //if a spot is occupied, the obstacles boolean is set to true, and we return the checkObstacles method.
                    if (b.spotArray[y][start.getX()].isOccupied) {
                        this.obstacles = true;
                        break;
                    }
                }
                return checkObstacles(start, end, this.obstacles);
            }
        }

        if (start.getX() != end.getX() && start.getY() == end.getY()) {

            if (start.getX() > end.getX()) { //if the start x is to the right of end x
                for (int x = start.getX() - 1; x > end.getX(); x--) { //count the array downwards from the square next to start x to the end x.
                    //if a spot is occupied, the obstacles boolean is set to true, and we return the checkObstacles method.
                    if (b.spotArray[start.getY()][x].isOccupied) {
                        this.obstacles = true;
                        break;
                    }
                }
                return checkObstacles(start, end, this.obstacles);
            }

            if (start.getX() < end.getX()) { //if the start x is less than the end (to the left for end)
                for (int x = start.getX() + 1; x < end.getX(); x++) { //Count array upwards to end x to see if any obstacles
                    //If a spot is occupied, the obstacles boolean is set to true, and we return the checkObstacles method.
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

package com.company;

import java.util.ArrayList;
public class Move {
    Player player;
    String movingPieceName;
    Piece movingPiece;
    Spot start;
    Spot end;
    Boardgrid myBoard;
    boolean illegal = false;
    /*
    Constructor of a move
     */
    public Move(Boardgrid myBoard, Player player, Spot start, Spot end) {
        this.player = player;
        this.start = start;
        this.end = end;
        this.movingPiece = start.getPiece();
        this.myBoard = myBoard;
        this.movingPieceName = start.getPieceName();
    }
    /*
    This checks if the moving piece is making a legal move
    and if it is, then will move the piece, kill of captured pieces
    and make sure castling is happening correctly.
     */
    public void makeMove() {
        //Checking if the move is legal
        if (movingPiece.legalMoveCheck(start, end, myBoard)) {
            //If the moving piece is moving to a spot that isn't it's own.
            //and if the moving piece is the same color as the moving player.
            if (this.end.piece != this.start.piece && this.player.white == this.start.piece.getWhite()) {
                /*
                If the moving piece is a king and castling is happening
                the king will either move two right or left
                and then the rook in same side will move on the opposite site of the king.
                 */
                if(this.start.piece.castle){
                    if(start.getX() < end.getX()){
                        this.myBoard.spotArray[start.getY()][start.getX() +2].setPiece(start.getPiece());
                        this.myBoard.spotArray[start.getY()][start.getX()+1].setPiece(myBoard.spotArray[start.getY()][start.getX()+3].getPiece());
                        this.myBoard.spotArray[start.getY()][start.getX()+3].piece=null;
                        this.start.piece.castle = false;
                    }
                    else{
                        this.myBoard.spotArray[start.getY()][2].setPiece(start.getPiece());
                        this.myBoard.spotArray[start.getY()][3].setPiece(myBoard.spotArray[start.getY()][start.getX()-4].getPiece());
                        this.myBoard.spotArray[start.getY()][start.getX()-4].piece=null;
                        this.start.piece.castle = false;
                    }
                }
                //If the king is captured, the game will end
                if (end.isOccupied && end.getPieceName().equals("King")) {
                    System.out.println("Game over");
                    System.exit(0);
                }
                //if a moving piece is moving to an occupied spot
                //the piece will be captured and killed.
                if (end.isOccupied) {
                    this.end.piece.setKilled(true);
                }
                //Moving piece will be located at a new position and removed from the starting position
                this.end.piece = this.start.piece;
                this.end.piece.hasMoved = true;
                this.start.piece = null;

                //the isOccupied boolean will be changed.
                System.out.println("Legal move");
                this.movingPiece.hasMoved = true;
                this.end.setOccupied(true);
                this.start.setOccupied(false);
            }
            // if neither of the above is true, the move is illigal
        } else {
            System.out.println("Illegal move");
            this.illegal = true;
        }
    }
}

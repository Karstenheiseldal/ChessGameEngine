package com.company;

public class Move {
    Player player;
    String movingPieceName;
    Piece movingPiece;
    Spot start;
    Spot end;
    Boardgrid myBoard;


    public Move(Boardgrid myBoard, Player player, Spot start, Spot end) {
        this.player = player;
        this.start = start;
        this.end = end;
        this.movingPiece = start.getPiece();
        this.myBoard = myBoard;
        this.movingPieceName = start.getPieceName();
    }

    public void makeMove() {
        if (movingPiece.legalMoveCheck(start,end, myBoard)) {
            if (this.end.piece != this.start.piece && this.player.white == this.start.piece.getWhite()) {

                    if (end.isOccupied && end.getPieceName().equals("King")){
                        System.out.println("Game over");
                        System.exit(0);
                    }
                    this.end.piece = this.start.piece;
                    this.end.piece.hasMoved = true;
                    this.start.piece = null;

                    System.out.println("Legal move");
                    this.movingPiece.hasMoved = true;
                    this.end.setOccupied(true);
                    this.start.setOccupied(false);

            }
            else System.out.println("Illegal move");

        } else {
            System.out.println("illegal move!");
        }
    }
    public boolean oppositeColor (Spot start, Spot end){
        return start.piece.getWhite() != end.piece.getWhite();
    }
}
package com.company;

public class Spot{
/*
The spot class holds information about the individual spots on the board
Each spot is constructed with information about:
the x- and y-coordinate
If the spot is occupied
which piece occupies it
and has setters and getters for each of these informations.

 */
    public Piece piece;
    boolean isOccupied;
    int y;
    int x;

    public Spot(int y, int x, Piece piece) {
        this.setPiece(piece);
        this.setX(x);
        this.setY(y);
        }
    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }
    public void setPiece(Piece p){
        this.piece = p;
    }
    public String getPieceName (){
        return this.piece.getClass().getSimpleName();
    }
    public Piece getPiece(){
        return this.piece;
    }

    public void setX(int x){
        this.x = x;}
    public void setY(int y){
        this.y = y;}

    public int getX(){
        return this.x;
    }
    public int getY() {
        return this.y;
    }
}

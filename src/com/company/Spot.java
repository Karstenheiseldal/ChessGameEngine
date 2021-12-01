package com.company;

public class Spot{

    public Piece piece;
    int x;
    int y;

    boolean isOccupied;

    public Spot(int x, int y, Piece piece)
    {
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
    public int getY(){ return this.y;}

    }

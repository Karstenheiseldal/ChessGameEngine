package com.company;

public class Spot{
int x;
int y;
int[][] arr;
boolean isOccupied;

    public Spot(int x, int y){
        this.isOccupied = false;
        }

    public void setX(int x){
        this.x = x;
        }
    public void setY(int y){
        this.y = y;
        }

    public int getX(){
        return this.x;
    }
    public int getY(){ return this.y;}
    }

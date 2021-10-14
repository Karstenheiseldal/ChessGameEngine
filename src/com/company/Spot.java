package com.company;

import java.util.ArrayList;
import java.util.List;

public class Spot{
int x;
int y;
List[][] array = new ArrayList;

boolean isOccupied;

    public Spot(int x, int y)
    {
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

package com.codecool.com.codecool.ants;

import com.codecool.Colony;

import java.util.Random;

public class Queen extends Ants{
    private int matingPause = 0;
    private Colony colony;


    public Queen(int x, int y) {
        super(x, y);
    }

    @Override
    public void oneMove() {
        System.out.println("Im sitting in the origo.");
    }

    @Override
    public boolean attackMove(Wasp wasp) {
        return false;
    }

    public int getMatingPause() {
        return matingPause;
    }

    public void setMatingPause(int matingPause) {
        this.matingPause = matingPause;
    }

    public Colony getColony() {
        return colony;
    }

    public void setColony(Colony colony) {
        this.colony = colony;
    }
}

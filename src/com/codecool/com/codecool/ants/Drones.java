package com.codecool.com.codecool.ants;

import com.codecool.Colony;

public class Drones extends Ants {
    private Colony colony;
    int counter = 0;
    int percentage = 50;

    public Drones(int x, int y) {
        super(x, y);
    }

    @Override
    public void oneMove() {
        this.oneMoveToTheQueen();
    }

    @Override
    public boolean attackMove(Wasp wasp) {
        return false;
    }

    public boolean getDestinyWhenItTreeStepsFromQueen() {
        startUnMatingMood();
        if (counter == 0) {
            oneMove();
            getMatingOrKicked();
        } else if (counter != 10) {
            System.out.println("HALELUJAHH");
            counter++;
        } else {
            giveNewPositionForDrones();
            counter = 0;
            return true;
        }
        return false;
    }

    public void startUnMatingMood() {
        if (colony.getQueenMatingPause() != 0) {
            percentage = 0;
            this.colony.isTheQueenMating(percentage);
        } else {
            percentage = 50;
        }
    }

    public void getMatingOrKicked() {
        if (distanceFromTheQueen() <= 3) {
            if (this.colony.isTheQueenMating(percentage)) {
                System.out.println("HALELUJAHH");
                counter = 1;
            } else {
                System.out.println("D'OH");
                giveNewPositionForDrones();
            }
        }
    }

    public void setColony(Colony colony) {
        this.colony = colony;
    }
}


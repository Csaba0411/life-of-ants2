package com.codecool.com.codecool.ants;

import com.codecool.Colony;
import com.codecool.Direction;

import java.util.Random;

import static com.codecool.Direction.moveToTheWaspDirection;

public abstract class Ants {

    private int x;
    private int y;
    private Colony colony;

    Ants(int x, int y) {
        this.x = x;
        this.y = y;
    }

    protected void move(Direction direction) {
        int newX = x + direction.getXd();
        int newY = y + direction.getYd();
        this.x = newX;
        this.y = newY;
    }

    public abstract void oneMove();
    public abstract boolean attackMove(Wasp wasp);

    protected int distanceFromTheQueen() {
        return Math.abs(x) + Math.abs(y);
    }

    protected void oneMoveToTheQueen() {
        Direction dir = Direction.moveToQueen(x, y);
        x += dir.getXd();
        y += dir.getYd();
    }

    protected void oneMoveToTheWasp(Wasp wasp) {
        Direction dir = moveToTheWaspDirection(x, y, wasp);
        x += dir.getXd();
        y += dir.getYd();
    }

    protected boolean checkPositionOfSoldiersAndWasp(Wasp wasp) {
        if (this.x == wasp.getX() && this.y == wasp.getY()) {
            return true;
        } else {
            return false;
        }
    }


    protected void giveNewPositionForDrones() {
        Random random = new Random();
        x = random.nextInt(100);
        y = 100 - x;
    }

    @Override
    public String toString() {
        return String.format("%s(%d, %d)", this.getClass().getSimpleName(), x, y);
    }
}
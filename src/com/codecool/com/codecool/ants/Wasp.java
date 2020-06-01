package com.codecool.com.codecool.ants;

import java.util.Random;

public class Wasp {
    private static int range = 150;
    private int x;
    private int y;

    Wasp(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static int generatePosition(int range, int distanceFromTheQueen) {
        int coordinate = 0;
        Random random = new Random();
        do {coordinate = random.nextInt(range/2 + range/2) - range/2;}
        while(coordinate > -distanceFromTheQueen && coordinate < distanceFromTheQueen);
        return coordinate;
    }

    public static Wasp createWasp() {
        Wasp wasp = new Wasp(generatePosition(range, 1), generatePosition(range, 1));
        return wasp;
    }

    public void giveNewPosition() {
        this.setX(generatePosition(range, 1));
        this.setY(generatePosition(range, 1));
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String toString() {
        return String.format("Wasp(%d,%d)", x, y);
    }
}

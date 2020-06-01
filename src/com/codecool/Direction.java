package com.codecool;

import com.codecool.com.codecool.ants.Wasp;

public enum Direction {
    NORTH(0, 1),
    EAST(1, 0),
    SOUTH(0, -1),
    WEST(-1, 0);

    private final int xd;
    private final int yd;

    Direction(int xd, int yd) {
        this.xd = xd;
        this.yd = yd;
    }

    public static Direction getRandomDirection() {
        int random = (int) (Math.random() * Direction.values().length);
        return Direction.values()[random];
    }

    public static Direction turnRight(Direction direction) {
        if (direction.ordinal() != 3) {
            return direction.values()[direction.ordinal()+1];
        }
        return direction.values()[0];
    }


    public static Direction moveToQueen(int x, int y) {
        if (Math.abs(x) > Math.abs(y)) {
            return x > 0 ? Direction.WEST : Direction.EAST;
        } else {
            return y > 0 ? Direction.SOUTH : Direction.NORTH;
        }
    }

    public static Direction moveToTheWaspDirection(int x, int y, Wasp wasp) {
        if (Math.abs(x-wasp.getX()) > Math.abs(y-wasp.getY())) {
            return x > wasp.getX() ? Direction.WEST : Direction.EAST;
        } else  {
            return y > wasp.getY() ? Direction.SOUTH : Direction.NORTH;
        }
    }

    public int getXd() {
        return xd;
    }

    public int getYd() {
        return yd;
    }
}

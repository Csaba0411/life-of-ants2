package com.codecool.com.codecool.ants;

import com.codecool.Direction;

public class Soldiers extends Ants{
    Direction soldierDirection = Direction.NORTH;

    public Soldiers(int x, int y) {
        super(x, y);
    }

    @Override
    public void oneMove() {
        soldierDirection = Direction.turnRight(soldierDirection);
        move(soldierDirection);
    }

    @Override
    public boolean attackMove(Wasp wasp) {
        this.oneMoveToTheWasp(wasp);
        return this.checkPositionOfSoldiersAndWasp(wasp);
    }


}

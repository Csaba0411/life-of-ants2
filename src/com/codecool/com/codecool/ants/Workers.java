package com.codecool.com.codecool.ants;

import com.codecool.Direction;

public class Workers extends Ants{


    public Workers(int x, int y) {
        super(x, y);
    }

    @Override
    public void oneMove() {
        move(Direction.getRandomDirection());
    }

    @Override
    public boolean attackMove(Wasp wasp) {
        return false;
    }
}

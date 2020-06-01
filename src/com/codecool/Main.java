package com.codecool;

import com.codecool.com.codecool.ants.Ants;
import com.codecool.com.codecool.ants.Drones;
import com.codecool.com.codecool.ants.Wasp;

import static com.codecool.com.codecool.ants.Wasp.createWasp;

public class Main {
    private static int hours = 100;


    public static void simulateTime(Colony colony, Wasp wasp) {
        boolean waspDeath = false;
        for (int time = 0; time < hours; time++) {
            if (wasp.getX() > - colony.getGridRange()/2 && wasp.getX() < colony.getGridRange()/2 &&
                    wasp.getY() > -colony.getGridRange()/2 && wasp.getY() < colony.getGridRange()/2) {
                System.out.println("hello");
                waspDeath = colony.attackMove(wasp);
                System.out.println("waspdeath"+waspDeath);
                if (waspDeath) {
                    wasp.giveNewPosition();
                }
            } else {
                System.out.println("szia");
                wasp.giveNewPosition();
                colony.oneMoveOfTheWholeColony();
            }
            System.out.println(colony.toString());
            System.out.println(wasp.toString());
        }

    }
    public static void main(String[] args) {
        Colony colony = new Colony();
        colony.createColony();
        Wasp wasp = createWasp();
        simulateTime(colony, wasp);

    }
}

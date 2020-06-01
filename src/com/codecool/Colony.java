package com.codecool;

import com.codecool.com.codecool.ants.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Colony {
    private List<Ants> antsInColony = new ArrayList<>();
    private  final int gridRange = 100;
    private final int workerNumber = 1;
    private final int soldierNumber = 4;
    private final int droneNumber = 2;
    private Queen queen;

    private int generateNumberInRange(int minDistanceFromQueen) {
        Random random = new Random();
        int number = 0;
        do {number = random.nextInt(gridRange/2 + gridRange/2) - gridRange/2;}
        while ( number >= (- minDistanceFromQueen) && number <= minDistanceFromQueen);
        return number;
    }

    private void addAnts(Ants ant) {
        antsInColony.add(ant);
    }

    private Queen addQueenToColony(Queen queen) {
        if (queen == null) {
            queen = new Queen(0, 0);
            this.queen = queen;
            antsInColony.add(queen);
        }
            return queen;
    }

    public void createColony() {
        addQueenToColony(queen);
        queen.setColony(this);
        for (int i = 0; i < workerNumber; i++) {
            Workers workers = new Workers(generateNumberInRange(2), generateNumberInRange(2));
            addAnts(workers);
        }
        for (int i = 0; i < soldierNumber; i++) {
            Soldiers soldiers = new Soldiers(generateNumberInRange(2), generateNumberInRange(2));
            addAnts(soldiers);
        }
        for (int i = 0; i < droneNumber; i++) {
            Drones drones = new Drones(generateNumberInRange(1), generateNumberInRange(1));
            drones.setColony(this);
            addAnts(drones);
        }

    }

    public boolean isTheQueenMating(int percentage){
        Random random = new Random();
        if (random.nextInt(100) < percentage) {
            return true;
        }
        return false;
    }


    public void oneMoveOfTheWholeColony() {
        if (queen.getMatingPause() != 0) {
            queen.setMatingPause(queen.getMatingPause()+1);
        }
        if (queen.getMatingPause() == 20) {
            queen.setMatingPause(0);
        }
        for (Ants ant: antsInColony) {
            if (ant instanceof Drones) {
                boolean isTheQueenInMatingMood = ((Drones) ant).getDestinyWhenItTreeStepsFromQueen();
                System.out.println(isTheQueenInMatingMood);
               if (isTheQueenInMatingMood) {queen.setMatingPause(1);}
            } else {
                ant.oneMove();
            }
        }
    }

    public int getQueenMatingPause(){
        return queen.getMatingPause();
    }

    public int getGridRange() {
        return gridRange;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Ants ants: antsInColony) {
            sb.append(" ").append(ants.toString()).append("\n");
        }
        return sb.toString();
    }

    public boolean attackMove(Wasp wasp) {
        boolean waspDeath = false;
        for (Ants soldier: antsInColony) {
             waspDeath = soldier.attackMove(wasp);
            if (waspDeath) {
                return true;
            }
        } return false;
    }
}
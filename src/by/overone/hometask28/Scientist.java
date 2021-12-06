package by.overone.hometask28;

import java.util.*;

public class Scientist implements Runnable {
    HashMap<RobotParts, Integer> partsInLaboratory;
    private Dump dump;
    private Random random = new Random();
    private int countOfRobots;
    private int day = 1;


    @Override
    public void run() {
        while (day <= 50) {
            removeToLaboratory(randomArrayCountOfParts(random.nextInt(4) + 1));
            countOfRobots += assemblingRobot();
            System.out.println("Laboratory days - " + day);
            System.out.println("Robots assembled - " + countOfRobots);
            System.out.println("Laboratory warehouse - " + this.partsInLaboratory);
            day++;
        }
    }

    Scientist(Dump dump) {
        partsInLaboratory = new HashMap<>();
        this.dump = dump;
        countOfRobots = 0;
        removeToLaboratory(randomArrayCountOfParts(random.nextInt(4) + 1));

        System.out.println("Laboratory warehouse - " + this.partsInLaboratory);
    }

    private void removeToLaboratory(int[] resetCount) {
        HashMap<RobotParts, Integer> robotPartsHashMap = new HashMap<>();
        int counter = 0;
        for (RobotParts robotParts : RobotParts.values()) {
            if (resetCount[counter] > 0) {
                robotPartsHashMap.put(robotParts, resetCount[counter]);
            }
            counter++;
        }
        while (!dump.removeDetails(robotPartsHashMap)) {
            System.err.println("Do not add parts from factory to dump");
        }

        for (RobotParts robotParts : robotPartsHashMap.keySet()) {
            if (partsInLaboratory.containsKey(robotParts)) {
                partsInLaboratory.put(robotParts, partsInLaboratory.get(robotParts)
                        + robotPartsHashMap.get(robotParts));
            } else {
                partsInLaboratory.put(robotParts, robotPartsHashMap.get(robotParts));
            }
        }
    }

    private int assemblingRobot() {
        int assembleCount = 0;
        if (!partsInLaboratory.isEmpty()) {
            Collection<Integer> countOfPart = partsInLaboratory.values();
            assembleCount = Collections.min(countOfPart);

            if (assembleCount != 0) {
                for (RobotParts part : partsInLaboratory.keySet()) {
                    if (partsInLaboratory.containsKey(part)) {
                        partsInLaboratory.put(part, partsInLaboratory.get(part) - assembleCount);
                    }

                }
            }
        }

        System.out.println("Scientist assemble " + assembleCount + " robots");
        return assembleCount;
    }

    private int[] randomArrayCountOfParts(int count) {
        int[] arrayCountOfParts = {0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 1; i <= count; i++) {
            int randomCount = this.random.nextInt(9);
            arrayCountOfParts[randomCount] += 1;
        }
        return arrayCountOfParts;
    }
}

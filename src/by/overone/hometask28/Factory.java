package by.overone.hometask28;

import java.util.HashMap;
import java.util.Random;

public class Factory implements Runnable {
    private Dump dump;
    private Random random = new Random();
    private int day = 1;

    @Override
    public void run() {
        while (day <= 50){
            System.out.println("Factory days - " + day);
            addToDump(randomArrayCountOfParts(random.nextInt(4) + 1));
            System.out.println("Landfill after dumping" + dump.getParts());
            day++;
        }
    }

    Factory(Dump dump) {
        this.dump = dump;
        addToDump(randomArrayCountOfParts(20));

        System.out.println("Landfill after dumping" + dump.getParts());
    }

    private void addToDump(int[] resetCount) {
        HashMap<RobotParts, Integer> robotPartsHashMap = new HashMap<>();
        int counter = 0;
        for (RobotParts robotParts : RobotParts.values()) {
            if (resetCount[counter] > 0) {
                robotPartsHashMap.put(robotParts, resetCount[counter]);
            }
            counter++;
        }

        while (!dump.addDetails(robotPartsHashMap)) {
            System.err.println("Do not add parts from factory to dump");
        }
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

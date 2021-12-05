package by.overone.hometask28;

import java.util.HashMap;

public class Dump {
    private HashMap<RobotParts, Integer> parts;
    private boolean flagWhoWorks = true;
    //true - works factory, false - works scientist

    public Dump() {
        parts = new HashMap<>();
    }

    public HashMap<RobotParts, Integer> getParts() {
        return parts;
    }

    public synchronized boolean addDetails(HashMap<RobotParts, Integer> robotPartsHashMap) {
        if (!flagWhoWorks) {//true - works factory, false - works scientist
            return false;
        }
        if (robotPartsHashMap.isEmpty()) {
            return false;
        }
        synchronized (parts) {
            int counter = 0;
            for (RobotParts robotParts : robotPartsHashMap.keySet()) {
                if (parts.containsKey(robotParts)) {
                    parts.put(robotParts, parts.get(robotParts) + robotPartsHashMap.get(robotParts));
                } else {
                    parts.put(robotParts, robotPartsHashMap.get(robotParts));
                }
                counter += robotPartsHashMap.get(robotParts);
            }
            System.out.println("The factory is added " + counter + " details");
            flagWhoWorks = false;
        }
        return true;
    }

    public synchronized boolean removeDetails(HashMap<RobotParts, Integer> robotPartsHashMap) {
        if (flagWhoWorks) {//true - works factory, false - works scientist
            return false;
        }
        if (robotPartsHashMap.isEmpty()) {
            return false;
        }

        synchronized (parts) {
            int countOfParts;
            int counter = 0;

            for (RobotParts robotParts : robotPartsHashMap.keySet()) {
                if (parts.containsKey(robotParts)) {
                    if (parts.get(robotParts) >= (countOfParts = robotPartsHashMap.get(robotParts))) {
                        parts.put(robotParts, parts.get(robotParts) - countOfParts);
                        counter += countOfParts;
                    } else {
                        parts.put(robotParts, 0);
                        counter += countOfParts;
                    }
                }
            }
            System.out.println("The acolyte took the " + counter + " details");
            flagWhoWorks = true;
        }
        return true;
    }
}

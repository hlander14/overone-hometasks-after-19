package by.overone.hometask22.exercise2;

import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MainMap {
    public static void main(String[] args) {
        HashMap<String, String> namesMap = new HashMap<>();

        namesMap.put("Marty", "Stepp");
        namesMap.put("Stallone", "Silvester");
        namesMap.put("Miller", "Jessica");
        namesMap.put("Clain", "Calvin");
        namesMap.put("Stone", "John");

        System.out.println(namesMap);
        System.out.println(isUnique(namesMap));

        namesMap.put("Shimon", "Jessica");
        System.out.println(namesMap);
        System.out.println(isUnique(namesMap));
    }

    public static boolean isUnique(Map<String, String> map) {
        int counter = 0;
        String[] nameArray = new String[map.size()];
        for (String surnameO : map.keySet()) {
            nameArray[counter] = (String) map.get(surnameO);
            counter++;
        }

        for (int i = 0; i < nameArray.length; i++) {
            for (int j = i + 1; j < nameArray.length; j++) {
                if (nameArray[i] == nameArray[j]) {
                    return false;
                }
            }
        }
        return true;
    }
}

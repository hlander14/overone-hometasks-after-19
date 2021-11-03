package by.overone.hometask21.exercise1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class MainSortInt {
    public static void main(String[] args) {
        ArrayList<Integer> integerArrayList = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            integerArrayList.add(random.nextInt(6) - 1);
        }

        System.out.println(integerArrayList);
        System.out.println(countUnique(integerArrayList));
    }

    public static int countUnique (ArrayList<Integer> arrayList) {
        if (arrayList.isEmpty()) {
            return 0;
        }
        HashSet<Integer> integerHashSet = new HashSet<>(arrayList);
        return integerHashSet.size();
    }
}

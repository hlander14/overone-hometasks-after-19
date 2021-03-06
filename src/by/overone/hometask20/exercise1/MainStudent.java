package by.overone.hometask20.exercise1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Random;

public class MainStudent {
    public static void main(String[] args) {
        ArrayList<Integer> evaluations = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 20; i++) {
            evaluations.add(random.nextInt(10));
        }
        System.out.println(evaluations);

        ListIterator<Integer> iterator = evaluations.listIterator();
        while (iterator.hasNext()) {
            Integer evaluation = iterator.next();
            if (evaluation < 4) {
                iterator.remove();
            }
        }
        System.out.println(evaluations);
    }
}

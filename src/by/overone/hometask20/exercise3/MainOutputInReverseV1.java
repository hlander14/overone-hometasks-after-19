package by.overone.hometask20.exercise3;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Random;

public class MainOutputInReverseV1 {
    public static void main(String[] args) {
        ArrayList<Integer> evaluations = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i <20; i++) {
            evaluations.add(random.nextInt(10));
        }
        System.out.println(evaluations);

        ListIterator<Integer> iterator = evaluations.listIterator(evaluations.size());
        while (iterator.hasPrevious()) {
            System.out.print(iterator.previous() + ", ");
        }
    }
}

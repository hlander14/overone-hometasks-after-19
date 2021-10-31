package by.overone.hometask20.exercise3;

import java.util.ArrayList;
import java.util.Random;

public class MainOutputReverseV2 {
    public static void main(String[] args) {
        ArrayList<Integer> evaluations = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i <20; i++) {
            evaluations.add(random.nextInt(10));
        }
        System.out.println(evaluations);

        Object[] evaluationsInString = evaluations.toArray();
        for (int i = evaluationsInString.length - 1; i >= 0; i--) {
            System.out.print(evaluationsInString[i] + ", ");
        }
    }
}

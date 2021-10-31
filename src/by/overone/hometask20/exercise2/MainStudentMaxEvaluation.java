package by.overone.hometask20.exercise2;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Random;

public class MainStudentMaxEvaluation {
    public static void main(String[] args) {
        ArrayList<Integer> evaluations = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i <20; i++) {
            evaluations.add(random.nextInt(10));
        }
        System.out.println(evaluations);

        ListIterator<Integer> iterator = evaluations.listIterator();
        Integer maxEvaluation = 0;
        while (iterator.hasNext()) {
            Integer tempEvaluation = iterator.next();
            if (maxEvaluation < tempEvaluation) {
                maxEvaluation = tempEvaluation;
            }
        }
        System.out.println("Maximum rating a " + maxEvaluation);
    }
}

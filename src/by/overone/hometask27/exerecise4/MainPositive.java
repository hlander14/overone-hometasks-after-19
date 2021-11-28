package by.overone.hometask27.exerecise4;

import java.util.Arrays;
import java.util.Random;
import java.util.function.Predicate;

public class MainPositive {
    public static void main(String[] args) {
        Predicate<Integer> integerPredicate = x -> x > 0;

        int[] intArray = new int[20];
        Random random = new Random();
        System.out.print("Positive number is : ");
        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = random.nextInt(100) - 50;
            if (integerPredicate.test(intArray[i])) {
                System.out.print(intArray[i] + " ");
            }
        }

        System.out.println("\n Array is : " + Arrays.toString(intArray));

    }
}

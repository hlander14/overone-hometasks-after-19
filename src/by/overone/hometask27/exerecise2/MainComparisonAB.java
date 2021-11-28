package by.overone.hometask27.exerecise2;

import java.util.function.BinaryOperator;

public class MainComparisonAB {
    public static void main(String[] args) {
        int number1 = 7;
        int number2 = 15;

        BinaryOperator<Integer> comparisonNumbers = (a, b) -> {
            if (a < b) {
                return a;
            } else if (a > b) {
                return b;
            }
            return 0;
        };

        System.out.println(comparisonNumbers.apply(number1, number2));
    }
}

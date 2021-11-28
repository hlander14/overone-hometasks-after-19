package by.overone.hometask27.exerecise5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class MainSquareNumbers {
    public static void main(String[] args) {
        UnaryOperator<Integer> getSquare = x -> x * x;
        int[] intArray = {3, 5, 8, -5, -11000, 55, 0};
        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = getSquare.apply(intArray[i]);
        }
        System.out.println(Arrays.toString(intArray));

        BinaryOperator<String> binaryOperator = (string1, string2) -> string1 + " " + string2;
        List<String> stringList = new ArrayList<>();
        stringList.add("My");
        stringList.add("name");
        stringList.add("is");
        stringList.add("");
        stringList.add("Andrei");
        stringList.add("Glaz");
        for (int i = 0; i < stringList.size() - 1; i++) {
            System.out.println(binaryOperator.apply(stringList.get(i), stringList.get(i + 1)));
        }
    }
}

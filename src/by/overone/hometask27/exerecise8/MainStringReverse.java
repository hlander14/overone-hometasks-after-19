package by.overone.hometask27.exerecise8;

import java.util.Scanner;
import java.util.function.Supplier;

public class MainStringReverse {
    public static void main(String[] args) {
        Supplier<String> stringSupplier = () -> {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter your line");
            char[] charLine = scanner.nextLine().toCharArray();

            if (charLine.length >= 2) {
                StringBuilder stringBuilder = new StringBuilder();
                for (int i = charLine.length - 1; i >= 0; i--) {
                    stringBuilder.append(charLine[i]);
                }
                return stringBuilder.toString();
            } else {
                return "The length of the string must be greater than 2";
            }
        };

        System.out.println(stringSupplier.get());
    }
}

package by.overone.hometask27.exerecise7;

import java.util.Locale;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;

public class MainHowMuchDollarsConsumer {
    public static void main(String[] args) {
        Consumer<String> converterToDollars = x -> {
            double exchangeBynUsd = 2.56;
            double exchangeEurUsd = 1.13;
            double exchangeYenUsd = 0.0088;
            String[] arrayOfString = x.split(" ");

            if (arrayOfString.length >= 2) {
                double number = -1.0;
                try {
                    number = Double.parseDouble(arrayOfString[0]);
                } catch (NumberFormatException exception) {
                    System.err.println("Incorrect number");
                }
                if (number >= 0) {
                    String currency = arrayOfString[1].toUpperCase(Locale.ROOT);
                    switch (currency) {
                        case "BYN":
                            System.out.println(number * exchangeBynUsd);
                            break;
                        case "EUR":
                            System.out.println(number * exchangeEurUsd);
                            break;
                        case "YEN":
                            System.out.println(number * exchangeYenUsd);
                            break;
                        case "USD":
                            System.out.println(number);
                            break;
                        default:
                            System.err.println("Incorrect currency");
                    }
                } else {
                    System.err.println("The entered number is negative");
                }
            } else {
                System.err.println("You are not enter a number and currency");
            }
        };

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number and currency:");
        String numberAndCurrency = scanner.nextLine();
        converterToDollars.accept(numberAndCurrency);
    }
}

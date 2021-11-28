package by.overone.hometask27.exerecise6;

import java.util.Locale;
import java.util.Scanner;
import java.util.function.Function;

public class MainHowMuchDollars {
    public static void main(String[] args) {
        Function<String, Double> converterToDollars = x -> {
            double exchangeBynUsd = 2.56;
            double exchangeEurUsd = 1.13;
            double exchangeYenUsd = 0.0088;
            String[] arrayOfString = x.split(" ");
            if (arrayOfString.length < 2) {
                return -1.0;
            }
            try {
                double number = Double.parseDouble(arrayOfString[0]);
                if (number < 0) {
                    throw new NumberFormatException();
                }
                String currency = arrayOfString[1].toUpperCase(Locale.ROOT);
                switch (currency) {
                    case "BYN":
                        return number * exchangeBynUsd;
                    case "EUR":
                        return number * exchangeEurUsd;
                    case "YEN":
                        return number * exchangeYenUsd;
                    case "USD":
                        return number;
                    default:
                        return -1.0;
                }
            } catch (NumberFormatException exception) {
                return -1.0;
            }
        };

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number and currency:");
        String numberAndCurrency = scanner.nextLine();
        double number;
        if ((number = converterToDollars.apply(numberAndCurrency)) != -1) {
            System.out.println("Amount in dollars: " + number);
        } else {
            System.err.println("Entered number or currency are incorrect");
        }
    }
}

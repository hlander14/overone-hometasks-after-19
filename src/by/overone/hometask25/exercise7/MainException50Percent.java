package by.overone.hometask25.exercise7;

import java.util.Random;

public class MainException50Percent {
    public static void main(String[] args) {
        try {
            methodException50Percent();
        } catch (ArithmeticException ex) {
            System.err.println("Method is stopped due to an arithmetic exception");
        } finally {
            System.out.println("This finally block of code will always run");
        }
    }

    public static void methodException50Percent() {
        Random random = new Random();
        int intRandom = random.nextInt(100) + 1;
        if (intRandom <= 50) {
            throw new ArithmeticException();
        }
    }
}

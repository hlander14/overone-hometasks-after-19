package by.overone.hometask25.exercise6;

import java.util.Random;

public class MainRandomException {
    public static void main(String[] args) {
        try {
            methodRandomException();
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

    public static void methodRandomException() {
        Random random = new Random();
        int choice = random.nextInt(3) + 1;

        switch (choice) {
            case 1:
                int a = 12 / 0;
                break;
            case 2:
                String str = null;
                str.length();
                break;
            case 3:
                int[] intArray = {1, 2, 3};
                int temp = intArray[127];
            default:
                System.out.println("WHAT???????");
        }
    }
}

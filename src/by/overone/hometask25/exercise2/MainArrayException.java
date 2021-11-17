package by.overone.hometask25.exercise2;

public class MainArrayException {
    public static void main(String[] args) {
        int[] intArray = {1, 2, 4, 8};

        try {
            int temp = intArray[9];
        } catch (ArrayIndexOutOfBoundsException exception) {
            System.err.println("Your index is out of range array");
        }
    }
}

package by.overone.hometask25.exercise1;

public class MainNullString {
    public static void main(String[] args) {
        String stringNull = null;

        try {
            stringNull.length();
        } catch (NullPointerException exception) {
            System.err.println("The value of variables not set!!!");
        }
    }
}

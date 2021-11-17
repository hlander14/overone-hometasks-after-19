package by.overone.hometask25.exercise5;

public class MainJDKExceptionsChangeForMy {
    public static void main(String[] args) throws MyException {
        int number1 = 5;
        int number2 = 0;
        int result = 0;

        try {
            result = number1 / number2;
        } catch (ArithmeticException ex) {
            throw new MyException("Division by ZERO", result);
        }
    }
}

class MyException extends Exception {
    private int number;

    public MyException(String message, int number) {
        super(message);
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}

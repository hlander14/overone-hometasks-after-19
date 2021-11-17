package by.overone.hometask25.exercise3;

public class MainNegativeIntegerException{
    public static void main(String[] args) {
        int firstNum = 5;
        int secondNum = -7;

        try {
            System.out.println(multiplePositiveNumber(firstNum, secondNum));
        } catch (NegativeIntegerException exception) {
            exception.printStackTrace();
        }
    }

    public static int multiplePositiveNumber (int number1, int number2) throws NegativeIntegerException {
        if (number1 < 0) {
            throw new NegativeIntegerException("First number is negative", number1);
        } else if (number2 < 0) {
            throw new NegativeIntegerException("Second number is negative", number2);
        }
        return number1 + number2;
    }
}

class NegativeIntegerException extends Exception {
    private int number;

    public NegativeIntegerException(String message, int number) {
        super(message);
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}


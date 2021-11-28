package by.overone.hometask27.exerecise1;

public class MainISquare {
    public static void main(String[] args) {
        IShape getRectangleArea = x -> x * x;
        IShape getCircleArea = x -> Math.PI * x * x /4;

        double rectangleRadius = 3.5;
        double rectangleArea = getRectangleArea.getSquare(rectangleRadius);
        System.out.println(rectangleArea);

        double circleDiameter = 41;
        double circleArea = getCircleArea.getSquare(circleDiameter);
        System.out.println(circleArea);
    }
}

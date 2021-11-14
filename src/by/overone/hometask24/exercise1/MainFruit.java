package by.overone.hometask24.exercise1;

public class MainFruit {
    public static void main(String[] args) {
        Fruit apple = new Fruit("Apple", 4);
        System.out.println(apple);
        System.out.println(apple.getSeeds().getAmount());
    }
}

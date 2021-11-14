package by.overone.hometask24.exercise3;

public class MainFruit3 {
    public static void main(String[] args) {
        Fruit3.Seeds numberOfSeedsInCherry = new Fruit3.Seeds(1);
        Fruit3 cherry = new Fruit3("Cherry");
        System.out.println(cherry);
        cherry.setSeeds(numberOfSeedsInCherry);
        System.out.println(cherry);
        System.out.println(cherry.seeds.getAmount());
    }
}

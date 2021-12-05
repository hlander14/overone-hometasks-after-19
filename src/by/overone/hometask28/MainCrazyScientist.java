package by.overone.hometask28;

public class MainCrazyScientist {
    public static void main(String[] args) throws InterruptedException {
        Dump dump = new Dump();

        Factory factory = new Factory(dump);
        Scientist scientist = new Scientist(dump);

        new Thread(factory).start();
        Thread.sleep(200);
        new Thread(scientist).start();
    }
}

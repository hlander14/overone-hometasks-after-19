package by.overone.hometask24.exercise3;

public class Fruit3 {
    private String name;
    protected Seeds seeds;

    static class Seeds {
        private int seeds;

        public int getAmount() {
            return seeds;
        }

        public Seeds(int seeds) {
            this.seeds = seeds;
        }

        public Seeds() {
        }

        public int getSeeds() {
            return seeds;
        }

        public void setSeeds(int seeds) {
            this.seeds = seeds;
        }

        @Override
        public String toString() {
            return "Seeds{" +
                    "seeds=" + seeds +
                    '}';
        }
    }

    public Fruit3(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Seeds getSeeds() {
        return seeds;
    }

    public void setSeeds(Seeds seeds) {
        this.seeds = seeds;
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "name='" + name + '\'' +
                ", seeds=" + seeds +
                '}';
    }
}

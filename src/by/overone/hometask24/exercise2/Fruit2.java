package by.overone.hometask24.exercise2;

public class Fruit2 {
    private String name;
    protected Seeds seeds;

    class Seeds {
        private int seeds;

        public int getAmount() {
            return seeds;
        }

        public Seeds(int seeds) {
            this.seeds = seeds;
        }

        public int getSeeds() {
            return seeds;
        }

        public void getSeeds(int seeds) {
            this.seeds = seeds;
        }

        @Override
        public String toString() {
            return "Seeds{" +
                    "seeds=" + seeds +
                    '}';
        }
    }

    public Fruit2(String name, int countOfSeeds) {
        this.name = name;
        this.seeds = new Seeds(countOfSeeds);
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

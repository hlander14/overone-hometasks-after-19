package by.overone.hometask22.exercise1;

import java.util.HashMap;

public class Garage {
    private HashMap<Car, Integer> listOfCars = new HashMap<>();

    public void addCarToTheGarage(Car car, Integer count) {
        if (!this.listOfCars.containsKey(car)) {
            this.listOfCars.put(car, count);
        }
    }

    public void carParking(Car car) {
        if (this.listOfCars.containsKey(car)) {
            int count = this.listOfCars.get(car) + 1;
            this.listOfCars.put(car, count);
        } else {
            this.listOfCars.put(car, 1);
        }
    }

    public void departureOfTheCar(Car car) {
        if (this.listOfCars.containsKey(car)) {
            int count = this.listOfCars.get(car);
            if (count > 0) {
                count = this.listOfCars.get(car) - 1;
                this.listOfCars.put(car, count);
            } else {
                System.out.println("The data on the remaining cars is not correct");
            }
        } else {
            this.listOfCars.put(car, 0);
        }
    }

    public Integer remainingCarsByType(Car car) {
        if (this.listOfCars.containsKey(car)) {
            return this.listOfCars.get(car);
        }
        return null;
    }

    public void showAll() {
        System.out.println("List of all cars");
        for (Car car : this.listOfCars.keySet()) {
            System.out.println(car.toString() + " => count is: " + this.listOfCars.get(car));
        }
    }
}

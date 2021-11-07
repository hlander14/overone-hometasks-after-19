package by.overone.hometask22.exercise1;

import java.util.ArrayList;
import java.util.Scanner;

public class MainGarage {
    public static void main(String[] args) {
        Garage garage = new Garage();

        PassengersCars vwPassatB62015 = new PassengersCars("Volkswagen", "Passat B6", 2015,
                "Red", "Manual", false);
        PassengersCars toyotaPrius2018 = new PassengersCars("Toyota", "Prius", 2018,
                "White", "Auto", false);
        PassengersCars teslaModelY2019 = new PassengersCars("Tesla", "Model 3", 2017,
                "Black", "Auto", true);

        garage.addCarToTheGarage(vwPassatB62015, 2);
        garage.addCarToTheGarage(toyotaPrius2018, 3);
        garage.addCarToTheGarage(teslaModelY2019, 5);

        garage.showAll();


        garage.carParking(teslaModelY2019);
        garage.carParking(toyotaPrius2018);
        garage.showAll();

        garage.departureOfTheCar(teslaModelY2019);
        garage.departureOfTheCar(teslaModelY2019);
        garage.departureOfTheCar(vwPassatB62015);
        garage.showAll();

        System.out.println("Count of 'Tesla Model 3' is " + garage.remainingCarsByType(teslaModelY2019));
    }
}

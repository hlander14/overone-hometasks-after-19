package by.overone.hometask22.exercise1;

import java.util.Objects;

public abstract class Car {
    private String carBrand;
    private String model;
    private int yearsOfRelease;
    private String color;
    private String gearShifting;
    private boolean fourWheelDrive;

    public Car(String carBrand, String model, int yearsOfRelease, String color, String gearShifting, boolean fourWheelDrive) {
        this.carBrand = carBrand;
        this.model = model;
        this.yearsOfRelease = yearsOfRelease;
        this.color = color;
        this.gearShifting = gearShifting;
        this.fourWheelDrive = fourWheelDrive;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public String getModel() {
        return model;
    }

    public int getYearsOfRelease() {
        return yearsOfRelease;
    }

    public String getColor() {
        return color;
    }

    public String getGearShifting() {
        return gearShifting;
    }

    public boolean isFourWheelDrive() {
        return fourWheelDrive;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setYearsOfRelease(int yearsOfRelease) {
        this.yearsOfRelease = yearsOfRelease;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setGearShifting(String gearShifting) {
        this.gearShifting = gearShifting;
    }

    public void setFourWheelDrive(boolean fourWheelDrive) {
        this.fourWheelDrive = fourWheelDrive;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return yearsOfRelease == car.yearsOfRelease && fourWheelDrive == car.fourWheelDrive && Objects.equals(carBrand, car.carBrand) && Objects.equals(model, car.model) && Objects.equals(color, car.color) && Objects.equals(gearShifting, car.gearShifting);
    }

    @Override
    public int hashCode() {
        return carBrand.hashCode() + model.hashCode() + yearsOfRelease + color.hashCode() +
                gearShifting.hashCode() + (fourWheelDrive ? 10 : 0);
    }

    @Override
    public String toString() {
        return "Car{" +
                "carBrand='" + carBrand + '\'' +
                ", model='" + model + '\'' +
                ", yearsOfRelease=" + yearsOfRelease +
                ", color='" + color + '\'' +
                ", gearShifting='" + gearShifting + '\'' +
                ", fourWheelDrive=" + fourWheelDrive +
                '}';
    }
}

package b_Inheritance.vehicle;

public class Vehicle {
    private final static double DEFAULT_FUEL_CONSUMPTION = 1.25;
    private double fuelConsumption;
    private double fuel;
    private int horsePower;

    public static double getDefaultFuelConsumption() {
        return DEFAULT_FUEL_CONSUMPTION;
    }

    public double getFuelConsumption() {
        return this.fuelConsumption;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public double getFuel() {
        return this.fuel;
    }

    public void setFuel(double fuel) {
        this.fuel = fuel;
    }

    public int getHorsePower() {
        return this.horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public Vehicle(double fuel, int horsePower) {
        this.fuelConsumption = getDefaultFuelConsumption();
        this.fuel = fuel;
        this.horsePower = horsePower;
    }

    public void drive(double kilometers) {
        if (this.fuel >= kilometers * this.fuelConsumption) {
            this.fuel -= kilometers * this.fuelConsumption;
        }
    }


}

package motocrossWorldChampionship.entities;

public class PowerMotorcycle extends MotorcycleImpl {
    private static final int MINIMUM_HORSEPOWER = 70;
    private static final int MAXIMUM_HORSEPOWER = 100;
    private static final int CUBIC_CENTIMETERS = 450;


    public PowerMotorcycle(String model, int horsePower) {
        super(model, horsePower, MINIMUM_HORSEPOWER, MAXIMUM_HORSEPOWER, CUBIC_CENTIMETERS);
    }
}
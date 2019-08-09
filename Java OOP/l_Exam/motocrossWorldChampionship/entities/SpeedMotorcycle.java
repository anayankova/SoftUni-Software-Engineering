package motocrossWorldChampionship.entities;

public class SpeedMotorcycle extends MotorcycleImpl {
    private static final int MINIMUM_HORSEPOWER = 50;
    private static final int MAXIMUM_HORSEPOWER = 69;
    private static final int CUBIC_CENTIMETERS = 125;


    public SpeedMotorcycle(String model, int horsePower) {
        super(model, horsePower, MINIMUM_HORSEPOWER, MAXIMUM_HORSEPOWER, CUBIC_CENTIMETERS);
    }
}

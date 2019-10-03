package spaceStation.models.astronauts;

public class Meteorologist extends BaseAstronaut{
    private static final double INITIAL_UNITS_OXYGEN = 90.0;
    private static final int DECREASE_OXYGEN = 10;
    public Meteorologist(String name) {
        super(name,INITIAL_UNITS_OXYGEN);
        super.setDecreaseOxygen(DECREASE_OXYGEN);
    }
}

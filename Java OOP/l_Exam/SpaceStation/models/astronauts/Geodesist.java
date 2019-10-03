package spaceStation.models.astronauts;

public class Geodesist extends BaseAstronaut{
    private static final double INITIAL_UNITS_OXYGEN = 50.0;
    private static final int DECREASE_OXYGEN = 10;
    public Geodesist(String name) {
        super(name,INITIAL_UNITS_OXYGEN);
        super.setDecreaseOxygen(DECREASE_OXYGEN);
    }
}

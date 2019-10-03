package spaceStation.models.astronauts;

public class Biologist extends BaseAstronaut{
    private static final double INITIAL_UNITS_OXYGEN = 70.0;
    private static final int DECREASE_OXYGEN = 5;
    public Biologist(String name) {
        super(name,INITIAL_UNITS_OXYGEN);
        super.setDecreaseOxygen(DECREASE_OXYGEN);
    }
}

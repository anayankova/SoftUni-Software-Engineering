package viceCity.models.players;

public class CivilPlayer extends BasePlayer {
    private static final int DEFAULT_INITIAL_CIVILIAN_HP = 50;

    public CivilPlayer(String name) {
        super(name, DEFAULT_INITIAL_CIVILIAN_HP);
    }
}
package viceCity.models.players;

public class MainPlayer extends BasePlayer {
    private static final String DEFAULT_MAIN_PLAYER_NAME = "Tommy Vercetti";
    private static final int DEFAULT_INITIAL_HP = 100;

    public MainPlayer() {
        super(DEFAULT_MAIN_PLAYER_NAME, DEFAULT_INITIAL_HP);
    }
}
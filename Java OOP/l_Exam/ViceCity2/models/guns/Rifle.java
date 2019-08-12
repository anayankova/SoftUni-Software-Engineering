package viceCity.models.guns;

public class Rifle extends BaseGun {
    private static final int RIFLE_MAGAZINE_CAPACITY = 50;
    private static final int DEFAULT_INITIAL_AMMO = 500;
    private static final int BULLETS_FIRED_PER_SHOT = 5;

    public Rifle(String name) {
        super(name, RIFLE_MAGAZINE_CAPACITY, DEFAULT_INITIAL_AMMO);
        super.setBulletsPerShot(BULLETS_FIRED_PER_SHOT);
    }
}

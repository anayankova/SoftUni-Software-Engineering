package viceCity.models.guns;

public class Pistol extends BaseGun {
    private static final int PISTOL_MAGAZINE_CAPACITY = 10;
    private static final int DEFAULT_INITIAL_AMMO = 100;
    private static final int BULLETS_FIRED_PER_SHOT = 1;

    public Pistol(String name) {
        super(name, PISTOL_MAGAZINE_CAPACITY, DEFAULT_INITIAL_AMMO);
        super.setBulletsPerShot(BULLETS_FIRED_PER_SHOT);
    }
}
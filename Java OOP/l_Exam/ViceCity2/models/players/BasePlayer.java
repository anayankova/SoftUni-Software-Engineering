package viceCity.models.players;

import viceCity.common.ExceptionMessages;
import viceCity.models.guns.Gun;
import viceCity.repositories.GunRepository;
import viceCity.repositories.interfaces.Repository;

public abstract class BasePlayer implements Player {
    private String name;
    private int lifePoints;
    private Repository<Gun> gunRepository;

    protected BasePlayer(String name, int lifePoints) {
        this.setName(name);
        this.setLifePoints(lifePoints);
        this.gunRepository = new GunRepository();
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(ExceptionMessages.PLAYER_NULL_USERNAME);
        }
        this.name = name;
    }

    private void setLifePoints(int lifePoints) {
        if (lifePoints < 0) {
            throw new IllegalArgumentException(ExceptionMessages.PLAYER_LIFE_POINTS_LESS_THAN_ZERO);
        }
        this.lifePoints = lifePoints;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getLifePoints() {
        return this.lifePoints;
    }

    @Override
    public boolean isAlive() {
        return this.getLifePoints() > 0;
    }

    @Override
    public Repository<Gun> getGunRepository() {
        return this.gunRepository;
    }

    @Override
    public void takeLifePoints(int points) {
        int hpAfterDmg = this.getLifePoints() - points;

        if (hpAfterDmg < 0) {
            hpAfterDmg = 0;
        }
        this.setLifePoints(hpAfterDmg);
    }
}
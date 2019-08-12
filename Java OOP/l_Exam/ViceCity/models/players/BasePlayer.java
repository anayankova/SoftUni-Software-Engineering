package viceCity.models.players;

import viceCity.models.guns.Gun;
import viceCity.repositories.interfaces.Repository;

public abstract class BasePlayer implements Player{

    private String name;
    private int lifePoints;
    private Repository<Gun> gunRepository;

    protected BasePlayer(String name, int lifePoints) {
        this.setName(name);
        this.setLifePoints(lifePoints);
        this.gunRepository = getGunRepository();
    }

    @Override
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException("Player's name cannot be null or a whitespace!");
        }
        this.name = name;
    }

    @Override
    public int getLifePoints() {
        return this.lifePoints;
    }

    public void setLifePoints(int lifePoints) {
        if(lifePoints < 0){
            throw new IllegalArgumentException("Player life points cannot be below zero!");
        }
        this.lifePoints = lifePoints;
    }

    @Override
    public boolean isAlive() {
        return lifePoints != 0;
    }

    @Override
    public Repository<Gun> getGunRepository() {
        return this.gunRepository;
    }

    @Override
    public void takeLifePoints(int points) {
        if(lifePoints > 0){
            this.lifePoints -= points;
            if(lifePoints < 0){
                throw new IllegalArgumentException("Player life points cannot be below zero!");
            }
        }

    }
}

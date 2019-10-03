package spaceStation.models.astronauts;

import spaceStation.models.bags.Backpack;
import spaceStation.models.bags.Bag;

import java.util.Collection;
import java.util.List;

public abstract class BaseAstronaut implements Astronaut{
    private String name;
    private double oxygen;
    private Bag bag;
    private int decreaseOxygen;

    protected BaseAstronaut(String name, double oxygen) {
        this.setName(name);
        this.setOxygen(oxygen);
        this.setBag(bag);
    }

    public int getDecreaseOxygen() {
        return decreaseOxygen;
    }

    public void setDecreaseOxygen(int decreaseOxygen) {
        this.decreaseOxygen = decreaseOxygen;
    }

    @Override
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException("Astronaut name cannot be null or empty.");
        }
        this.name = name;
    }

    @Override
    public Bag getBag() {
        return bag;
    }

    public void setBag(Bag bag) {
        this.bag = bag;
    }

    @Override
    public double getOxygen() {
        return this.oxygen;
    }

    public void setOxygen(double oxygen) {
        if (oxygen < 0) {
            throw new IllegalArgumentException("Cannot create Astronaut with negative oxygen!");
        }
        this.oxygen = oxygen;
    }

    @Override
    public boolean canBreath() {
        return this.getOxygen() > 0;
    }



    @Override
    public void breath() {
        if(this.getOxygen() - this.getDecreaseOxygen() >= 0){
            this.setOxygen(this.getOxygen() - this.getDecreaseOxygen());
        }else{
            this.setOxygen(0);
        }
    }
}

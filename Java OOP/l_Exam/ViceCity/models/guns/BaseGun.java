package viceCity.models.guns;

import java.util.Random;

public abstract class BaseGun implements Gun{

    private String name;
    private int bulletsPerBarrel;
    private int totalBullets;
    private int countOfBullets;

    protected BaseGun(String name, int bulletsPerBarrel, int totalBullets) {
        this.setName(name);
        this.setBulletsPerBarrel(bulletsPerBarrel);
        this.setTotalBullets(totalBullets);
    }

    @Override
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException("Name cannot be null or whitespace!");
        }
        this.name = name;
    }

    @Override
    public int getBulletsPerBarrel() {
        return this.bulletsPerBarrel;
    }

    public void setBulletsPerBarrel(int bulletsPerBarrel) {
        if(bulletsPerBarrel < 0){
            throw new IllegalArgumentException("Bullets cannot be below zero!");
        }
        this.bulletsPerBarrel = bulletsPerBarrel;
    }

    @Override
    public boolean canFire() {
        return bulletsPerBarrel > 0;
    }

    @Override
    public int getTotalBullets() {
        return this.totalBullets;
    }

    public void setTotalBullets(int totalBullets) {
        if(totalBullets < 0){
            throw new IllegalArgumentException("Total bullets cannot be below zero!");
        }
        this.totalBullets = totalBullets;
    }

    @Override
    public int fire() {
        int capacityOfBarrel = this.bulletsPerBarrel;
        Random random = new Random();
        int randInt = random.nextInt(capacityOfBarrel);
        while (true){
            this.countOfBullets -= randInt;
            capacityOfBarrel -= countOfBullets;
            if(capacityOfBarrel <= 0){
                this.totalBullets -= capacityOfBarrel;
                continue;
            }
            capacityOfBarrel = this.bulletsPerBarrel;
            if(this.totalBullets <= 0){
                break;
            }
        }
        return countOfBullets;
    }
}

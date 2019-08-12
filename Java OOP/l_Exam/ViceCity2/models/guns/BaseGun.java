package viceCity.models.guns;

import viceCity.common.ExceptionMessages;

public abstract class BaseGun implements Gun {
    private String name;
    private int bulletsPerBarrel;
    private int totalBullets;
    private int bulletsPerShot;
    private int magazine;

    protected BaseGun(String name, int bulletsPerBarrel, int totalBullets) {
        this.setName(name);
        this.setBulletsPerBarrel(bulletsPerBarrel);
        this.setTotalBullets(totalBullets);
        this.reload();
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(ExceptionMessages.NAME_NULL);
        }
        this.name = name;
    }

    protected void setBulletsPerShot(int bulletsPerShot) {
        this.bulletsPerShot = bulletsPerShot;
    }

    private void setBulletsPerBarrel(int bulletsPerBarrel) {
        if (bulletsPerBarrel < 0) {
            throw new IllegalArgumentException(ExceptionMessages.BULLETS_LESS_THAN_ZERO);
        }
        this.bulletsPerBarrel = bulletsPerBarrel;
    }

    private void setTotalBullets(int totalBullets) {
        if (totalBullets < 0) {
            throw new IllegalArgumentException(ExceptionMessages.TOTAL_BULLETS_LESS_THAN_ZERO);
        }
        this.totalBullets = totalBullets;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getBulletsPerBarrel() {
        return this.bulletsPerBarrel;
    }

    @Override
    public boolean canFire() {
        return this.magazine >= bulletsPerShot || this.totalBullets >= bulletsPerShot;
    }

    @Override
    public int getTotalBullets() {
        return this.totalBullets;
    }

    private void reload() {
        this.magazine = this.bulletsPerBarrel;
        this.totalBullets -= this.bulletsPerBarrel;
    }

    private int getMagazine() {
        return this.magazine;
    }

    @Override
    public int fire() {
        if (this.getMagazine() == 0) {
            this.reload();
        }
        this.magazine -= bulletsPerShot;
        return this.bulletsPerShot;
    }
}
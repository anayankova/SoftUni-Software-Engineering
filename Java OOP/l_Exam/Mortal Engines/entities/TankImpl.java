package entities;

import entities.BaseMachine;
import entities.interfaces.Tank;

public class TankImpl extends BaseMachine implements Tank {
    private static final double HEALTH_POINTS_DEFAULT = 100.0;
    private static final double ATTACK_POINTS_MODIFIER = 40.0;
    private static final double DEFENSE_POINTS_MODIFIER = 30.0;
    private boolean defenseMode;

    public TankImpl(String name, double attackPoints, double defensePoints) {
        super(name, attackPoints, defensePoints, HEALTH_POINTS_DEFAULT);
        this.setDefenseModeTrue();
    }

    @Override
    public boolean getDefenseMode() {
        return this.defenseMode;
    }

    @Override
    public void toggleDefenseMode() {
        if (this.getDefenseMode()) {
            this.setDefenseModeFalse();
        } else {
            this.setDefenseModeTrue();
        }
    }

    private void setDefenseModeTrue() {
        this.defenseMode = true;
        super.setAttackPoints(super.getAttackPoints() - ATTACK_POINTS_MODIFIER);
        super.setDefensePoints(super.getDefensePoints() + DEFENSE_POINTS_MODIFIER);
    }

    private void setDefenseModeFalse() {
        this.defenseMode = false;
        super.setAttackPoints(super.getAttackPoints() + ATTACK_POINTS_MODIFIER);
        super.setDefensePoints(super.getDefensePoints() - DEFENSE_POINTS_MODIFIER);
    }

    @Override
    public String toString() {
        String mode = this.getDefenseMode() ? "ON" : "OFF";
        String tankInfo = super.toString() + String.format(" *Defense Mode(%s)", mode);
        return tankInfo;
    }
}

package entities;

import common.InputValidator;
import entities.interfaces.Machine;
import entities.interfaces.Pilot;

import java.util.ArrayList;
import java.util.List;
//	name – String (If the name is null or whitespace throw an IllegalArgumentException with message "Machine name cannot be null or empty.")
//	pilot – the machine pilot (if the pilot is null throw NullPointerException with message "Pilot cannot be null.")
//	attackPoints – double
//	defensePoints - double
//	healthPoints - double
//	targets – collection of Strings

public abstract class BaseMachine implements Machine {
    private String name;
    private Pilot pilot;
    private double attackPoints;
    private double defensePoints;
    private double healthPoints;
    private List<String> targets;

    protected BaseMachine(String name, double attackPoints, double defensePoints, double healthPoints) {
        this.setName(name);
        this.attackPoints = attackPoints;
        this.defensePoints = defensePoints;
        this.healthPoints = healthPoints;
        this.targets = new ArrayList<>();
        this.pilot = null;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        if (!InputValidator.isValidMachineName(name)) {
            throw new IllegalArgumentException("Machine name cannot be null or empty.");
        }
        this.name = name;
    }

    @Override
    public Pilot getPilot() {
        return this.pilot;
    }

    @Override
    public void setPilot(Pilot pilot) {
        if (pilot == null) {
            throw new NullPointerException("Pilot cannot be null.");
        }
        this.pilot = pilot;
    }

    @Override
    public double getHealthPoints() {
        return this.healthPoints;
    }

    @Override
    public void setHealthPoints(double healthPoints) {
        this.healthPoints = healthPoints;
    }

    protected void setDefensePoints(double defensePoints) {
        this.defensePoints = defensePoints;
    }

    protected void setAttackPoints(double attackPoints) {
        this.attackPoints = attackPoints;
    }

    @Override
    public double getAttackPoints() {
        return this.attackPoints;
    }

    @Override
    public double getDefensePoints() {
        return this.defensePoints;
    }

    @Override
    public List<String> getTargets() {
        return this.targets;
    }

    @Override
    public void attack(String target) {
        if (this.isValidTarget(target)) {
            this.targets.add(target);
        } else {
            throw new IllegalArgumentException("Attack target cannot be null or empty string.");
        }
    }

    private boolean isValidTarget(String target) {
        return target != null && !target.isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder machineInfo = new StringBuilder();
        machineInfo
                .append(String.format("- %s%n", this.getName()))
                .append(String.format(" *Type: %s%n", this.getClass().getInterfaces()[0].getSimpleName()))
                .append(String.format(" *Health: %.2f%n", this.getHealthPoints()))
                .append(String.format(" *Attack: %.2f%n", this.getAttackPoints()))
                .append(String.format(" *Defense: %.2f%n", this.getDefensePoints()))
                .append(" *Targets: ");

        List<String> targets = this.getTargets();

        if (targets.isEmpty()) {
            machineInfo.append("None").append(System.lineSeparator());
        } else {
            for (String target : this.getTargets()) {
                machineInfo
                        .append(target)
                        .append(", ");
            }
            machineInfo
                    .deleteCharAt(machineInfo.length() - 1)
                    .deleteCharAt(machineInfo.length() - 1)
                    .append(System.lineSeparator());
        }
        return machineInfo.toString();
    }
}
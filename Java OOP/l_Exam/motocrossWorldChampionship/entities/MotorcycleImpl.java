package motocrossWorldChampionship.entities;

import motocrossWorldChampionship.entities.interfaces.Motorcycle;

import static motocrossWorldChampionship.common.ExceptionMessages.INVALID_HORSE_POWER;
import static motocrossWorldChampionship.common.ExceptionMessages.INVALID_MODEL;

public abstract class MotorcycleImpl implements Motorcycle {
    private String model;
    private int horsePower;
    private double cubicCentimeters;

    private static final int MODEL_MINIMUM_LENGTH = 4;

    public MotorcycleImpl(String model, int horsePower, int minHorsepower, int maxHorsepower, double cubicCentimeters) {
        this.setModel(model);
        this.setHorsePower(horsePower, minHorsepower, maxHorsepower);
        this.setCubicCentimeters(cubicCentimeters);
    }

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public int getHorsePower() {
        return this.horsePower;
    }

    @Override
    public double getCubicCentimeters() {
        return this.cubicCentimeters;
    }

    @Override
    public double calculateRacePoints(int laps) {
        return this.getCubicCentimeters() / this.getHorsePower() * laps;
    }

    private void setModel(String model) {
        if (model == null || model.trim().equals("") || model.length() < MODEL_MINIMUM_LENGTH) {
            throw new IllegalArgumentException(String.format(INVALID_MODEL, model, MODEL_MINIMUM_LENGTH));
        }
        this.model = model;
    }

    private void setHorsePower(int horsePower, int minHorsepower, int maxHorsepower) {
        if (horsePower < minHorsepower || horsePower > maxHorsepower) {
            throw new IllegalArgumentException(String.format(INVALID_HORSE_POWER, horsePower));
        }
        this.horsePower = horsePower;
    }

    private void setCubicCentimeters(double cubicCentimeters) {
        this.cubicCentimeters = cubicCentimeters;
    }
}
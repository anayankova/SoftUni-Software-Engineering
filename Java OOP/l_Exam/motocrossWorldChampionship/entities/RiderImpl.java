package motocrossWorldChampionship.entities;

import motocrossWorldChampionship.entities.interfaces.Motorcycle;
import motocrossWorldChampionship.entities.interfaces.Rider;

import static motocrossWorldChampionship.common.ExceptionMessages.INVALID_NAME;
import static motocrossWorldChampionship.common.ExceptionMessages.RIDER_INVALID;

public class RiderImpl implements Rider {
    private String name;
    private Motorcycle motorcycle;
    private int numberOfWins;
    private boolean canParticipate;

    private static final boolean DEFAULT_PARTICIPATION_STATUS = false;
    private static final int MIN_NAME_LENGTH = 5;

    public RiderImpl(String name) {
        this.setName(name);
        this.setCanParticipate();
    }

    private void setName(String name) {
        if (name == null || name.trim().equals("") || name.length() < MIN_NAME_LENGTH) {
            throw new IllegalArgumentException(String.format(INVALID_NAME, name, MIN_NAME_LENGTH));
        }
        this.name = name;
    }

    private void increaseWinsByOne() {
        this.numberOfWins++;
    }

    private void setCanParticipate() {
        if (this.motorcycle != null) {
            this.canParticipate = true;
        } else {
            this.canParticipate = DEFAULT_PARTICIPATION_STATUS;
        }

    }

    public void addMotorcycle(Motorcycle motorcycle) {
        if (motorcycle == null) {
            throw new NullPointerException(RIDER_INVALID);
        }

        this.motorcycle = motorcycle;
        this.setCanParticipate();
    }

    public void winRace() {
        this.increaseWinsByOne();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Motorcycle getMotorcycle() {
        return this.motorcycle;
    }

    @Override
    public int getNumberOfWins() {
        return this.numberOfWins;
    }

    @Override
    public boolean getCanParticipate() {
        return this.canParticipate;
    }
}

package motocrossWorldChampionship.entities;

import motocrossWorldChampionship.entities.interfaces.Race;
import motocrossWorldChampionship.entities.interfaces.Rider;

import java.util.ArrayList;
import java.util.Collection;

import static motocrossWorldChampionship.common.ExceptionMessages.*;

public class RaceImpl implements Race {

    private static final int NAME_MINIMUM_LENGTH = 5;
    private static final int LAPS_MINIMUM_COUNT = 1;

    private String name;
    private int laps;
    private Collection<Rider> riders;

    public RaceImpl(String name, int laps) {
        this.setName(name);
        this.setLaps(laps);
        this.riders = new ArrayList<>();
    }

    private void setName(String name) {

        if (name == null || name.trim().equals("") || name.length() < NAME_MINIMUM_LENGTH) {
            throw new IllegalArgumentException(String.format(INVALID_NAME, name, NAME_MINIMUM_LENGTH));
        }

        this.name = name;
    }

    private void setLaps(int laps) {

        if (laps < LAPS_MINIMUM_COUNT) {
            throw new IllegalArgumentException(String.format(INVALID_NUMBER_OF_LAPS, LAPS_MINIMUM_COUNT));
        }

        this.laps = laps;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getLaps() {
        return this.laps;
    }

    @Override
    public Collection<Rider> getRiders() {
        return this.riders;
    }

    @Override
    public void addRider(Rider rider) {
        if (rider == null) {
            throw new NullPointerException(RIDER_INVALID);
        }

        if (!rider.getCanParticipate()) {
            throw new IllegalArgumentException(String.format(RIDER_NOT_PARTICIPATE, rider.getName()));
        }

        //this.riders.contains(rider)
        if (this.riders
                .stream()
                .anyMatch(r -> getName().equals(rider.getName()))) {
            throw new IllegalArgumentException(String.format(RIDER_ALREADY_ADDED, rider.getName(), this.getName()));
        }

        this.riders.add(rider);
    }

}

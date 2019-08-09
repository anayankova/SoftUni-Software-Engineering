package motocrossWorldChampionship.core;

import motocrossWorldChampionship.core.interfaces.ChampionshipController;
import motocrossWorldChampionship.entities.interfaces.Motorcycle;
import motocrossWorldChampionship.entities.interfaces.Race;
import motocrossWorldChampionship.entities.interfaces.Rider;
import motocrossWorldChampionship.entities.PowerMotorcycle;
import motocrossWorldChampionship.entities.SpeedMotorcycle;
import motocrossWorldChampionship.entities.RaceImpl;
import motocrossWorldChampionship.entities.RiderImpl;
import motocrossWorldChampionship.repositories.interfaces.Repository;

import java.util.List;
import java.util.stream.Collectors;

import static motocrossWorldChampionship.common.ExceptionMessages.*;
import static motocrossWorldChampionship.common.OutputMessages.*;

public class ChampionshipControllerImpl implements ChampionshipController {

    private static final int RACE_MINIMUM_PARTICIPANTS = 3;

    private Repository<Rider> ridersRepository;
    private Repository<Motorcycle> motorcycleRepository;
    private Repository<Race> raceRepository;

    public ChampionshipControllerImpl(Repository<Rider> ridersRepository, Repository<Motorcycle> motorcycleRepository, Repository<Race> raceRepository) {
        this.ridersRepository = ridersRepository;
        this.motorcycleRepository =  motorcycleRepository;
        this.raceRepository = raceRepository;
    }

    @Override
    public String createRider(String riderName) {

        if (this.ridersRepository.getAll().contains(this.ridersRepository.getByName(riderName))){
            throw new IllegalArgumentException(String.format(RIDER_EXISTS, riderName));
        }

        Rider riderObj = new RiderImpl(riderName);

        this.ridersRepository.add(riderObj);

        return String.format(RIDER_CREATED, riderName);
    }

    @Override
    public String createMotorcycle(String type, String model, int horsePower) {

        if (this.motorcycleRepository.getAll().contains(this.motorcycleRepository.getByName(model))){
            throw new IllegalArgumentException(String.format(MOTORCYCLE_EXISTS, model));
        }

        Motorcycle motorcycleObj = null;

        if (type.equals("Speed")) {
            motorcycleObj = new SpeedMotorcycle(model, horsePower);
        } else if (type.equals("Power")) {
            motorcycleObj = new PowerMotorcycle(model, horsePower);
        }

        this.motorcycleRepository.add(motorcycleObj);

        return String.format(MOTORCYCLE_CREATED, motorcycleObj.getClass().getSimpleName(), motorcycleObj.getModel());
    }

    @Override
    public String addMotorcycleToRider(String riderName, String motorcycleModel) {

        if (!this.ridersRepository.getAll().contains(this.ridersRepository.getByName(riderName))){
            throw new NullPointerException(String.format(RIDER_NOT_FOUND, riderName));
        }

        if (!this.motorcycleRepository.getAll().contains(this.motorcycleRepository.getByName(motorcycleModel))){
            throw new NullPointerException(String.format(MOTORCYCLE_NOT_FOUND, motorcycleModel));
        }

        this.ridersRepository.getByName(riderName).addMotorcycle(this.motorcycleRepository.getByName(motorcycleModel));

        return String.format(MOTORCYCLE_ADDED, riderName, motorcycleModel);
    }

    @Override
    public String addRiderToRace(String raceName, String riderName) {

        if (!this.raceRepository.getAll().contains(this.raceRepository.getByName(raceName))){
            throw new NullPointerException(String.format(RACE_NOT_FOUND, raceName));
        }

        if (!this.ridersRepository.getAll().contains(this.ridersRepository.getByName(riderName))){
            throw new NullPointerException(String.format(RIDER_NOT_FOUND, riderName));
        }

        this.raceRepository.getByName(raceName).addRider(this.ridersRepository.getByName(riderName));

        return String.format(RIDER_ADDED, riderName, raceName);
    }

    @Override
    public String startRace(String raceName) {

        if (!this.raceRepository.getAll().contains(this.raceRepository.getByName(raceName))){
            throw new NullPointerException(String.format(RACE_NOT_FOUND, raceName));
        }

        if (this.raceRepository.getByName(raceName).getRiders().size() < RACE_MINIMUM_PARTICIPANTS) {
            throw new IllegalArgumentException(String.format(RACE_INVALID, raceName, RACE_MINIMUM_PARTICIPANTS));
        }

        List<Rider> winners = this.raceRepository.getByName(raceName).getRiders().stream().sorted(
                (r1, r2) -> Double.compare(
                        r2.getMotorcycle().calculateRacePoints(this.raceRepository.getByName(raceName).getLaps()),
                        r1.getMotorcycle().calculateRacePoints(this.raceRepository.getByName(raceName).getLaps())))
                .limit(3)
                .collect(Collectors.toList());

        winners.get(0).winRace();

        this.raceRepository.remove(this.raceRepository.getByName(raceName));

        StringBuilder sb = new StringBuilder();
        sb.append(String.format(RIDER_FIRST_POSITION, winners.get(0).getName(), raceName));
        sb.append(System.lineSeparator());
        sb.append(String.format(RIDER_SECOND_POSITION, winners.get(1).getName(), raceName));
        sb.append(System.lineSeparator());
        sb.append(String.format(RIDER_THIRD_POSITION, winners.get(2).getName(), raceName));

        return sb.toString();
    }

    @Override
    public String createRace(String name, int laps) {

        if (this.raceRepository.getAll().contains(this.raceRepository.getByName(name))){
            throw new IllegalArgumentException(String.format(RACE_EXISTS, name));
        }

        Race race = new RaceImpl(name, laps);

        this.raceRepository.add(race);

        return String.format(RACE_CREATED, name);
    }
}
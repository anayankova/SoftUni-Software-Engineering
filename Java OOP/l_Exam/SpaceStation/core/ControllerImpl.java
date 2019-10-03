package spaceStation.core;

import spaceStation.models.astronauts.Astronaut;
import spaceStation.models.astronauts.Biologist;
import spaceStation.models.astronauts.Geodesist;
import spaceStation.models.astronauts.Meteorologist;
import spaceStation.models.mission.Mission;
import spaceStation.models.mission.MissionImpl;
import spaceStation.models.planets.Planet;
import spaceStation.models.planets.PlanetImpl;
import spaceStation.repositories.AstronautRepository;
import spaceStation.repositories.PlanetRepository;

import java.util.Collections;

public class ControllerImpl implements Controller {

    private AstronautRepository astronautRepository;
    private PlanetRepository planetRepository;
    private Mission mission;
    private Astronaut astronaut;

    @Override
    public String addAstronaut(String type, String astronautName) {
        Astronaut astronaut = null;
        String message;

        if (Biologist.class.getSimpleName().equals(type)) {
            astronaut = new Biologist(astronautName);
            this.astronautRepository.add(astronaut);
            message = String.format("Successfully added %s: %s!", type, astronautName);
        } else if (Geodesist.class.getSimpleName().equals(type)) {
            astronaut = new Geodesist(astronautName);
            this.astronautRepository.add(astronaut);
            message = String.format("Successfully added %s: %s!", type, astronautName);
        } else if (Meteorologist.class.getSimpleName().equals(type)) {
            astronaut = new Meteorologist(astronautName);
            this.astronautRepository.add(astronaut);
            message = String.format("Successfully added %s: %s!", type, astronautName);
        } else {
            message = "Astronaut type doesn't exists!";
            throw new IllegalArgumentException(message);
        }
        return message;
    }

    @Override
    public String addPlanet(String planetName, String... items) {
        Planet planet = new PlanetImpl(planetName);
        planet.getItems().add(String.valueOf(items));
        String message = String.format("Successfully added Planet: %s!", planetName);

        return message;
    }

    @Override
    public String retireAstronaut(String astronautName) {
        String message;
        boolean Exist = (boolean) this.astronautRepository.findByName(astronautName);
        if (Exist) {
            this.astronautRepository.remove(astronautName);
            message = String.format("Astronaut %s was retired!", astronautName);
        } else {
            message = String.format("Astronaut %s doesn't exists!", astronautName);
        }

        return message;
    }

    @Override
    public String explorePlanet(String planetName) {
        Astronaut astronaut = null;
        MissionImpl mission = null;
        Planet planet = null;
        int countDeadAstronauts = 2;
        mission.explore((Planet) this.planetRepository.findByName(planetName), this.astronautRepository.getModels());
        for (Object a : this.astronautRepository.getModels()) {

        }
        return String.format("Planet: %s was explored! Exploration finished with %d dead astronauts!",
                planetName, countDeadAstronauts);
    }

    @Override
    public String report() {
        return null;
    }
}

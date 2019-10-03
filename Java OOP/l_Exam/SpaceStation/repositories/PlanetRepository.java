package spaceStation.repositories;

import spaceStation.models.astronauts.Astronaut;
import spaceStation.models.planets.Planet;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class PlanetRepository implements Repository{

    List<Planet> planets;

    @Override
    public Collection getModels() {
        return Collections.unmodifiableCollection(planets);
    }

    @Override
    public void add(Object planet) {
        if(!this.planets.contains(planet)) {
            this.planets.add((Planet) planet);
        }
    }

    @Override
    public boolean remove(Object planet) {
        return this.planets.remove(planet);
    }

    @Override
    public Object findByName(String name) {
        return this.planets.contains(name);
    }
}

package spaceStation.repositories;

import spaceStation.models.astronauts.Astronaut;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class AstronautRepository implements Repository{

    List<Astronaut> astronauts;

    @Override
    public Collection getModels() {
        return Collections.unmodifiableCollection(astronauts);
    }

    @Override
    public void add(Object astronaut) {
        if(!this.astronauts.contains(astronaut)) {
            this.astronauts.add((Astronaut) astronaut);
        }
    }

    @Override
    public boolean remove(Object astronaut) {
        return this.astronauts.remove(astronaut);
    }

    @Override
    public Object findByName(String name) {
        return this.astronauts.contains(name);
    }
}

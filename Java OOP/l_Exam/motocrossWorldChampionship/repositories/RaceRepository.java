package motocrossWorldChampionship.repositories;

import motocrossWorldChampionship.entities.interfaces.Race;
import motocrossWorldChampionship.repositories.interfaces.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class RaceRepository implements Repository<Race> {

    private List<Race> entities;

    public RaceRepository() {
        this.entities = new ArrayList<>();
    }

    @Override
    public Race getByName(String name) {

        for (Race entity : entities) {
            if (name.equals(entity.getName())){
                return entity;
            }
        }

        return null;
    }

    @Override
    public Collection<Race> getAll() {
        return Collections.unmodifiableCollection(this.entities);
    }

    @Override
    public void add(Race model) {
        this.entities.add(model);
    }

    @Override
    public boolean remove(Race model) {

        return this.entities.removeIf(m -> m.getName().equals(model.getName()));
    }
}

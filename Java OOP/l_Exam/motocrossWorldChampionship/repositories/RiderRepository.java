package motocrossWorldChampionship.repositories;

import motocrossWorldChampionship.entities.interfaces.Rider;
import motocrossWorldChampionship.repositories.interfaces.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class RiderRepository implements Repository<Rider> {

    private List<Rider> entities;

    public RiderRepository() {
        this.entities = new ArrayList<>();
    }

    @Override
    public Rider getByName(String name) {

        for (Rider entity : entities) {
            if (name.equals(entity.getName())){
                return entity;
            }
        }

        return null;
    }

    @Override
    public Collection<Rider> getAll() {
        return Collections.unmodifiableCollection(this.entities);
    }

    @Override
    public void add(Rider model) {
        this.entities.add(model);
    }

    @Override
    public boolean remove(Rider model) {

        return this.entities.removeIf(m -> m.getName().equals(model.getName()));
    }
}

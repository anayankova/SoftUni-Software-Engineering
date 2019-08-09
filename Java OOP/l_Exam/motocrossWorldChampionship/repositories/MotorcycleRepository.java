package motocrossWorldChampionship.repositories;

import motocrossWorldChampionship.entities.interfaces.Motorcycle;
import motocrossWorldChampionship.repositories.interfaces.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class MotorcycleRepository implements Repository<Motorcycle> {

    private List<Motorcycle> entities;

    public MotorcycleRepository() {
        this.entities = new ArrayList<>();
    }

    @Override
    public Motorcycle getByName(String name) {

        for (Motorcycle entity : entities) {
            if (name.equals(entity.getModel())){
                return entity;
            }
        }

        return null;
    }

    @Override
    public Collection<Motorcycle> getAll() {
        return Collections.unmodifiableCollection(this.entities);
    }

    @Override
    public void add(Motorcycle model) {
        this.entities.add(model);
    }

    @Override
    public boolean remove(Motorcycle model) {

        return this.entities.removeIf(m -> m.getModel().equals(model.getModel()));
    }
}

package viceCity.repositories;

import viceCity.models.guns.Gun;
import viceCity.repositories.interfaces.Repository;

import java.util.Collection;
import java.util.Collections;

public class GunRepository implements Repository {
    private Collection<Gun> models;

    @Override
    public Collection getModels() {
        return Collections.unmodifiableCollection(this.models);
    }

    @Override
    public void add(Object model) {
        if(!this.models.contains(model)){
            this.models.add((Gun) model);
        }
    }

    @Override
    public boolean remove(Object model) {
        return this.models.remove(model);
    }

    @Override
    public Object find(String name) {
        return this.models.contains(name);
    }
}

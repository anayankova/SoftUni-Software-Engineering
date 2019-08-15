package viceCity.repositories;

import viceCity.models.guns.Gun;
import viceCity.repositories.interfaces.Repository;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class GunRepository implements Repository<Gun> {
    private Map<String, Gun> models;

    public GunRepository() {
        this.models = new LinkedHashMap<>();
    }

    @Override
    public Collection<Gun> getModels() {
        return Collections.unmodifiableCollection(this.models.values());
    }

    @Override
    public void add(Gun model) {
        if (!this.models.containsKey(model.getName())) {
            this.models.put(model.getName(), model);
        }
    }

    @Override
    public boolean remove(Gun model) {
        Gun removedObject = this.models.remove(model.getName());
        boolean isRemoved = true;

        if (removedObject == null)
            isRemoved = false;

        return isRemoved;
    }

    @Override
    public Gun find(String name) {
        Gun model = this.models.get(name);
        return model;
    }
}

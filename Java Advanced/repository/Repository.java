package repository;

import java.util.HashMap;
import java.util.Map;

public class Repository {
    private Map<Integer, Person> data;
    private int currentId;

    public Repository() {
        this.currentId = 0;
        this.data = new HashMap<>();
    }

    public void add(Person person) {
        this.data.put(this.currentId, person);
        this.currentId++;
    }

    public Person get(int id) {
        return this.data.get(id);
    }

    public boolean update(int id, Person newPerson) {
        if(!this.exists(id)) {
            return false;
        }
        this.data.put(id, newPerson);
        return true;
    }

    public boolean delete(int id){
        if(!this.exists(id)) {
            return false;
        }
        this.data.remove(id);
        return true;
    }

    public int getCount(){
        return this.data.size();
    }

    private boolean exists(int id) {
        return this.data.containsKey(id);

    }
}

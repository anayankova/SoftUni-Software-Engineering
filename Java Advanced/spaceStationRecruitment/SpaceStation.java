package spaceStationRecruitment;

import java.util.ArrayList;
import java.util.List;

public class SpaceStation {
    private List<Astronaut> astronauts;
    private String name;
    private int capacity;

    public SpaceStation(String name, int capacity) {
        this.astronauts = new ArrayList<>();
        this.name = name;
        this.capacity = capacity;
    }

    public String getName() {
        return this.name;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public int getCount() {
        return this.astronauts.size();
    }

    public void add(Astronaut astronaut) {
        this.astronauts.add(astronaut);
    }

    public boolean remove(String name) {
        return this.astronauts.removeIf(a -> a.getName().equals(name));
    }

    public Astronaut getOldestAstronaut() {
        Astronaut astronaut = null;

        for (Astronaut a : astronauts) {
            int maxAge = Integer.MIN_VALUE;
            if (a.getAge() > maxAge) {
                astronaut = a;
            }
        }

        return astronaut;

    }

    public Astronaut getAstronaut(String name) {
        Astronaut astronaut = null;
        for (Astronaut a : astronauts) {
            if (a.getName().equals(name)) {
                astronaut = a;
            }
        }

        return astronaut;

    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Astronauts working at Space Station %s:",
                this.name));
        sb.append(System.lineSeparator());

        for (Astronaut a : astronauts) {

            sb.append(a.toString()).append(System.lineSeparator());

        }
        return sb.toString();

    }
}

package healthyHeaven;

import java.util.*;

public class Restaurant {
    private String name;
    private Map<String, Salad> data;

    public Restaurant(String name) {
        this.name = name;
        this.data = new LinkedHashMap<>();
    }

    public void add(Salad salad) {
        this.data.put(salad.getName(), salad);
    }

    public boolean buy(String name) {
        if (this.data.containsKey(name)) {
            this.data.remove(name);
            return true;
        }
        return false;
    }

    public Salad getHealthiestSalad() {
        long min = Long.MAX_VALUE;
        String best = "";
        for (Salad salad : this.data.values()) {
            if (salad.getTotalCalories() < min) {
                min = salad.getTotalCalories();
                best = salad.getName();
            }
        }
        return this.data.get(best);

        //salads.stream().min(Comparator.comparingInt(Salad::getTotalCalories)).orElse(null);
    }

    public String generateMenu() {
        StringBuilder sb =  new StringBuilder();
        sb.append(String.format("%s have %d salads:",
                this.name, this.data.size()));
        sb.append(System.lineSeparator());
        int counter = 0;
        for (Salad salad : data.values()) {
            counter++;
            if (counter == data.size()) {
                sb.append(salad.toString());
            } else {
                sb.append(salad.toString()).append(System.lineSeparator());
            }
        }
        return sb.toString();
    }
}

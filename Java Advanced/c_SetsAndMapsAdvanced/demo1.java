package c_SetsAndMapsAdvanced;

import java.util.HashMap;

public class demo1 {
    public static void main(String[] args) {
        HashMap<String, Integer> vehicles = new HashMap<>();
        vehicles.put("BMW", 5);
        vehicles.put("Mercedes", 3);
        vehicles.put("Audi", 4);
        vehicles.put("BMW", 10);
        for(String key: vehicles.keySet()) {
            System.out.println(key + " - " + vehicles.get(key));
        }


    }
}

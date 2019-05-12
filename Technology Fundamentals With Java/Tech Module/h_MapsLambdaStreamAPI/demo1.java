package h_MapsLambdaStreamAPI;

import java.util.HashMap;

public class demo1 {
    public static void main(String[] args) {
        HashMap<String, Integer> airplanes = new HashMap<>();
        airplanes.put("Boeing 737", 130);
        airplanes.put("Airbus A320", 150);

        airplanes.remove("Boeing 737");

        airplanes.clear();

        HashMap<String, String> hey = new HashMap<>();

        hey.put("a","b");

        System.out.println(airplanes);
        System.out.println(hey);

        System.out.println(hey.toString().replaceAll("[\\{\\}]",""));


    }
}

package h_MapsLambdaStreamAPI;

import java.util.HashMap;

public class demo2 {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Airbus A320", 150);
        if (map.containsKey("Airbus A320")) {
            System.out.println("Airbus A320 key exists");
        }

        if (map.containsValue(150)){
            System.out.println("150");
            map.clone();
        }

        System.out.println(map.containsValue(150)); //true
        System.out.println(map.containsValue(100)); //false

        System.out.println(map.toString().replaceAll("[\\=]",""));

    }
}

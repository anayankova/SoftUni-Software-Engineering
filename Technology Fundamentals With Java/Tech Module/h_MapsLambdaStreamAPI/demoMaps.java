package h_MapsLambdaStreamAPI;

import java.util.HashMap;
import java.util.Map;

public class demoMaps {
    public static void main(String[] args) {
        Map<String, Map<String, Integer>> listMap = new HashMap<>();

        listMap.put("BG", new HashMap<>());
        listMap.put("EN", new HashMap<>());
        listMap.get("BG").put("Peter", 20);
        listMap.get("EN").put("Maria", 15);
        listMap.get("EN").put("Stefan", 15);
        listMap.get("EN").put("John", 15);

        Map<String, Integer> newMap = new HashMap<>();

        listMap.forEach((key, value) -> {
            Map<String, Integer> inner = listMap.get(key);
            System.out.println(inner);

            newMap.put(key, 0);
            inner.forEach((k, v) -> {
                newMap.put(key, newMap.get(key) + v);
            });
        });

        Map<String, Integer> example = new HashMap<>();

        example.put("Ana", 3);
        example.put("Ana", example.get("Ana")+1);
        System.out.println(example);

        listMap.forEach((k, v) -> {
            System.out.println(k);

            listMap.get(k).forEach((key, value) -> {
                System.out.println(String.format("-- %s -> %d",
                        key, value));
            });
        });




    }
}

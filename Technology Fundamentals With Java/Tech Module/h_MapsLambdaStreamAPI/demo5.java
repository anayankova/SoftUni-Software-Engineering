package h_MapsLambdaStreamAPI;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class demo5 {
    public static void main(String[] args) {
        Map<String, Integer> someMap = new HashMap<>(); //TreeMap sorted by key //LinkedHashMap sorted in order of addition

        someMap.put("Key1", 1);
        someMap.put("Key2", 5);
        someMap.put("Key5", 3);
        someMap.put("Key4", 4);

        for (Map.Entry<String, Integer>keyValuePair : someMap.entrySet()){
            System.out.println(keyValuePair.getKey() + " -> " + keyValuePair.getValue());

        }

    }
}

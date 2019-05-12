package h_MapsLambdaStreamAPI;

import java.util.HashMap;
import java.util.Map;

public class demo6 {
    public static void main(String[] args) {

        Map<String, Integer> someMap = new HashMap<>();

        someMap.put("Stamat", 6);
        someMap.put("Pesho", 6);
        someMap.put("Slavi", 52);

        for (String s : someMap.keySet()) {
            System.out.println(s);
        }

        for (Integer value : someMap.values()) {
            System.out.println(value);
        }

        for (Map.Entry<String, Integer> stringIntegerEntry : someMap.entrySet()) {
            System.out.println(stringIntegerEntry);
            System.out.println(stringIntegerEntry.getKey());
            System.out.println(stringIntegerEntry.getValue());
        }

    }
}

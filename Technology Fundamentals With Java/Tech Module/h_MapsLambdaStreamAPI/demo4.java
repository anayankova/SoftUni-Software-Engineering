package h_MapsLambdaStreamAPI;

import java.util.HashMap;
import java.util.Map;

public class demo4 {
    public static void main(String[] args) {
        Map<String, Integer> someMap = new HashMap<>();

        someMap.put("Stamat", 6);
        someMap.put("Slavi", 6);
        someMap.put("Slavi", 52);
        System.out.println(someMap);

        System.out.println("After Delete");
        int value = someMap.remove("Slavi");
        System.out.println(someMap);
        System.out.println("Value: " + value);


    }
}

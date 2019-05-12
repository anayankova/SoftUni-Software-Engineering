package h_MapsLambdaStreamAPI;

import java.util.LinkedHashMap;
import java.util.Map;

public class demo3 {
    public static void main(String[] args) {
        Map<String, Double> fruits = new LinkedHashMap<>();
        fruits.put("banana", 2.20);
        fruits.put("kiwi", 4.50);
        for (var entry : fruits.entrySet()) {
            System.out.printf("%s -> %.2f%n",
                    entry.getKey(), entry.getValue());
        }


    }
}

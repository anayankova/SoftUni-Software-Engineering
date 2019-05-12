package h_MapsLambdaStreamAPI;

import java.util.HashMap;
import java.util.Map;

public class demo14SortingMultiply {
    public static void main(String[] args) {
        Map<Integer, String> products = new HashMap<>(1,2);
        products.entrySet()
                .stream()
                .sorted((e1, e2) -> {
                    int res = e2.getValue().compareTo(e1.getValue());
                    if (res == 0) {
                        res = e1.getKey().compareTo(e2.getKey());
                    }
                    return res; })
                .forEach(e -> System.out.println(e.getKey() + " " + e.getValue()));


    }
}

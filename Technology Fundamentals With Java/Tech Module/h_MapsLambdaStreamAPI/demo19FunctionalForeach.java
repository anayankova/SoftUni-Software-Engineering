package h_MapsLambdaStreamAPI;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class demo19FunctionalForeach {
    public static void main(String[] args) {
        Map<String, ArrayList<Integer>> arr = new HashMap<>();

        arr.entrySet().stream()
                .sorted((a, b) -> {
                    if (a.getKey().compareTo(b.getKey()) == 0) {
                        int sumFirst = a.getValue().stream().mapToInt(x -> x).sum();
                        int sumSecond = b.getValue().stream().mapToInt(x -> x).sum();
                        return sumFirst - sumSecond;
                    }
                    return b.getKey().compareTo(a.getKey());
                })
                .forEach(pair -> {
                    System.out.println("Key: " + pair.getKey());
                    System.out.print("Value: ");
                    pair.getValue().sort((a, b) -> a.compareTo(b));
                    for (int num : pair.getValue()) {
                        System.out.printf("%d ", num);
                    }
                    System.out.println();
                });



    }
}

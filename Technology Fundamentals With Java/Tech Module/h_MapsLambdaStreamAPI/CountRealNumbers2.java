package h_MapsLambdaStreamAPI;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountRealNumbers2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] nums = Arrays.stream(scanner.nextLine().split(" "))
                .mapToDouble(Double::parseDouble).toArray();
        Map<Double, Integer> someMap = new TreeMap<>();
        for (double num : nums) {
            someMap.putIfAbsent(num, 0);
            int oldValue = someMap.get(num);
            someMap.put(num, oldValue + 1);
        }

        String pattern = "%.0f -> %d";

        someMap.entrySet()
                .stream()
                .sorted((a,b) -> {
                    return Double.compare(b.getKey(),a.getKey());
                })
                .forEach(entry -> System.out.println(
                        String.format(pattern, entry.getKey(), entry.getValue())));

        //for (Map.Entry<Double, Integer> entry : someMap.entrySet()) {
        //System.out.println(String.format(pattern,entry.getKey(), entry.getValue()));
        //}

    }
}

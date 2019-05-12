package h_MapsLambdaStreamAPI;

import java.util.*;

public class DemoExam {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, LinkedHashMap<String, List<Double>>>
                army = new LinkedHashMap<>();

        List<String> keys = new ArrayList<>();

        keys.addAll(army.keySet());

        army.entrySet().stream()
                .sorted((e1, e2) -> e2.getKey().compareTo(e1.getKey()))
                .forEach(System.out::println);

        army.get("String").get("String").add(4.45);

        army.get("String").get("String").stream()
                .sorted((e1,e2) -> Double.compare(e2,e1))
                .forEach(System.out :: println);

        army.forEach((key, value) -> keys.add(key));

        keys.stream().sorted(Comparator.reverseOrder())
                .forEach(e -> {
                    LinkedHashMap<String,List<Double>>
                        result = army.get(e);
                });

    }
}

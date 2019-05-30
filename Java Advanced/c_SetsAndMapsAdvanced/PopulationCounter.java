package c_SetsAndMapsAdvanced;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class PopulationCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        LinkedHashMap<String, LinkedHashMap<String, Long>> populationCounter = new LinkedHashMap();

        while (!input.equalsIgnoreCase("report")) {

            String[] tokens = input.split("\\|");

            String city = tokens[0];
            String country = tokens[1];
            long population = Long.parseLong(tokens[2]);

            if (!populationCounter.containsKey(country)) {
                populationCounter.put(country, new LinkedHashMap<>() {{put(city, population);}});
            } else {
                populationCounter.get(country).putIfAbsent(city, population);
            }

            input = scanner.nextLine();

        }

        populationCounter.entrySet().stream().sorted((f, s) -> {
            Long firstPopulation = populationCounter.get(f.getKey()).entrySet()
                    .stream().mapToLong(Map.Entry::getValue).sum();

            Long secondPopulation = populationCounter.get(s.getKey()).entrySet()
                    .stream().mapToLong(Map.Entry::getValue).sum();

            return secondPopulation.compareTo(firstPopulation);

        }).forEach(entry -> {

            long totalPopulation = entry.getValue().values()
                    .stream().mapToLong(value -> value).sum();

            //int[] totalPopulation = new int[1];
            //entry.getValue().values()
            //        .stream()
            //        .forEach(value -> totalPopulation[0] += value);

            System.out.println(String.format("%s (total population: %d)", entry.getKey(), totalPopulation));

            entry.getValue().entrySet()
                    .stream()
                    .sorted((f, s) -> s.getValue().compareTo(f.getValue()))
                    .forEach(e -> {
                        System.out.println(String.format("=>%s: %d", e.getKey(), e.getValue()));
                    });
        });

    }
}

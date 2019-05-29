package c_SetsAndMapsAdvanced;

import java.util.*;
import java.util.stream.Collectors;

public class AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, List<Double>> studentsAndGrades = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();

            String[] tokens = line.split("\\s+");

            studentsAndGrades.putIfAbsent(tokens[0], new ArrayList<>());
            studentsAndGrades.get(tokens[0]).add(Double.parseDouble(tokens[1]));
        }

        studentsAndGrades.forEach((name, grades) -> {
            String allGrades = grades.stream()
                    .map(g -> String.format("%.2f", g))
                    .collect(Collectors.joining(" "));

            double avg = grades.stream().mapToDouble(e -> e).average().orElse(0d);

            System.out.println(String.format("%s -> %s (avg: %.2f)", name,allGrades, avg));
        });

    }
}

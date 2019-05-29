package c_SetsAndMapsAdvanced;

import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class AcademyGraduation2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, List<Double>> result = new TreeMap<>();

        while (!(n-- == 0)) {
            String name = scanner.nextLine();

            List<Double> grades = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .map(Double::parseDouble).collect(Collectors.toList());

            result.putIfAbsent(name, new ArrayList<>());
            result.get(name).addAll(grades);
        }

        //DecimalFormat format = new DecimalFormat("#.###############");

        result.forEach((name, grades) -> {

            double sum2 = 0;

            for(Double grade : grades){
                sum2 += grade;
            }
            double avg = sum2 / grades.size();

            System.out.println(String.format("%s is graduated with %s", name, avg));
        });


    }
}

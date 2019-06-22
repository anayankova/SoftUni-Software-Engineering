package j_Exams;

import java.util.*;

public class MakeASalad {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> vegetables = new ArrayDeque<>();
        ArrayDeque<Integer> calories = new ArrayDeque<>();

        List<Integer> salads = new ArrayList<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .forEach(vegetables::offer);

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(calories::push);

        int lastCalories = calories.peekFirst();

        while (vegetables.size() > 0 && calories.size() > 0) {
            String firstVegetable = vegetables.poll();
            int vegetableCalories = vegetableCalories(firstVegetable);

            if (lastCalories > vegetableCalories) {
                lastCalories -= vegetableCalories;

            } else {
                salads.add(calories.pop());
                if (!calories.isEmpty()) {
                    lastCalories = calories.peekFirst();
                }
            }

        }

        salads.forEach(e -> System.out.print(e + " "));

        System.out.println();

        if (!vegetables.isEmpty()) {
            vegetables.forEach(e -> System.out.print(e + " "));
        }

        if (!calories.isEmpty()) {
            calories.forEach(e -> System.out.print(e + " "));
        }


    }

    private static int vegetableCalories(String vegetable) {
        switch (vegetable) {
            case "tomato":
                return 80;
            case "carrot":
                return 136;
            case "lettuce":
                return 109;
            case "potato":
                return 215;
        }
        return -1;
    }
}

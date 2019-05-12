package i_TextProcessingAndRegularExpressions;

import java.util.*;

public class Race {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] names = sc.nextLine().split(", ");
        Map<String, Integer> nameAndDistance = new LinkedHashMap<>();

        for (int i = 0; i < names.length; i++) {
            nameAndDistance.putIfAbsent(names[i], 0);
        }

        String line = "";

        while (!"end of race".equals(line = sc.nextLine())) {
            String name = "";
            int distance = 0;

            for (int i = 0; i < line.length(); i++) {
                char symbol = line.charAt(i);

                if (Character.isLetter(symbol)) {
                    name += symbol;
                } else if (Character.isDigit(symbol)) {
                    distance += Integer.parseInt(symbol + "");
                }
            }

            if (nameAndDistance.containsKey(name)) {
                nameAndDistance.put(name, nameAndDistance.get(name) + distance);
            }
        }

        List<String> winners = new ArrayList<>();

        nameAndDistance.entrySet().stream().sorted((m1, m2) -> {
            int diff = Integer.compare(m2.getValue(), m1.getValue());
            return diff;
        }).limit(3).forEach(e -> winners.add(e.getKey()));

        System.out.printf("1st place: %s%n", winners.get(0).trim());
        System.out.printf("2nd place: %s%n", winners.get(1).trim());
        System.out.printf("3rd place: %s", winners.get(2).trim());

    }
}

package j_FinalExams;

import java.util.*;

public class Dictionary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> words = new TreeMap<>();
        Map<String, List<String>> calledWords = new LinkedHashMap<>();

        String input = scanner.nextLine();

        while (true) {
            String[] data = input.split("\\s+\\|\\s+");

            for (String s : data) {
                String[] items = s.split(":\\s+");

                String word = items[0];
                String definition = items[1];

                if (!words.containsKey(word)) {
                    words.put(word, new ArrayList<>());
                }
                words.get(word).add(definition);
            }

            data = scanner.nextLine().split("\\s+\\|\\s+");

            for (String s : data) {
                words.entrySet().stream()
                        .filter(e -> e.getKey().equals(s))
                        .forEach(e -> calledWords.put(e.getKey(), e.getValue()));
            }

            String command = scanner.nextLine();

            if (command.equals("List")) {
                words.forEach((key, value) -> System.out.print(String.format("%s ", key)));
                break;
            }

            if (command.equals("End")) {
                break;
            }

        }

        //calledWords.forEach((key, value) -> {
            //value.stream().sorted((a, b) -> Integer.compare(a.length(),b.length()));
        //});

        //for (Map.Entry<String, List<String>> kvp : calledWords.entrySet()) {
            //System.out.printf("%s%n", kvp.getKey());
            //kvp.getValue().stream().sorted().forEach(v -> System.out.printf(" -%s%n", v));
        //}

        calledWords.forEach((key, value) -> {
            System.out.printf("%s%n", key);
            value.stream().sorted((m1, m2) -> Integer.compare(m2.length(), m1.length()))
                    .forEach(f -> System.out.println(String.format(" -%s", f)));
        });


    }
}

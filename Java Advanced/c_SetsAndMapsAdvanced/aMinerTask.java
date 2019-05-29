package c_SetsAndMapsAdvanced;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class aMinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = "";

        Map<String, Integer> tasks = new LinkedHashMap<>();

        while (!(input = scanner.nextLine()).equals("stop")) {
            int count = Integer.parseInt(scanner.nextLine());
            if (!tasks.containsKey(input)) {
                tasks.put(input, count);
            } else {
                tasks.put(input, tasks.get(input) + count);
            }
        }

        for (Map.Entry<String, Integer> keyValuePair : tasks.entrySet()) {
            System.out.println(keyValuePair.getKey() + " -> " + keyValuePair.getValue());
        }

        //tasks.forEach((key, value) -> System.out.println(key + value));

    }
}

package h_MapsLambdaStreamAPI;

import java.util.*;

public class CompanyUsers2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeMap<String, Set<String>> users = new TreeMap<>();
        String input = "";
        while (!"End".equals(input = scanner.nextLine())) {
            String[] data = Arrays.stream(input.split("\\s+->\\s+"))
                    .toArray(String[]::new);

            String name = data[0];
            String id = data[1];

            if (!users.containsKey(name)) {
                users.put(name, new LinkedHashSet<>());
            }
                users.get(name).add(id);
        }

        for (Map.Entry<String, Set<String>> kvp : users.entrySet()) {
            System.out.println(String.format("%s", kvp.getKey()));
            kvp.getValue().forEach(e -> System.out.println(String.format("-- %s", e)));
        }

    }
}

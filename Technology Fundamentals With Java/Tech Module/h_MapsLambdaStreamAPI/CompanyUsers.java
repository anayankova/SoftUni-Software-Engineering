package h_MapsLambdaStreamAPI;

import java.util.*;

public class CompanyUsers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeMap<String, List<String>> users = new TreeMap<>();
        String input = "";
        while (!"End".equals(input = scanner.nextLine())) {
            String[] data = Arrays.stream(input.split("\\s+->\\s+"))
                    .toArray(String[]::new);

            String name = data[0];
            String id = data[1];

            if (!users.containsKey(name)) {
                users.put(name, new ArrayList<>());
            }

            if (!users.get(name).contains(id)) {
                users.get(name).add(id);
            }
        }

        for (Map.Entry<String, List<String>> kvp : users.entrySet()) {
            System.out.println(String.format("%s", kvp.getKey()));
            kvp.getValue().forEach(e -> System.out.println(String.format("-- %s", e)));
        }

    }
}

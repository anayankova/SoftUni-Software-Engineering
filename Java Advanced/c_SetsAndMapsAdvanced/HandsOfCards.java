package c_SetsAndMapsAdvanced;

import java.util.*;

public class HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = "";

        Map<String, Set<String>> items = new LinkedHashMap<>();

        while (!(input = scanner.nextLine()).equalsIgnoreCase("JOKER")) {
            String[] data = input.split(": ");

            String name = data[0];
            String[] cards = data[1].split(", ");

            if(!items.containsKey(name)){
                items.put(name, new LinkedHashSet<>());
                items.get(name).addAll(Arrays.asList(cards));
            }else {
                items.get(name).addAll(Arrays.asList(cards));
            }
        }

        items.forEach((k, v) ->
                System.out.println(k + " -> " + v));

    }
}

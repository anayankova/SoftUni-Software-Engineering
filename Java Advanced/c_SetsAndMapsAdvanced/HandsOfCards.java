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

            if (!items.containsKey(name)) {
                items.put(name, new LinkedHashSet<>());
                items.get(name).addAll(Arrays.asList(cards));
            } else {
                items.get(name).addAll(Arrays.asList(cards));
            }
        }

        Map<String, Integer> itemsCount = new LinkedHashMap<>();

        items.forEach((k, v) -> {
            itemsCount.put(k, 0);
            for (String s : v) {
                char digit = s.charAt(0);
                char letter = ' ';
                if (digit == '1') {
                    letter = s.charAt(2);
                } else {
                    letter = s.charAt(1);
                }
                int first = 0;
                int second = 0;

                if (digit == '2') {
                    first = 2;
                } else if (digit == '3') {
                    first = 3;
                } else if (digit == '4') {
                    first = 4;
                } else if (digit == '5') {
                    first = 5;
                } else if (digit == '6') {
                    first = 6;
                } else if (digit == '7') {
                    first = 7;
                } else if (digit == '8') {
                    first = 8;
                } else if (digit == '9') {
                    first = 9;
                } else if (digit == '1') {
                    first = 10;
                } else if (digit == 'J') {
                    first = 11;
                } else if (digit == 'Q') {
                    first = 12;
                } else if (digit == 'K') {
                    first = 13;
                } else if (digit == 'A') {
                    first = 14;
                }

                if (letter == 'S') {
                    second = 4;
                } else if (letter == 'H') {
                    second = 3;
                } else if (letter == 'D') {
                    second = 2;
                } else if (letter == 'C') {
                    second = 1;
                }

                int multiply = first * second;
                itemsCount.put(k, itemsCount.get(k) + multiply);
            }
        });

        itemsCount.forEach((k, v) ->
                System.out.println(k + ": " + v));


    }
}

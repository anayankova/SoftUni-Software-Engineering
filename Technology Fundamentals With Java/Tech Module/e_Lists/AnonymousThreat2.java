package e_Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AnonymousThreat2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> elements = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        String input = "";

        while (!"3:1".equals(input = scanner.nextLine())) {
            String[] data = input.split("\\s+");
            String command = data[0];

            switch (command) {
                case "merge":
                    int startIndex = Integer.parseInt(data[1]);
                    int endIndex = Integer.parseInt(data[2]);
                    startIndex = validateIndex(startIndex, elements.size());
                    endIndex = validateIndex(endIndex, elements.size());

                    String concatElements = String.join("", elements.subList(startIndex, endIndex + 1));

                    //elements = elements.stream().filter(e -> !e.equals(""))
                    //.collect(Collectors.toList());

                    //String concatElements =  elements.subList(startIndex,endIndex)
                    //.stream().filter(e -> !e.equals(""))
                    //.collect(Collectors.joining(""));

                    //String concatElements = elements.subList(startIndex,endIndex).stream()
                    //.collect(Collectors.joining(""));

                    elements.subList(startIndex, endIndex + 1).clear();
                    elements.add(startIndex, concatElements);

                    break;
                case "divide":
                    int index = Integer.parseInt(data[1]);
                    int partitions = Integer.parseInt(data[2]);

                    List<String> result = dividedEqually(elements.get(index), partitions);
                    elements.remove(index);
                    elements.addAll(index, result);
                    break;
            }
        }

        System.out.println(String.join(" ", elements));

    }

    private static List<String> dividedEqually(String element, int partitions) {
        int part = element.length() / partitions;
        ArrayList<String> result = new ArrayList<>();

        while (element.length() >= part) {
            result.add(element.substring(0, part));
            element = element.substring(part);
        }
        if (result.size() == partitions) {
            return result;
        } else {
            String concatLastTwoElements = result.get(result.size() - 2)
                    .concat(result.get(result.size() - 1));
            result.subList(result.size() - 2, result.size()).clear();
            result.add(concatLastTwoElements);
            return result;
        }
    }

    private static int validateIndex(int index, int length) {
        if (index < 0) {
            index = 0;
        }
        if (index > length - 1) {
            index = length - 1;
        }
        return index;
    }
}

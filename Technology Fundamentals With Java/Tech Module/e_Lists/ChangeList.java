package e_Lists;

import java.sql.DataTruncation;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ChangeList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> elements = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        String input = "";

        while (!"end".equals(input = scanner.nextLine())) {

            String[] data = input.split("\\s+");

            String command = data[0];

            switch (command) {
                case "Delete":
                    elements = elements.stream().filter(e -> !e.equals(data[1])).collect(Collectors.toList());
                    break;
                case "Insert":
                    String element = data[1];
                    int position = Integer.parseInt(data[2]);

                    if (position >= 0 && position < elements.size()) {
                        elements.add(position, element);
                    }
                    break;
            }


        }

        System.out.println(elements.toString().replaceAll("[\\[,\\]]",""));


    }
}

package e_FunctionalProgramming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.function.Predicate;

public class ThePartyReservationFilterModule {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] names = scanner.nextLine().split("\\s+");

        String command = scanner.nextLine();

        HashMap<String, Predicate<String>> predicates = new HashMap<>();

        while (!command.equals("Print")) {

            String[] tokens = command.split(";");

            String filterName = tokens[1] + tokens[2];

            String type = tokens[1];

            String criteria = tokens[2];

            if (tokens[0].contains("Add")) {

                Predicate<String> predicate;

                if (type.contains("Starts")) {
                    predicate = str -> str.startsWith(criteria);
                } else if (type.contains("Ends")) {
                    predicate = str -> str.endsWith(criteria);
                } else if (type.contains("Length")) {
                    predicate = str -> str.length() == Integer.parseInt(criteria);
                } else {
                    predicate = str -> str.contains(criteria);
                }

                predicates.putIfAbsent(filterName, predicate);
            } else {
                predicates.remove(filterName);
            }

            command = scanner.nextLine();
        }

        Arrays.stream(names).forEach(name -> {
            boolean[] hasToBeFiltered = new boolean[1];
            predicates.forEach((k, v) -> {
                if (v.test(name)) {
                    hasToBeFiltered[0] = true;
                }
            });
            if(!hasToBeFiltered[0]){
                System.out.print(name + " ");
            }
        });

    }
}

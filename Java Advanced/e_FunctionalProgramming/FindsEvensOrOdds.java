package e_FunctionalProgramming;

import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class FindsEvensOrOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        String type = scanner.nextLine();

        int lowerBound = Integer.parseInt(input[0]);
        int upperBound = Integer.parseInt(input[1]);

        Predicate<Integer> filterEven = x -> x % 2 == 0;
        Predicate<Integer> filterOdd = x -> x % 2 != 0;
        Predicate<Integer> byType = filterEven;

        if (type.equals("odd")) {
            byType = filterOdd;
        }

        IntStream
                .rangeClosed(lowerBound, upperBound)
                .boxed()
                .filter(byType)
                .forEach(x -> System.out.print(x + " "));

    }
}

package e_FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");
        Function<String, Integer> function = s -> Integer.parseInt(s);

        List<Integer> numbers = Arrays.stream(input)
                .map(function)
                .collect(Collectors.toList());

        System.out.println("Count = " + numbers.size());

        int sum = numbers.stream()
                .reduce(0, (a, b) -> a + b);

        System.out.println("Sum = " + sum);

    }
}

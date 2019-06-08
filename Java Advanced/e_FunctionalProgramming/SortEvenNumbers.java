package e_FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SortEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] stringNumbers = scanner.nextLine().split(", ");

        List<Integer> evenNumbers = Arrays.stream(stringNumbers)
                .map(Integer::parseInt)
                .filter(x -> x % 2 == 0)
                .collect(Collectors.toList());

        List<String> numbers = evenNumbers.stream()
                .map(String::valueOf)
                .collect(Collectors.toList());

        String evenNums = String.join(", ", numbers);
        System.out.println(evenNums);

        evenNumbers.sort(Integer::compareTo);
        List<String> evenSorted = evenNumbers.stream()
                .map(String::valueOf)
                .collect(Collectors.toList());

        evenNums = String.join(", ", evenSorted);
        System.out.println(evenNums);

    }
}

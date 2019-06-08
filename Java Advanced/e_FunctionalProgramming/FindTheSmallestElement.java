package e_FunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class FindTheSmallestElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        Function<int[], Integer> minNumber = arr -> {
            int min = Arrays.stream(arr).min().getAsInt();
            return min;
        };

        int index = 0;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == minNumber.apply(numbers)) {
                index = i;
            }
        }

        System.out.println(index);

    }
}

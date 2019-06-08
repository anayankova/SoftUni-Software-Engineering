package e_FunctionalProgramming;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class CustomComparator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] numbersAsString = scanner.nextLine().split("\\s+");

        Integer[] numbers = new Integer[numbersAsString.length];

        for (int i = 0; i < numbersAsString.length; i++) {
            numbers[i] = Integer.parseInt(numbersAsString[i]);
        }


        Comparator<Integer> comparator = (f, s) -> {
            int result;
            if (f % 2 == 0 && s % 2 != 0) {
                result = -1;
            } else if (s % 2 == 0 && f % 2 != 0) {
                result = 1;
            } else {
                result  = f - s;
            }
            return result;
        };

        Arrays.sort(numbers, comparator);

        for (Integer number : numbers) {
            System.out.print(number + " ");
        }

    }
}

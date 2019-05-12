package d_Methods;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayToString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");

        int[] numbers = new int[input.length];

        for (int i = 0; i < input.length ; i++) {
            numbers[i] = Integer.parseInt(input[i]);
        }

        System.out.println(Arrays.toString(numbers));
        System.out.println(String.join(" ",input));
        System.out.println(Arrays.toString(input));

    }
}

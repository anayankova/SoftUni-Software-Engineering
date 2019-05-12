package c_Arrays;

import java.util.Scanner;

public class MagicSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");

        int[] numbers = new int[input.length];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(input[i]);
        }

        int n = Integer.parseInt(scanner.nextLine());

        boolean isUnique = true;

        for (int i = 0; i < numbers.length; i++) {


            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == n) {
                    isUnique = true;
                } else {
                    isUnique = false;
                }

                if (isUnique) {
                    System.out.println(numbers[i] + " " + numbers[j]);
                }

            }

        }


    }
}

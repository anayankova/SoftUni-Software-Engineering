package c_Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class ZigZagArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];

        for (int i = 0; i < n; i++) {
            int[] input = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < input.length - 1; j++) {
                arr2[i] = input[j];
                arr1[i] = input[j + 1];
            }
        }

        for (int i = 0; i < n; i += 2) {
            int temp = 0;
            temp = arr2[i];
            arr2[i] = arr1[i];
            arr1[i] = temp;
        }

        System.out.println(Arrays.toString(arr1) + " ");
        System.out.println(Arrays.toString(arr2) + " ");

        String firstOutput = String.join(" ", Arrays.toString(arr1));
        String secondOutput = String.join(" ", Arrays.toString(arr2));

        System.out.println(firstOutput);
        System.out.println(secondOutput);


    }
}

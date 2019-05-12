package c_Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class TopIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] arr = Arrays.stream(scanner.nextLine()
                .split(" "))
                .mapToInt(Integer::parseInt).toArray();

        boolean isTrue = false;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                isTrue = arr[i] > arr[j];

            }
            if (isTrue) {
                System.out.print(arr[i]+" ");
            }
        }

        System.out.println(arr[arr.length - 1]);

    }
}

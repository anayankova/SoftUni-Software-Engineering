package c_Arrays;

import java.util.Scanner;

public class ArrayRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] arr1 = scanner.nextLine().split(" ");
        String old = arr1[0];

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < arr1.length; j++) {
                if (j == arr1.length - 1) {
                    arr1[arr1.length - 1] = old;
                } else {
                    arr1[j] = arr1[j + 1];
                }
            }
            old = arr1[0];
        }

        System.out.println(String.join(" ", arr1));

    }


}


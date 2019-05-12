package c_Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class demoEvenAndOddSubstraction2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int evenSum = 0;
        int oddSum = 0;
        for (int num : arr) {
            if (num % 2 == 0) {
                evenSum += num;
            } else {
                oddSum += num;
            }
        }
        //TODO: Find the difference and print it
        int difference = Math.abs(evenSum-oddSum);
        System.out.println(difference);


    }
}

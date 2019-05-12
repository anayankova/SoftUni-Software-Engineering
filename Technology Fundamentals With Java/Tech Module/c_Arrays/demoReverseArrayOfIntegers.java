package c_Arrays;

import java.util.Scanner;

public class demoReverseArrayOfIntegers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read the array (n lines of integers)
        int n = Integer.parseInt(sc.nextLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(sc.nextLine());
        // Print the elements from the last to the first
        for (int i = n-1; i >= 0; i--)
            System.out.print(arr[i] + " ");
            System.out.println();


    }
}

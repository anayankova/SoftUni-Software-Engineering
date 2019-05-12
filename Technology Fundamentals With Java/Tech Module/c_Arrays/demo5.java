package c_Arrays;

import java.util.Scanner;

public class demo5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String values = sc.nextLine();
        String[] items = values.split(" ");
        int[] arr = new int[items.length];

        for (int i = 0; i < items.length; i++)
            arr[i] = Integer.parseInt(items[i]);


    }
}

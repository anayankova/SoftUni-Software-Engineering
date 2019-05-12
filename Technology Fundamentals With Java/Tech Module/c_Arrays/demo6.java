package c_Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class demo6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String inputLine = sc.nextLine();
        String[] items = inputLine.split(" ");
        int[] arr = Arrays.stream(items).mapToInt(e -> Integer.parseInt(e)).toArray();



    }
}

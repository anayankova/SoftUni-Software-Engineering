package c_Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class demo7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = Arrays.stream(sc.nextLine()
                .split(" "))
                .mapToInt(Integer::parseInt).toArray();



    }
}

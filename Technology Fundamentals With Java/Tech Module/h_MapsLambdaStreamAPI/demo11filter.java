package h_MapsLambdaStreamAPI;

import java.util.Arrays;
import java.util.Scanner;

public class demo11filter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] nums = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e))
                .filter(n -> n > 0)
                .toArray();
        System.out.println(Arrays.toString(nums));


    }
}

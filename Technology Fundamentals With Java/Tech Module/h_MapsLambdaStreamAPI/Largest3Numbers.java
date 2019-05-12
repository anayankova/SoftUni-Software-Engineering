package h_MapsLambdaStreamAPI;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Largest3Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> nums = Arrays
                .stream(scanner.nextLine().split(" "))
                .map(e -> Integer.parseInt(e))
                .sorted((n1, n2) -> n2.compareTo(n1))
                .collect(Collectors.toList());
        int count = nums.size() >= 3 ? 3 : nums.size();
        for (int i = 0; i < count; i++)
            System.out.print(nums.get(i) + " ");


    }
}

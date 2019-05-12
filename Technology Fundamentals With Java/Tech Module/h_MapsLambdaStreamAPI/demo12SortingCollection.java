package h_MapsLambdaStreamAPI;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class demo12SortingCollection {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> nums = Arrays.stream(scanner.nextLine().split(" "))
        .collect(Collectors.toList());

        nums = nums.stream()
                .sorted((n1, n2) -> n1.compareTo(n2))
                .collect(Collectors.toList());

        System.out.println(nums);

        nums = nums.stream()
                .sorted((n1, n2) -> n2.compareTo(n1))
                .collect(Collectors.toList());

        System.out.println(nums);


    }
}

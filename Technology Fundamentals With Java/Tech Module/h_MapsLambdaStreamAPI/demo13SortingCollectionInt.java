package h_MapsLambdaStreamAPI;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class demo13SortingCollectionInt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> nums = Arrays.stream(scanner.nextLine().split(" "))
        .map(Integer::parseInt).collect(Collectors.toList());

        nums = nums.stream()
                .sorted((n1, n2) -> n1.compareTo(n2))
                .collect(Collectors.toList());  //Ascending order

        System.out.println(nums);

        nums = nums.stream()
                .sorted((n1, n2) -> n2.compareTo(n1))
                .collect(Collectors.toList());   //Descending order

        System.out.println(nums);



    }
}

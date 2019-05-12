package e_Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class demo5Reading {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String values = scanner.nextLine();
        List<String> items = Arrays.stream(values.split(" "))
                .collect(Collectors.toList());
        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < items.size(); i++) {
            nums.add(Integer.parseInt(items.get(i)));
            System.out.println(nums);
            System.out.println(nums.get(i));
        }

        System.out.println(nums);

        for (Integer aNums : nums) {
            System.out.print(aNums + " ");

        }


    }
}

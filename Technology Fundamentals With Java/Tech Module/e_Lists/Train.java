package e_Lists;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //sub list

        List<Integer> nums = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        int maxCapacity = Integer.parseInt(scanner.nextLine());

        String[] input = new String[2];

        while (!"end".equals(input[0])){
            input = scanner.nextLine().split("\\s+");

            if (input[0].equals("Add")){
                nums.add(Integer.parseInt(input[1]));
            }

        }

    }
}

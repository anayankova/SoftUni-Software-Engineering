package h_MapsLambdaStreamAPI;

import java.util.*;

public class WordFilter2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> nums = new ArrayList<>();

        nums.add(100);
        nums.add(1);
        nums.add(5);
        nums.add(10);
        nums.add(100);

        nums.stream().sorted(Collections.reverseOrder())
                .forEach(System.out::println);

        Arrays.stream(scanner.nextLine().split(" "))
                .filter(w -> w.length() % 2 == 0)
                .forEach(e -> System.out.println(e));

    }
}

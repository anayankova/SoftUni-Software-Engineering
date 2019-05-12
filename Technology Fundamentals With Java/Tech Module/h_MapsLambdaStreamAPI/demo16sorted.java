package h_MapsLambdaStreamAPI;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class demo16sorted {
    public static void main(String[] args) {
        String[] nums = {"1", "6", "5", "23", "54", "105", "200"};

        List<Integer> numsAsList = Arrays.stream(nums)
                .map(Integer::parseInt)
                .filter(n -> n>10)
                .sorted((a,b) -> Integer.compare(b,a))
                .limit(1)
                .collect(Collectors.toList());

        System.out.println(numsAsList);

    }
}

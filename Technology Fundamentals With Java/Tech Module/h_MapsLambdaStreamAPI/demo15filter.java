package h_MapsLambdaStreamAPI;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class demo15filter {
    public static void main(String[] args) {
        String[] nums = {"1", "6", "5", "23", "54", "105", "200"};

        List<Integer>numsAsList = Arrays.stream(nums)
                .map(Integer::parseInt)
                .filter(n -> n>10)
                .skip(1)
                .limit(2)
                .collect(Collectors.toList());

        System.out.println(numsAsList);

    }
}

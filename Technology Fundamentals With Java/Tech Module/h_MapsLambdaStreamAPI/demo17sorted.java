package h_MapsLambdaStreamAPI;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class demo17sorted {
    public static void main(String[] args) {
        String[] nums = {"1", "6", "5", "23", "54", "105", "200"};

        List<String> numsAsList = Arrays.stream(nums)
                .sorted((a,b) ->{
                    if(a.contains("5")){
                        return Integer.compare(b.length(),a.length());
                    }
                    return a.compareTo(b);
                })
                .collect(Collectors.toList());

        System.out.println(numsAsList);

    }
}

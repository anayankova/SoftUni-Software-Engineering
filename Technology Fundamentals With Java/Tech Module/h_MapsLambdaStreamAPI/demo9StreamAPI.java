package h_MapsLambdaStreamAPI;

import java.util.ArrayList;

public class demo9StreamAPI {
    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>() {{
            add(15); add(25); add(35);
        }};
        int min = nums.stream().mapToInt(Integer::intValue)
                .min().getAsInt();
        System.out.println(min);

        int min1 = nums.stream()
                .min(Integer::compareTo).get();
        System.out.println(min1);

        int sum = nums.stream()
                .mapToInt(Integer::intValue).sum();
        System.out.println(sum);

        double avg = nums.stream()
                .mapToInt(Integer::intValue)
                .average()
                .getAsDouble();
        System.out.println(avg);





    }
}

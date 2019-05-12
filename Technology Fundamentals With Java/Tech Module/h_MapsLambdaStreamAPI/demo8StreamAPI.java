package h_MapsLambdaStreamAPI;

import java.util.Arrays;

public class demo8StreamAPI {
    public static void main(String[] args) {
        int min = Arrays.stream(new int[]{15, 25, 35}).min().getAsInt();
        System.out.println(min);

        int min1 = Arrays.stream(new int[]{15, 25, 35}).min().orElse(2);
        System.out.println(min1);

        int min2 = Arrays.stream(new int[]{}).min().orElse(2); // 2
        System.out.println(min2);

        int max = Arrays.stream(new int[]{15, 25, 35}).max().getAsInt();
        System.out.println(max);

        int sum = Arrays.stream(new int[]{15, 25, 35}).sum();
        System.out.println(sum);

        double avg = Arrays.stream(new int[]{15, 25, 35})
                .average().getAsDouble();
        System.out.println(avg);


    }
}

package h_MapsLambdaStreamAPI;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Largest3Numbers2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .map(n -> Integer.parseInt(n))
                .sorted(Collections.reverseOrder())
                .limit(3)
                .map(n -> String.valueOf(n))
                .collect(Collectors.joining(" ")));

    }
}

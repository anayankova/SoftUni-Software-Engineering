package e_Lists;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

public class AppendArrays {
    public static void main(String[] args) throws IOException {

        System.out.println(Arrays.stream(new BufferedReader(
                new InputStreamReader(
                        System.in
                )
        ).readLine().split("\\|+"))
                .filter(e1 -> !e1.matches("\\s+"))
                .map(e -> Arrays.stream(e.split("\\s+"))
                        .filter(e1 -> !e1.equals(""))
                        .collect(Collectors.toList()))
                .collect(Collectors.collectingAndThen(Collectors.toList(),
                        strings -> {
                            Collections.reverse(strings);
                            return strings;
                        }))
        .toString().replaceAll("[\\[\\],]", ""));


    }
}

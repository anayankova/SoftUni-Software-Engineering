package h_MapsLambdaStreamAPI;

import java.util.Arrays;
import java.util.Scanner;

public class demo10StreamAPImap {
    public static void main(String[] args) {
        //Scanner scanner = new Scanner(System.in);
       // int[] nums = Arrays.stream(scanner.nextLine().split(" "))
                //.mapToInt(e -> Integer.parseInt(e))
               // .toArray();

        String[] words = {"abc", "def", "geh", "yyy"};
        words = Arrays.stream(words)
                .map(w -> w + "yyy")
                .toArray(String[]::new);

        System.out.println(Arrays.toString(words));
            //abcyyy, defyyy, gehyyy, yyyyyy


    }
}

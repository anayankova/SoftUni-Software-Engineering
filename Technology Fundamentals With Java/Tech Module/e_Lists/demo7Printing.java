package e_Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class demo7Printing {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList(
                "one", "two", "three", "four", "five", "six"));
        for (int index = 0; index < list.size(); index++)
            System.out.printf
                    ("arr[%d] = %s%n", index, list.get(index));

        System.out.println(String.join("; ", list));



    }
}

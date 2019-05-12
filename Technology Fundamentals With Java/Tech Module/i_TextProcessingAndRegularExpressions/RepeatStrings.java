package i_TextProcessingAndRegularExpressions;

import java.util.Scanner;

public class RepeatStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] words = scanner.nextLine().split(" ");
        String result = "";
        for (String word : words) {
            int repeatTimes = word.length();
            for (int i = 0; i < repeatTimes; i++)
                result += word;
        }
        System.out.println(result);


    }
}

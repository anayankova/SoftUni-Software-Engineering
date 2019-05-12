package i_TextProcessingAndRegularExpressions;

import java.util.Scanner;

public class ReplaceRepeatingChars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder input = new StringBuilder(scanner.nextLine());

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < input.length() - 1; i++) {
            if (input.charAt(i) != input.charAt(i + 1)) {
                result.append(input.charAt(i));
            }
        }
            result.append(input.charAt(input.length()-1));


        System.out.println(result);

    }
}

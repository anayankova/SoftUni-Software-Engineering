package i_TextProcessingAndRegularExpressions;

import java.util.Scanner;

public class CaesarCipher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String result = "";
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            result = input.replace(input.charAt(i), (char) (input.charAt(i) + 3));
            sb.append(result.charAt(i));

        }
        System.out.println(sb);


    }
}

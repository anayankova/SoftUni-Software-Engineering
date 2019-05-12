package i_TextProcessingAndRegularExpressions;

import java.util.Scanner;

public class StringExplosion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        String result = "";
        int strength = 0;

        for (int i = 0; i < text.length(); i++) {

            result += text.charAt(i);

            if (text.charAt(i) == '>') {
                strength += Integer.parseInt(String.valueOf(text.charAt(i + 1)));
            }

            while (strength > 0) {
                strength--;
                i++;


                if (i + 1 >= text.length() || text.charAt(i + 1) == '>') {
                    break;
                }
            }

        }
        System.out.println(result);

    }
}

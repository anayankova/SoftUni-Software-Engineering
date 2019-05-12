package d_Methods;

import java.util.Scanner;

public class PalindromeIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = "";

        while (!"END".equals(input = scanner.nextLine())) {

            boolean isPalindrom = true;

            for (int i = 0; i < input.length() / 2; i++) {
                if (input.charAt(i) != input.charAt(input.length() - i - 1)) {
                    isPalindrom = false;
                }
            }
            System.out.println(isPalindrom);
        }
    }
}

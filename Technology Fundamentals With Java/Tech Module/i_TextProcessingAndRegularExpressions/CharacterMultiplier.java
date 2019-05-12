package i_TextProcessingAndRegularExpressions;

import java.util.Scanner;

public class CharacterMultiplier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        String firstWord = text.substring(0, text.indexOf(' '));
        String secondWord = text.substring(text.lastIndexOf(' ') + 1);  //!!!!!!! lastIndexOf word.....word

        System.out.println(multiplyCharacters(firstWord,secondWord));


    }

    private static int multiplyCharacters(String first, String second) {
        int minLength = Math.min(first.length(), second.length());
        int sum = 0;

        for (int i = 0; i < minLength; i++) {
            sum += first.charAt(i) * second.charAt(i);

        }
        String maxLength = first.length() < second.length() ? second : first;

        for (int i = minLength; i < maxLength.length(); i++) {
            sum += maxLength.charAt(i);

        }
        return sum;
    }
}

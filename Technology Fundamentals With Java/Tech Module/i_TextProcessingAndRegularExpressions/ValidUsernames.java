package i_TextProcessingAndRegularExpressions;

import java.util.Scanner;

public class ValidUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] words = scanner.nextLine().split(", ");

        for (String word : words) {
            if(validateWord(word)){
                System.out.println(word);
            }
            
        }

    }

    private static boolean validateWord(String word) {
        if (word.length() < 3 || word.length() > 16) {
            return false;

        }

        // String validate = "-_";

        for (int i = 0; i < word.length(); i++) {
            if(!Character.isLetterOrDigit(word.charAt(i))
                    // validate.indexOf(word.charAt(i)) != -1
            && word.charAt(i) != '-'
            && word.charAt(i) !=  '_'){
                return false;
            }

        }
        return true;
        //String validate = "" +
               // "abcdefghijklmnopqrstuvwxyz" +
               // "ABCDEFGHIJKLMNOPQRSTUVWXYZ" +
               // "-_";
        //for (int i = 0; i < word.length(); i++) {
           // if(validate.indexOf(word.charAt(i)) != -1);

       // }

    }
}

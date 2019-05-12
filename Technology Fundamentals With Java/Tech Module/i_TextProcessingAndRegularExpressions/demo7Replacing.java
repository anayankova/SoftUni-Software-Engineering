package i_TextProcessingAndRegularExpressions;

public class demo7Replacing {
    public static void main(String[] args) {

        //replace(match, replacement) – replaces all occurrences
        //The result is a new string (strings are immutable)

        String text = "Hello, john@softuni.bg, you have been using john@softuni.bg in your registration.";
        String replacedText = text
                .replace("john@softuni.bg", "john@softuni.com");
        System.out.println(replacedText);
        // Hello, john@softuni.com, you have been using john@softuni.com in your registration.


    }
}

package i_TextProcessingAndRegularExpressions;

public class demo6Spliting {
    public static void main(String[] args) {

        //Split a string by given pattern

        String text = "Hello, john@softuni.bg, you have been using john@softuni.bg in your registration";
        String[] words = text.split(", ");
        // words[]: "Hello", "john@softuni.bg","you have been…"

        //Split by multiple separators
        String text1 = "Hello, I am John.";
        String[] words1 = text1.split("[, .]+");
        // "Hello", "I", "am", "John"



    }
}

package i_TextProcessingAndRegularExpressions;

public class demo15SplitWithRegex {
    public static void main(String[] args) {
        String text = "1   2 3      4";
        String pattern = "\\s+";

        String[] tokens = text.split(pattern);


    }
}

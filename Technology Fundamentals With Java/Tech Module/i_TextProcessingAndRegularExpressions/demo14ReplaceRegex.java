package i_TextProcessingAndRegularExpressions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class demo14ReplaceRegex {
    public static void main(String[] args) {
        String regex = "[A-Za-z]+";
        String string = "Hello Java";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(string);

        String res = matcher.replaceAll("hi");    // hi hi
        String res2 = matcher.replaceFirst("hi"); // hi Java


    }
}

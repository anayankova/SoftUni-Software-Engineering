package i_TextProcessingAndRegularExpressions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class demo13Regex {
    public static void main(String[] args) {
        String text = "Andy: 123";
        String pattern = "([A-Z][a-z]+): (?<number>\\d+)";

        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(text);

        System.out.println(matcher.find());   		// true
        System.out.println(matcher.group());  		// Andy: 123
        System.out.println(matcher.group(0)); 		// Andy: 123
        System.out.println(matcher.group(1)); 		// Andy
        System.out.println(matcher.group(2)); 		// 123
        System.out.println(matcher.group("number")); // 123


    }
}

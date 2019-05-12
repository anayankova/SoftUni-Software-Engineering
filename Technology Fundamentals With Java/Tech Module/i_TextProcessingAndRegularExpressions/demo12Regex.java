package i_TextProcessingAndRegularExpressions;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class demo12Regex {
    public static void main(String[] args) {
        String text = "Ivan Ivanov, Georgi Georgiev, Stamat   Georgiev, AGeorgi gEorgiev";

        String[] input = text.split(", ");
        List<String> validResults = new ArrayList<>();
        String inputRegex = "\\";
        Pattern pattern1 = Pattern.compile(Pattern.quote(inputRegex),Pattern.MULTILINE);

        Pattern pattern = Pattern.compile("^[A-Za-z]+ [A-Za-z]+$");

        for (String name : input) {
            Matcher matcher = pattern.matcher(name);

            boolean hasMatch = matcher.find();
            if (hasMatch){
                String matchName = matcher.group();
                validResults.add(matchName);
            }
            
        }
        System.out.println(validResults);

    }
}

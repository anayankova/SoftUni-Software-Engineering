package i_TextProcessingAndRegularExpressions;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchDates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] dates = scanner.nextLine().split(", ");
        Pattern pattern = Pattern.compile("^(?<day>\\d{2})(\\.|\\/|\\-)(?<month>[A-Z][a-z]{2})\\2(?<year>\\d{4})$");

        for (String date : dates) {
            Matcher matcher = pattern.matcher(date);

            if(matcher.find()){
                System.out.println(String.format("Day: %s, Month: %s, Year: %s",
                        matcher.group("day"), matcher.group("month"), matcher.group("year")));
            }

        }

    }
}

package j_FinalExams;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Deciphering {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String result = "";
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            result = input.replace(input.charAt(i), (char) (input.charAt(i) - 3));
            sb.append(result.charAt(i));
        }

        String[] substrings = scanner.nextLine().split("\\s+");

        String firstSubstring = substrings[0];
        String secondSubstring = substrings[1];

        String replacedSb = sb.toString().replace(firstSubstring,secondSubstring);

        String regex = "^[ABCa-z\\{\\}\\|\\#\\s]+$";

        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(replacedSb);

        if(matcher.find()){
            System.out.println(replacedSb);
        }else {
            System.out.println("This is not the book you are looking for.");
        }


    }
}

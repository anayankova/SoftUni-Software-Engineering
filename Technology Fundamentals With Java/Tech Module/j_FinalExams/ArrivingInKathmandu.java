package j_FinalExams;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ArrivingInKathmandu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = "";

        while (!(input=scanner.nextLine()).equals("Last note")) {

            String regex = "^(?<name>[A-Za-z\\d!@#$?]+)=(?<length>[\\d]+)<<(?<geohashCode>.+)";

            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                String name = matcher.group("name");
                int length = Integer.parseInt(matcher.group("length"));
                String geohashCode = matcher.group("geohashCode");
                String nameOfPeak = "";

                for (int i = 0; i < name.length(); i++) {
                    char symbol = name.charAt(i);

                    if (Character.isLetterOrDigit(symbol)) {
                        nameOfPeak += symbol;
                    }
                }

                if (length == geohashCode.length()) {
                    System.out.println(String.format("Coordinates found! %s -> %s", nameOfPeak, geohashCode));
                } else {
                    System.out.println("Nothing found!");
                }


            }else {
                System.out.println("Nothing found!");
            }
        }

    }
}

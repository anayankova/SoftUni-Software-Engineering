package j_FinalExams;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ActivationKeys {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] lineOfCodes = scanner.nextLine().split("&");

        List<String> validCodes = new ArrayList<>();

        for (String s : lineOfCodes) {
            if (s.length() == 16 || s.length() == 25) {
                String reg = "^([a-zA-Z0-9]+)$";
                Pattern pattern = Pattern.compile(reg);
                Matcher matcher = pattern.matcher(s);

                if (matcher.find()) {
                    char[] validCode = matcher.group(0).toUpperCase().toCharArray();
                    String finalCodeString = "";
                    if (validCode.length == 16) {
                        for (int i = 0; i < validCode.length; i++) {
                            if (i % 4 == 0 && i != 0) {
                                finalCodeString += "-";
                            }
                            finalCodeString = getString(validCode, finalCodeString, i);

                        }
                    } else {
                        for (int i = 0; i < validCode.length; i++) {
                            if (i % 5 == 0 && i != 0) {
                                finalCodeString += "-";
                            }
                            finalCodeString = getString(validCode, finalCodeString, i);

                        }
                    }
                    validCodes.add(finalCodeString);

                }
            }
        }

        System.out.println(validCodes.toString().replaceAll("[\\[\\]]", ""));

    }

    private static String getString(char[] validCode, String finalCodeString, int i) {
        if (validCode[i] >= '0' && validCode[i] <= '9') {
            int finalValue = 9 - Character.getNumericValue(validCode[i]);
            finalCodeString += finalValue;
        } else {
            finalCodeString += String.valueOf(validCode[i]);
        }
        return finalCodeString;
    }
}
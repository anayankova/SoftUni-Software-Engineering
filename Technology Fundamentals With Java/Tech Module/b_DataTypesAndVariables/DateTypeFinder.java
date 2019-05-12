package b_DataTypesAndVariables;

import java.util.Scanner;

public class DateTypeFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {

            String text = scanner.nextLine();
            if (text.equals("END")) {
                break;
            }

            char symbol = text.charAt(0);
            String t = symbol + "";

            if (text.equals("true") || text.equals("false")) {
                System.out.printf("%s is boolean type%n", text);
            } else if (text.equals(t) && Character.isLetter(symbol)) {
                System.out.printf("%c is character type%n", symbol);
            } else if (!text.equals(t) && Character.isLetter(symbol)) {
                System.out.printf("%s is string type%n", text);
            } else {

                float number =Float.parseFloat(text);

                if (number == (int)number) {
                    System.out.printf("%.0f is integer type%n", number);
                } else {
                    System.out.printf("%f is floating point type%n", number);
                }
            }

        }

    }
}

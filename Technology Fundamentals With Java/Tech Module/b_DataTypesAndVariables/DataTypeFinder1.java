package b_DataTypesAndVariables;

import java.util.Scanner;

public class DataTypeFinder1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        while (!command.equals("END")) {
            try {
                Integer.parseInt(command);
                System.out.printf("%s is integer type%n", command);
                command = scanner.nextLine();
                continue;
            } catch (Exception ignored) {
            }
            try {
                Double.parseDouble(command);
                System.out.printf("%s is floating point type%n", command);
                command = scanner.nextLine();
                continue;
            } catch (Exception ignored) {
            }
            if (command.toLowerCase().equals("true") || command.toLowerCase().equals("false")) {
                System.out.printf("%s is boolean type%n", command);
            }else if (command.length() == 1 &&
                    (command.charAt(0) < 48 || command.charAt(0) > 57)) {
                System.out.printf("%s is character type%n", command);
            }else {
                System.out.printf("%s is string type%n", command);
            }
            command = scanner.nextLine();
        }

    }
}

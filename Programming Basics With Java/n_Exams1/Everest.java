package n_Exams1;

import java.util.Scanner;

public class Everest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int days = 1;
        int height = 5364;

        while (days < 5) {
            String sleep = scanner.nextLine();
            if (sleep.equals("END")) {
                break;
            }
            if (sleep.equals("Yes")) {
                days++;
            } else if (sleep.equals("No")) {
                days = days;
            }
            int meters = Integer.parseInt(scanner.nextLine());
            height += meters;
            if (height >= 8848) {
                break;
            }
        }

        if (height > 8848) {
            System.out.printf("Goal reached for %d days!", days);
        } else {
            System.out.println("Failed!");
            System.out.println(height);
        }

    }
}

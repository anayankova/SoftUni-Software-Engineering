package n_Exams1;

import java.util.Scanner;

public class ProjectPrize {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        double award = Double.parseDouble(scanner.nextLine());
        int sum = 0;

        for (int i = 1; i <= n; i++) {
            int points = Integer.parseInt(scanner.nextLine());
            if (i % 2 == 0) {
                sum += points * 2;
            } else {
                sum += points;
            }

        }

        double total = sum * award;
        System.out.printf("The project prize was %.2f lv.",total);

    }
}

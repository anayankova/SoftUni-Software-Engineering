package k_ForLoop_Exercise;

import java.util.Scanner;

public class DivideWithoutReminder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        int group1 = 0;
        int group2 = 0;
        int group3 = 0;

        for (int i = 1; i <= n; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            if (number % 2 == 0) {
                group1++;
            }
            if (number % 3 == 0) {
                group2++;
            }
            if (number % 4 == 0) {
                group3++;
            }
        }

        double p1 = group1 * 1.0 / n * 100;
        double p2 = group2 * 1.0 / n * 100;
        double p3 = group3 * 1.0 / n * 100;

        System.out.printf("%.2f%%%n",p1);
        System.out.printf("%.2f%%%n",p2);
        System.out.printf("%.2f%%%n",p3);

    }
}

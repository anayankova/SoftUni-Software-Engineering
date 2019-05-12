package k_ForLoop_Exercise;

import java.util.Scanner;

public class Histogram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        int group1 = 0;
        int group2 = 0;
        int group3 = 0;
        int group4 = 0;
        int group5 = 0;

        for (int i = 1; i <= n; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            if (number < 200) {
                group1++;
            }
            if (number >= 200 && number <= 399) {
                group2++;
            }
            if (number >= 400 && number <= 599) {
                group3++;
            }
            if (number >= 600 && number <= 799) {
                group4++;
            }
            if (number >= 800) {
                group5++;
            }
        }

        double p1 = group1 * 1.0 / n * 100;
        double p2 = group2 * 1.0 / n * 100;
        double p3 = group3 * 1.0 / n * 100;
        double p4 = group4 * 1.0 / n * 100;
        double p5 = group5 * 1.0 / n * 100;

        System.out.printf("%.2f%%%n", p1);
        System.out.printf("%.2f%%%n", p2);
        System.out.printf("%.2f%%%n", p3);
        System.out.printf("%.2f%%%n", p4);
        System.out.printf("%.2f%%%n", p5);

    }
}

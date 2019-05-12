package g_NestedConditionalStatements_Exercise;

import java.util.Scanner;

public class OperationsBetweenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N1 = Integer.parseInt(scanner.nextLine());
        int N2 = Integer.parseInt(scanner.nextLine());
        char operator = scanner.nextLine().charAt(0);

        double result = 0;

        if (operator == '+') {
            result = N1 + N2;
            if (result % 2 == 0) {
                System.out.printf("%d %c %d = %.0f - even", N1, operator, N2, result);
            } else {
                System.out.printf("%d %c %d = %.0f - odd", N1, operator, N2, result);
            }
        } else if (operator == '-') {
            result = N1 - N2;
            if (result % 2 == 0) {
                System.out.printf("%d %c %d = %.0f - even", N1, operator, N2, result);
            } else {
                System.out.printf("%d %c %d = %.0f - odd", N1, operator, N2, result);
            }
        } else if (operator == '*') {
            result = N1 * N2;
            if (result % 2 == 0) {
                System.out.printf("%d %c %d = %.0f - even", N1, operator, N2, result);
            } else {
                System.out.printf("%d %c %d = %.0f - odd", N1, operator, N2, result);
            }
        } else if (operator == '/') {
            result = N1 * 1.0 / N2;
            if (N2 == 0) {
                System.out.printf("Cannot divide %d by zero", N1);
            } else {
                System.out.printf("%d %c %d = %.2f", N1, operator, N2, result);
            }
        } else if (operator == '%') {
            result = N1 * 1.0 % N2;
            if (N2 == 0) {
                System.out.printf("Cannot divide %d by zero", N1);
            } else {
                System.out.printf("%d %c %d = %.0f", N1, operator, N2, result);
            }
        }
    }
}
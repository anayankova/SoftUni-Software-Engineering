package d_Methods;

import java.util.Scanner;

public class FactorialDivision2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double first = Double.parseDouble(scanner.nextLine());
        double second = Double.parseDouble(scanner.nextLine());

        double result = factorialM(first) / factorialM(second);
        System.out.printf("%.2f", result);
    }

    static double factorialM(double number) {
        double factorial = 1;

        for (int i = 2; i <= number; i++) {
            factorial *= i;
        }
        return factorial;
    }
}

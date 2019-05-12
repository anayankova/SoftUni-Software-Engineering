package d_Methods;

import java.util.Scanner;

public class FactorialDivisioin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());

        if (a >= 0 && b >= 0) {
            int resultA = 1;
            int resultB = 1;

            if (a != 0) {
                for (int i = 1; i <= a; i++) {
                    resultA *= i;
                }
            }
            if (b != 0) {
                for (int i = 1; i <= b; i++) {
                    resultB *= i;
                }
            }
            double divide = resultA * 1.0 / resultB;

            System.out.printf("%.2f", divide);

        }
    }
}

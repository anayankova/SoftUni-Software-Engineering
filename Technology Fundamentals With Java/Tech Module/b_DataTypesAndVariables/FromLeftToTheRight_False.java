package b_DataTypesAndVariables;

import java.util.Scanner;

public class FromLeftToTheRight_False {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n; i++) {
            String input = scanner.nextLine();

            String[] numbers = input.split(" ");

            double left = Double.parseDouble(numbers[0]);
            double right = Double.parseDouble(numbers[1]);

            left = Math.abs(left);
            right = Math.abs(right);

            int sum = 0;

            if (left > right) {
                double length = Double.toString(left).length();

                for (double j = 0; j < length; j++) {
                    double last = left % 10;
                    left = (left - last) / 10;
                    sum += last;
                }
            } else {
                double length = Double.toString(right).length();

                for (double j = 0; j < length; j++) {
                    double last = right % 10;
                    right = (right - last) / 10;
                    sum += last;
                }
            }
            System.out.println(sum);

        }

    }
}

package b_DataTypesAndVariables;

import java.util.Scanner;

public class FromLeftToRight {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        // leftNum = Math.abs(leftNum);
        // rightNum = Math.abs(rightNum);

        for (int i = 1; i <= n; i++) {
            String[] input;
            String a, b;
            input = scanner.nextLine().split(" ");
            a = input[0];
            b = input[1];
            double leftNum = Double.parseDouble(a); //long
            double rightNum = Double.parseDouble(b); //long
            int sum = 0;
            if (leftNum >= rightNum && leftNum != 0) {
                leftNum = Math.abs(leftNum);
                while (leftNum > 0) {
                    sum += leftNum % 10;
                    leftNum /= 10;
                }
            } else if (rightNum > leftNum && rightNum != 0) {
                rightNum = Math.abs(rightNum);
                while (rightNum > 0) {
                    sum += rightNum % 10;
                    rightNum /= 10;
                }
            }
            System.out.println(sum);
        }


    }

}


package b_DataTypesAndVariables;

import java.util.Scanner;

public class FromLeftToTheRight2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

       // leftNum = Math.abs(leftNum);
       // rightNum = Math.abs(rightNum);

        for (int i = 1; i <= n; i++) {
            String[] input = new String[2];
            String a, b;
            input = scanner.nextLine().split(" ");
            a = input[0];
            b = input[1];
            double leftNum = Double.parseDouble(a); //long
            double rightNum = Double.parseDouble(b); //long
            int sum = 0;
            if (leftNum >= rightNum) {
                for (int j = 0; j < a.length(); j++) {
                    char symA = a.charAt(j);
                    int numA = Integer.parseInt(symA + "");
                    sum += numA;
                    //sum += Integer.parseInt(String.valueOf(a.charAt(j)));
                }
            } else {
                for (int j = 0; j < b.length(); j++) {
                    char symB = b.charAt(j);
                    int numB = Integer.parseInt(symB + "");
                    sum += numB;
                    //sum += Integer.parseInt(String.valueOf(b.charAt(j)));
                }
            }
            System.out.println(sum);

        }

    }
}

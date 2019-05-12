package m_NestedLoop_Exercise;

import java.util.Scanner;

public class EqualSumsEvenOddPosition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num1 = Integer.parseInt(scanner.nextLine());
        int num2 = Integer.parseInt(scanner.nextLine());

        for (int i = num1; i <= num2; i++) {
            String n = i + "";
            int count = 0;
            int oddSum = 0;
            int evenSum = 0;
            while (count < 6) {
                int num = Integer.parseInt(n.charAt(count) + "");
                if (count % 2 == 0) {
                    oddSum += num;
                } else {
                    evenSum += num;
                }
                count++;
            }

            if (oddSum == evenSum) {
                System.out.print(i + " ");
            }


        }

    }
}

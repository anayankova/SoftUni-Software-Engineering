package k_ForLoop_Exercise;

import java.util.Scanner;

public class EqualParis {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int lastPair = 0;
        int diffMax = 0;

        for (int i = 0; i < n; i++) {
            int num1 = Integer.parseInt(scanner.nextLine());
            int num2 = Integer.parseInt(scanner.nextLine());

            int currentPair = num1 + num2;

            if (i >= 1) {
                int diff = Math.abs(currentPair - lastPair);
                if (diff > diffMax) {
                    diffMax = diff;
                }
            }

            lastPair = currentPair;
        }

        if (diffMax == 0) {
            System.out.printf("Yes, value = %d", lastPair);
        } else {
            System.out.printf("No, maxdiff = %d", diffMax);
        }

    }
}

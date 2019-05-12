package m_NestedLoop_Exercise;

import java.util.Scanner;

public class SpecialNumbersPart2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1111; i <= 9999; i++) {
            int thousands = i / 1000;
            int hundreds = (i / 100) % 10;
            int decimals = (i / 10) % 10;
            int ed = i % 10;

            boolean checkFirst = thousands != 0 && n % thousands == 0;
            boolean checkSecond = hundreds != 0 && n % hundreds == 0;
            boolean checkThird = decimals != 0 && n % decimals == 0;
            boolean checkForth = ed != 0 && n % ed == 0;

            if (checkFirst && checkSecond && checkThird && checkForth) {
                System.out.print(i + " ");
            }
        }

    }
}

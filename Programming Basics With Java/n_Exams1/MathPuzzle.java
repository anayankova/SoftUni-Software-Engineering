package n_Exams1;

import java.util.Scanner;

public class MathPuzzle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int key = Integer.parseInt(scanner.nextLine());
        boolean isKey = false;

        for (int a = 1; a <= 30; a++) {
            for (int b = 1; b <= 30; b++) {
                for (int c = 1; c <= 30; c++) {
                    if (a < b && b < c && a + b + c == key) {
                        System.out.printf("%d + %d + %d = %d%n", a, b, c, key);
                        isKey = true;
                    } else if (a > b && b > c && a * b * c == key) {
                        System.out.printf("%d * %d * %d = %d%n", a, b, c, key);
                        isKey = true;
                    }

                }

            }

        }

        if (!isKey){
            System.out.println("No!");
        }

    }
}

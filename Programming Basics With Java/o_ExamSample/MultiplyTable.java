package o_ExamSample;

import java.util.Scanner;

public class MultiplyTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String num = n + "";
        int a = Integer.parseInt(num.charAt(0) + "");
        int b = Integer.parseInt(num.charAt(1) + "");
        int c = Integer.parseInt(num.charAt(2) + "");

        int result = 0;

        for (int i = 1; i <= c; i++) {
            for (int j = 1; j <= b; j++) {
                for (int k = 1; k <= a; k++) {
                    result = i * j * k;
                    System.out.printf("%d * %d * %d = %d;%n",i,j,k,result);

                }

            }

        }


    }
}

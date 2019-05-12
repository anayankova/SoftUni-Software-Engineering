package o_ExamSample;

import java.util.Scanner;

public class Bus {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int stops = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= stops; i++) {
            int out = Integer.parseInt(scanner.nextLine());
            n -= out;
            int in = Integer.parseInt(scanner.nextLine());
            n += in;
            if (i % 2 != 0) {
                n += 2;
            } else {
                n -= 2;
            }
        }

        System.out.println("The final number of passengers is : " + n);

    }
}

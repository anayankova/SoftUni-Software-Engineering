package k_ForLoop_Exercise;

import java.util.Scanner;

public class demo2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double n = Double.parseDouble(scanner.nextLine());
        String a = "No";

        if (n > 10) {
            n = 20;
        } else {
            a = Double.toString(n);
            a = String.valueOf(n);
        }

        System.out.println(n);


    }
}

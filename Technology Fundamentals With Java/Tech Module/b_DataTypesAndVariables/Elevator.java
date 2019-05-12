package b_DataTypesAndVariables;

import java.util.Scanner;

public class Elevator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int p = Integer.parseInt(scanner.nextLine());

        double courses = 0;

        if (n / p == 0) {
            courses = Math.ceil(n * 1.0 / p);
        } else {
            if (n % p == 0) {
                courses = Math.ceil(n * 1.0 / p);
            } else {
                courses = Math.floor(n*1.0/p)+Math.ceil((n-(Math.floor(n*1.0/p))*p)/p);
            }
        }

        System.out.printf("%.0f",courses);

    }
}

package b_SimpleCalculation_Lab;

import java.util.Scanner;

public class CelsiusToFahrenheit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double a = Double.parseDouble(scanner.nextLine());
        double formula = a*1.8+32;
        System.out.printf("%.2f", formula);


    }
}

package b_SimpleCalculation_Lab;

import java.util.Scanner;

public class RadiansToDegrees {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double a = Double.parseDouble(scanner.nextLine());
        double formula = a*180/Math.PI;
        System.out.printf("%.0f", formula);


    }
}

package c_SimpleCalculation_Exercise;

import java.util.Scanner;

public class AreaRectangleXYline {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double x1 = Double.parseDouble(scanner.nextLine());
        double y1 = Double.parseDouble(scanner.nextLine());
        double x2 = Double.parseDouble(scanner.nextLine());
        double y2 = Double.parseDouble(scanner.nextLine());

        double sideA = Math.abs(x1-x2);
        double sideB = Math.abs(y1-y2);

        double area = sideA*sideB;
        double perimeter = 2*(sideA+sideB);

        System.out.println(area);
        System.out.println(perimeter);
        System.out.printf("%f%n%f",area,perimeter);
    }
}

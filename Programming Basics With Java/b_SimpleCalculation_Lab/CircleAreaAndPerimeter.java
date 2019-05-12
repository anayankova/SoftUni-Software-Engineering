package b_SimpleCalculation_Lab;

import java.util.Scanner;

public class CircleAreaAndPerimeter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double r = Double.parseDouble(scanner.nextLine());

        double area = Math.PI*r*r;
        double perimeter = Math.PI*2*r;

        System.out.println(area);
        System.out.println(perimeter);

    }
}

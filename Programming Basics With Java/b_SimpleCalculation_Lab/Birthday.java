package b_SimpleCalculation_Lab;

import java.util.Scanner;

public class Birthday {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double l= Double.parseDouble(scanner.nextLine());//дължина
        double w= Double.parseDouble(scanner.nextLine());//широчина
        double h= Double.parseDouble(scanner.nextLine());//височина
        double p= Double.parseDouble(scanner.nextLine());//процент

        double area = l*w*h;
        double liters = area*0.001;
        double percent = p*0.01;
        double result = liters*(1-percent);

        System.out.printf("%.3f", result);
    }
}

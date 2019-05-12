package d_ConditionStatements_Lab;

import java.util.Scanner;

public class Figures {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String figure = scanner.nextLine();

        //double result a = 0.0;

        if (figure.equals("square")) {
            //TODO square
            double a = Double.parseDouble(scanner.nextLine());
            System.out.printf("%.3f" , a * a);
            //result = a*a;
        } else if (figure.equals("rectangle")) {
            //TODO rec
            double a = Double.parseDouble(scanner.nextLine());
            double b = Double.parseDouble(scanner.nextLine());
            System.out.printf("%.3f", a*b);
        } else if (figure.equals("circle")) {
            //TODO circle
            double r = Double.parseDouble(scanner.nextLine());
            System.out.printf("%.3f",Math.PI*r*r);
        } else if (figure.equals("triangle")) {
            //TODO triangle
            double a = Double.parseDouble(scanner.nextLine());
            double h = Double.parseDouble(scanner.nextLine());
            System.out.printf("%.3f", a*h/2);
        }
    }
}

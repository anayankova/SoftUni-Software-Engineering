package d_Methods;

import java.util.Scanner;

public class CalculateRectangleArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double width = Double.parseDouble(scanner.nextLine());
        double height = Double.parseDouble(scanner.nextLine());
        double area = calcRectangleArea(width, height);
        System.out.printf("%.0f%n",area);

    }
    public static double calcRectangleArea(double width,
                                           double height) {
        return width * height;
    }

    //public static double calcRectangleArea(double width,
                                          // double height) {
        //double result = width * height;
        //String formatRes = String.format("%.0f", result);
        //int res = Integer.parseInt(formatRes);
        //return res;
    //}

}

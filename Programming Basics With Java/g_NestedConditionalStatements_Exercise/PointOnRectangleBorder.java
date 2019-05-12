package g_NestedConditionalStatements_Exercise;

import java.util.Scanner;

public class PointOnRectangleBorder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double x1 = Double.parseDouble(scanner.nextLine());
        double y1 = Double.parseDouble(scanner.nextLine());
        double x2 = Double.parseDouble(scanner.nextLine());
        double y2 = Double.parseDouble(scanner.nextLine());
        double x = Double.parseDouble(scanner.nextLine());
        double y = Double.parseDouble(scanner.nextLine());

        boolean checkEqualX = (x == x1) || (x == x2);
        boolean checkBetweenY = (y >= y1) && (y <= y2);
        boolean check1 = checkEqualX && checkBetweenY;

        boolean checkEqualY = (y == y1) || (y == y2);
        boolean checkBetweenX = (x >= x1) && (x <= x2);
        boolean check2 = checkEqualY && checkBetweenX;

        if(check1 || check2){
            System.out.println("Border");
        }else {
            System.out.println("Inside / Outside");
        }
    }
}

package c_SimpleCalculation_Exercise;

import java.util.Scanner;

public class USDtoBGN {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double usd = Double.parseDouble(scanner.nextLine());
        //въведи си доларите
        double bgn = usd*1.79549;
        String text = "BGN";
        //принтиране
        System.out.printf("%.2f %s", bgn, text);

    }
}

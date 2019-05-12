package b_DataTypesAndVariables;

import java.util.Scanner;

public class CenturiesConvertDouble {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double centuries = Double.parseDouble(scanner.nextLine());
        double years = centuries * 100;
        double days = years * 365.2422;
        double hours = 24 * days;
        double minutes = 60 * hours;
        System.out.printf(
                "%.0f centuries = %.0f years = %.0f days = %.0f hours = %.0f minutes",
                centuries, years, days, hours, minutes);

    }
}

package b_DataTypesAndVariables;

import java.util.Scanner;

public class demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Byte.parseByte(scanner.nextLine());
        byte centuries = 20;
        short years = 2000;
        int days = 730484;
        int hours = 17531625;
        long minutes = 1051897536;

        System.out.printf("%d centuries = %d years = %d days = %d hours = %d minutes.",
                centuries,years,days,hours,minutes);

        //20 centuries = 2000 years = 730484 days = 17531625 hours = 1051897536 minutes.
        //20 centuries = 2000 years = 730484 days = 17531616 hours = 1051896960 minutes  //int
        //20 centuries = 2000 years = 730484 days = 17531626 hours = 1051897536 minutes  //double

    }
}

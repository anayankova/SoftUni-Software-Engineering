package g_NestedConditionalStatements_Exercise;

import java.util.Scanner;

public class Journey {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double budget = Double.parseDouble(scanner.nextLine());
        String season = scanner.nextLine();

        String destination = "";
        String kindOfHoliday = "";

        if (budget <= 100){
            destination = "Bulgaria";
            if (season.equals("summer")){
                kindOfHoliday = "Camp";
                budget = 0.3*budget;
            }else if (season.equals("winter")){
                kindOfHoliday = "Hotel";
                budget = 0.7*budget;
            }
        }else if (budget <= 1000){
            destination = "Balkans";
            if (season.equals("summer")){
                kindOfHoliday = "Camp";
                budget = 0.4*budget;
            }else if (season.equals("winter")){
                kindOfHoliday = "Hotel";
                budget = 0.8*budget;
            }
        }else if (budget > 1000){
            destination = "Europe";
            kindOfHoliday = "Hotel";
            budget = 0.9*budget;
        }

        System.out.printf("Somewhere in %s%n", destination);
        System.out.printf("%s - %.2f", kindOfHoliday,budget);

    }
}

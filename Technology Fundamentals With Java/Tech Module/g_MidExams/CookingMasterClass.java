package g_MidExams;

import java.util.Scanner;

public class CookingMasterClass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        int students = Integer.parseInt(scanner.nextLine());
        double priceOfFlour = Double.parseDouble(scanner.nextLine());
        double priceOfEgg = Double.parseDouble(scanner.nextLine());
        double priceOfApron = Double.parseDouble(scanner.nextLine());

        int freePackage = 0;

        if (students >= 5) {
            freePackage = students / 5;
        }

        double costOfItems = priceOfApron * (students + Math.ceil(0.2 * students))
                + priceOfEgg * 10 * students + priceOfFlour * (students - freePackage);

        if (costOfItems <= budget) {
            System.out.printf("Items purchased for %.2f$.", costOfItems);
        } else {
            System.out.printf("%.2f$ more needed.", costOfItems - budget);
        }


    }
}

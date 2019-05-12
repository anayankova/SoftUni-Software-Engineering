package g_NestedConditionalStatements_Exercise;

import java.util.Scanner;

public class SummerOutfit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int degrees = Integer.parseInt(scanner.nextLine());
        String partOfDay = scanner.nextLine();

        String outfit = "";
        String shoes = "";

        if (degrees >= 10 && degrees <= 18) {
            if (partOfDay.equals("Morning")) {
                outfit = "Sweatshirt";
                shoes = "Sneakers";
            } else if (partOfDay.equals("Afternoon") || partOfDay.equals("Evening")) {
                outfit = "Shirt";
                shoes = "Moccasins";
            }

        } else if (degrees > 18 && degrees <= 24) {
            if (partOfDay.equals("Morning")) {
                outfit = "Shirt";
                shoes = "Moccasins";
            } else if (partOfDay.equals("Afternoon")) {
                outfit = "T-Shirt";
                shoes = "Sandals";
            } else if (partOfDay.equals("Evening")) {
                outfit = "Shirt";
                shoes = "Moccasins";
            }
        } else if (degrees >= 25) {
            if (partOfDay.equals("Morning")) {
                outfit = "T-Shirt";
                shoes = "Sandals";
            } else if (partOfDay.equals("Afternoon")) {
                outfit = "Swim Suit";
                shoes = "Barefoot";
            } else if (partOfDay.equals("Evening")) {
                outfit = "Shirt";
                shoes = "Moccasins";
            }
        }

        System.out.printf("It's %d degrees, get your %s and %s.", degrees, outfit, shoes);

    }
}

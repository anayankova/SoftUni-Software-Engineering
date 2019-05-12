package p_Exammm;

import java.util.Scanner;

public class PastryShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String type = scanner.nextLine();
        int count = Integer.parseInt(scanner.nextLine());
        int day = Integer.parseInt(scanner.nextLine());
        double price = 0;
        double priceWithDiscount = 0;
        double priceFinal = 0;

        if (day <= 15) {
            switch (type) {
                case "Cake":
                    price = count * 24;
                    break;
                case "Souffle":
                    price = count * 6.66;
                    break;
                case "Baklava":
                    price = count * 12.60;
                    break;
            }
            if (price >= 100 && price <= 200) {
                priceWithDiscount = price - 0.15 * price;
            } else if (price > 200) {
                priceWithDiscount = price - 0.25 * price;
            } else {
                priceWithDiscount = price;
            }
            priceFinal = priceWithDiscount - 0.1 * priceWithDiscount;
        } else {
            switch (type) {
                case "Cake":
                    price = count * 28.7;
                    break;
                case "Souffle":
                    price = count * 9.80;
                    break;
                case "Baklava":
                    price = count * 16.98;
                    break;
            }
            if (day <= 22) {
                if (price >= 100 && price <= 200) {
                    priceWithDiscount = price - 0.15 * price;
                } else if (price > 200) {
                    priceWithDiscount = price - 0.25 * price;
                } else {
                    priceWithDiscount = price;
                }
                priceFinal = priceWithDiscount;
            } else {
                priceFinal = price;
            }

        }
        System.out.printf("%.2f", priceFinal);
    }
}

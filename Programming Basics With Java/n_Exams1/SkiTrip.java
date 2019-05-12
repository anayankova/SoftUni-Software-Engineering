package n_Exams1;

import java.util.Scanner;

public class SkiTrip {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int days = Integer.parseInt(scanner.nextLine());
        String typeRoom = scanner.nextLine();
        String rating = scanner.nextLine();

        int price = 0;
        double discount = 0;

        switch (typeRoom) {
            case "room for one person":
                price = (days - 1) * 18;
                break;
            case "apartment":
                price = (days - 1) * 25;
                break;
            case "president apartment":
                price = (days - 1) * 35;
                break;
        }

        if ((days - 1) < 10) {
            switch (typeRoom) {
                case "room for one person":
                    discount = 0;
                    break;
                case "apartment":
                    discount = 30 * price * 1.0 / 100;
                    break;
                case "president apartment":
                    discount = 10 * price * 1.0 / 100;
                    break;
            }
        } else if ((days - 1) > 10 && (days - 1) < 15) {
            switch (typeRoom) {
                case "room for one person":
                    discount = 0;
                    break;
                case "apartment":
                    discount = 35 * price * 1.0 / 100;
                    break;
                case "president apartment":
                    discount = 15 * price * 1.0 / 100;
                    break;
            }
        } else if ((days - 1) > 15) {
            switch (typeRoom) {
                case "room for one person":
                    discount = 0;
                    break;
                case "apartment":
                    discount = 50 * price * 1.0 / 100;
                    break;
                case "president apartment":
                    discount = 20 * price * 1.0 / 100;
                    break;
            }
        }
        double priceWithDiscount = price - discount;
        double totalPrice = 0;
        if (rating.equals("positive")) {
            totalPrice = priceWithDiscount + priceWithDiscount * 25 / 100;
        } else if (rating.equals("negative")) {
            totalPrice = priceWithDiscount - priceWithDiscount * 10 / 100;
        }
        System.out.printf("%.2f",totalPrice);

    }
}

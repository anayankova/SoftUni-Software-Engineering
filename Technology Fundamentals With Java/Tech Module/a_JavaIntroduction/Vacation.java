package a_JavaIntroduction;

import java.util.Scanner;

public class Vacation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String group = scanner.nextLine();
        String day = scanner.nextLine();

        double price = 0;
        double totalPrice = 0;

        if ("Students".equals(group)) {
            switch (day) {
                case "Friday":
                    price = 8.45;
                    break;
                case "Saturday":
                    price = 9.80;
                    break;
                case "Sunday":
                    price = 10.46;
                    break;
            }
            if (n >= 30) {
                totalPrice = n * price - 0.15 * (n * price);
            } else {
                totalPrice = n * price;
            }
        } else if ("Business".equals(group)) {
            switch (day) {
                case "Friday":
                    price = 10.90;
                    break;
                case "Saturday":
                    price = 15.60;
                    break;
                case "Sunday":
                    price = 16;
                    break;
            }
            if (n >= 100) {
                totalPrice = (n - 10) * price;
            } else {
                totalPrice = n * price;
            }
        } else if ("Regular".equals(group)) {
            switch (day) {
                case "Friday":
                    price = 15;
                    break;
                case "Saturday":
                    price = 20;
                    break;
                case "Sunday":
                    price = 22.5;
                    break;
            }
            if (n >= 10 && n <= 20) {
                totalPrice = n * price - 0.05 * (n * price);
            } else {
                totalPrice = n * price;
            }
        }

        System.out.printf("Total price: %.2f",totalPrice);

    }
}

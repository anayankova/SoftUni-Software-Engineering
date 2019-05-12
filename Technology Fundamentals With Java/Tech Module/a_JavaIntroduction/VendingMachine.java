package a_JavaIntroduction;

import java.util.Scanner;

public class VendingMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        double money = 0;
        double sum = 0;

        while (!input.equals("Start")) {
            money = Double.parseDouble(input);
            if (money != 0.1 && money != 0.2 && money != 0.5 && money != 1 && money != 2) {
                System.out.printf("Cannot accept %.2f%n", money);
            } else {
                sum += money;
            }
            input = scanner.nextLine();
        }

        double price = 0;
        double moneyleft = sum;

        while (true) {
            String product = scanner.nextLine();
            if (product.equals("End")) {
                System.out.printf("Change: %.2f", moneyleft);
                break;
            }
            switch (product) {
                case "Nuts":
                    price = 2.0;
                    break;
                case "Water":
                    price = 0.7;
                    break;
                case "Crisps":
                    price = 1.5;
                    break;
                case "Soda":
                    price = 0.8;
                    break;
                case "Coke":
                    price = 1.0;
                    break;
                default:
                    System.out.println("Invalid product");
                    price = 0;
                    break;
            }

            if (product.equals("Coke") || product.equals("Soda") || product.equals("Crisps") ||
                    product.equals("Water") || product.equals("Nuts")) {
                if (moneyleft < price) {
                    System.out.println("Sorry, not enough money");
                } else {
                    System.out.println("Purchased " + product);
                    moneyleft -= price;
                }
            }

        }

    }
}

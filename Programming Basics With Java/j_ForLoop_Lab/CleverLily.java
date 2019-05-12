package j_ForLoop_Lab;

import java.util.Scanner;

public class CleverLily {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int age = Integer.parseInt(scanner.nextLine());
        double priceWash = Double.parseDouble(scanner.nextLine());
        int pricePerToy = Integer.parseInt(scanner.nextLine());

        int moneyAsPresent = 0;
        int sumMoneyAsPresent = 0;
        int toys = 0;
        int stolenMoney = 0;

        for (int i = 1; i <= age; i++) {
            if (i % 2 == 0) {
                moneyAsPresent += 10;
                sumMoneyAsPresent += moneyAsPresent;
                stolenMoney++;
            } else if (i % 2 != 0) {
                toys++;
            }
        }

        int allMoney = sumMoneyAsPresent - stolenMoney + toys * pricePerToy;

        if (allMoney >= priceWash) {
            System.out.printf("Yes! %.2f", allMoney - priceWash);
        } else {
            System.out.printf("No! %.2f", priceWash - allMoney);
        }

    }
}

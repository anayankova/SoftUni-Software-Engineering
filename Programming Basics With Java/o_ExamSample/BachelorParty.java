package o_ExamSample;

import java.util.Scanner;

public class BachelorParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int price = Integer.parseInt(scanner.nextLine());
        int priceGroup = 0;
        int allMoney = 0;
        int allGuest = 0;

        while (true) {
            String end = scanner.nextLine();
            if (end.equals("The restaurant is full")) {
                break;
            }
            int count = Integer.parseInt(end);
            if (count < 5) {
                priceGroup = count * 100;
                allMoney += priceGroup;
                allGuest += count;
            } else {
                priceGroup = count * 70;
                allMoney += priceGroup;
                allGuest += count;
            }
        }

        if (allMoney >= price) {
            System.out.printf("You have %d guests and %d leva left.", allGuest, allMoney - price);
        }else {
            System.out.printf("You have %d guests and %d leva income, but no singer.",allGuest,allMoney);
        }

    }
}

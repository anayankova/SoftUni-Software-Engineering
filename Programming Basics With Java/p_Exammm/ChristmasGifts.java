package p_Exammm;

import java.util.Scanner;

public class ChristmasGifts {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numAdults = 0;
        int numKids = 0;
        int moneyToys = 0;
        int moneySweaters = 0;

        while (true) {
            String text = scanner.nextLine();
            if (text.equals("Christmas")) {
                break;
            }
            int age = Integer.parseInt(text);
            if (age <= 16) {
                numKids++;
                moneyToys += 5;
            } else {
                numAdults++;
                moneySweaters += 15;
            }
        }

        System.out.printf("Number of adults: %d",numAdults);
        System.out.println();
        System.out.printf("Number of kids: %d",numKids);
        System.out.println();
        System.out.printf("Money for toys: %d",moneyToys);
        System.out.println();
        System.out.printf("Money for sweaters: %d",moneySweaters);

    }
}

package d_ConditionStatements_Lab;

import java.util.Scanner;

public class Shop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double price = Double.parseDouble(scanner.nextLine());
        int puzzle = Integer.parseInt(scanner.nextLine());
        int dolls = Integer.parseInt(scanner.nextLine());
        int bears = Integer.parseInt(scanner.nextLine());
        int minions = Integer.parseInt(scanner.nextLine());
        int trucks = Integer.parseInt(scanner.nextLine());

        //Shift + F6: сменяме променлива навсякъде

        double totalSum = puzzle * 2.6 + dolls * 3 + bears * 4.1 + minions * 8.2 + trucks * 2;

        int numberOfToys = puzzle+dolls+bears+minions+trucks;

        if (numberOfToys>=50){
            double discount = totalSum*0.25;
            totalSum = totalSum - discount;
        }

        double rent = totalSum *0.1;
        totalSum = totalSum - rent;

        double moneyLeft = totalSum-price;

        if (moneyLeft>=0){
            System.out.printf("Yes! %.2f lv left.", moneyLeft);
        }else {
            System.out.printf("Not enough money! %.2f lv needed.", Math.abs(moneyLeft));
        }



    }
}

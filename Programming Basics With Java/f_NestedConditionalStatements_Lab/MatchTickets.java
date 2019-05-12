package f_NestedConditionalStatements_Lab;

import java.util.Scanner;

public class MatchTickets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double budget = Double.parseDouble(scanner.nextLine());
        String type = scanner.nextLine();
        int personsCount = Integer.parseInt(scanner.nextLine());

        if(personsCount <= 4){
            budget = budget - budget*0.75;
        }else if (personsCount <= 9){
            budget = budget - budget*0.60;
        }else if (personsCount <= 24){
            budget = budget - budget*0.50;
        }else if (personsCount <= 49){
            budget = budget - budget*0.40;
        }else {
            budget = budget - budget*0.25;
        }

        double ticketsPrice = 0;
        if (type.equals("VIP")){
            ticketsPrice = personsCount * 499.99;
        }else if(type.equals("Normal")){
            ticketsPrice = personsCount * 249.99;
        }

        double result = budget - ticketsPrice;

        if (result>=0){
            System.out.printf("Yes! You have %.2f leva left.", result);
        }else {
            System.out.printf("Not enough money! You need %.2f leva.",Math.abs(result));
        }

    }
}

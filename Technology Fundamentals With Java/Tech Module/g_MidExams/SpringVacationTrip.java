package g_MidExams;

import java.util.Scanner;

public class SpringVacationTrip {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int days = Integer.parseInt(scanner.nextLine());
        double budget = Double.parseDouble(scanner.nextLine());
        int group = Integer.parseInt(scanner.nextLine());
        double fuel = Double.parseDouble(scanner.nextLine());
        double foodPerPerson = Double.parseDouble(scanner.nextLine());
        double priceRoomPerPerson = Double.parseDouble(scanner.nextLine());

        double foodExpenses = foodPerPerson * group * days;
        double priceHotel = priceRoomPerPerson * group * days;
        double allFuel = 0;
        double additionalExpenses = 0;
        double recievedMoney = 0;

        if (group > 10) {
            priceHotel = priceHotel - 0.25 * priceHotel;
        }

        double currentExpenses = foodExpenses + priceHotel;

        for (int i = 1; i <= days; i++) {
            double distance = Double.parseDouble(scanner.nextLine());
            allFuel = fuel * distance;
            currentExpenses += allFuel;

            if (i % 3 == 0 || i % 5 == 0){
                additionalExpenses = 0.4 * currentExpenses;
                currentExpenses += additionalExpenses;
            }

            if (i % 7 == 0){
                recievedMoney = currentExpenses / group;
                currentExpenses -= recievedMoney;
            }

        }

        if (currentExpenses <= budget){
            System.out.printf("You have reached the destination. You have %.2f$ budget left.",
                    budget - currentExpenses);
        }else {
            System.out.printf("Not enough money to continue the trip. You need %.2f$ more.",
                    currentExpenses - budget);
        }

    }
}

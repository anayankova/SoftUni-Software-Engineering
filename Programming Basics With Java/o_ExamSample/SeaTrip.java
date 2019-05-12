package o_ExamSample;

import java.util.Scanner;

public class SeaTrip {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double moneyFood = Double.parseDouble(scanner.nextLine());
        double moneySouvenir = Double.parseDouble(scanner.nextLine());
        double moneyHotel = Double.parseDouble(scanner.nextLine());

        double moneyBenzin = (420 * 1.0 / 100 * 7) * 1.85;
        double moneyFoodAndSouvenir = 3 * moneyFood + 3 * moneySouvenir;

        double moneyHotel1 = moneyHotel * 0.9;
        double moneyHotel2 = moneyHotel * 0.85;
        double moneyHotel3 = moneyHotel * 0.8;

        double moneyTotal = moneyBenzin + moneyFoodAndSouvenir + moneyHotel1 + moneyHotel2 + moneyHotel3;

        System.out.printf("Money needed: %.2f",moneyTotal);


    }
}

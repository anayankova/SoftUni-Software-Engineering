package k_ForLoop_Exercise;

import java.util.Scanner;

public class FamilyHouse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int months = Integer.parseInt(scanner.nextLine());

        int water = 20;
        int internet = 15;

        double sumElectricity = 0;
        double sumWater = months * water;
        double sumInternet = months * internet;
        double sumOther = 0;
        double sumAllMonths = 0;

        for (int i = 1; i <= months; i++) {
            double electricity = Double.parseDouble(scanner.nextLine());
            double sum = electricity + water + internet;
            double other = sum + 0.2 * sum;

            double sumForMonth = electricity + water + internet + other;
            sumAllMonths += sumForMonth;
            sumElectricity += electricity;
            sumOther += other;
        }

        System.out.printf("Electricity: %.2f lv%n",sumElectricity);
        System.out.printf("Water: %.2f lv%n",sumWater);
        System.out.printf("Internet: %.2f lv%n",sumInternet);
        System.out.printf("Other: %.2f lv%n",sumOther);

        double average = sumAllMonths/months;
        System.out.printf("Average: %.2f lv",average);

    }
}

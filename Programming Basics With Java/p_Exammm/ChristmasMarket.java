package p_Exammm;

import java.util.Scanner;

public class ChristmasMarket {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double needMoney = Double.parseDouble(scanner.nextLine());
        int countFantasy = Integer.parseInt(scanner.nextLine());
        int countHorror = Integer.parseInt(scanner.nextLine());
        int coutRomantic = Integer.parseInt(scanner.nextLine());

        double sum = countFantasy * 14.90 + countHorror * 9.80 + coutRomantic * 4.30;
        double sumWithDds = sum - 0.2 * sum;

        if (sumWithDds > needMoney) {
            double bonus = Math.floor(0.1 * (sumWithDds - needMoney));
            double totalSum = needMoney + (sumWithDds - needMoney - bonus);
            System.out.printf("%.2f leva donated.%nSellers will receive %.0f leva.", totalSum, bonus);
        } else {
            System.out.printf("%.2f money needed.", needMoney - sumWithDds);
        }

    }
}

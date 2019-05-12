package n_Exams1;

import java.util.Scanner;

public class TrekkingEquipment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int alpinists = Integer.parseInt(scanner.nextLine());
        int carabiners = Integer.parseInt(scanner.nextLine());
        int ropes = Integer.parseInt(scanner.nextLine());
        int picelles = Integer.parseInt(scanner.nextLine());

        double priceCarabiners = carabiners * 36;
        double priceRopes = ropes * 3.60;
        double pricePicelles = picelles * 19.80;

        double sumPer1 = priceCarabiners + pricePicelles + priceRopes;
        double sumTotal = alpinists * sumPer1;
        double total = sumTotal + 0.2 * sumTotal;

        System.out.printf("%.2f",total);


    }
}

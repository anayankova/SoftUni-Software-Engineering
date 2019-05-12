package p_Exammm;

import java.util.Scanner;

public class ChristmasSweets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double priceBak = Double.parseDouble(scanner.nextLine());
        double priceMuf = Double.parseDouble(scanner.nextLine());
        double kgShtolen = Double.parseDouble(scanner.nextLine());
        double kgCandy = Double.parseDouble(scanner.nextLine());
        int kgBiscuits = Integer.parseInt(scanner.nextLine());

        double priceShtolen = priceBak + 0.6 * priceBak;
        double sumShtolen = kgShtolen * priceShtolen;
        double priceCandy = priceMuf + 0.8 * priceMuf;
        double sumCandy = priceCandy * kgCandy;
        double sumBiscuits = kgBiscuits * 7.50;

        double total = sumBiscuits + sumCandy + sumShtolen;

        System.out.printf("%.2f", total);

    }
}

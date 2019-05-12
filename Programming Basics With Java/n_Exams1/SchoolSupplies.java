package n_Exams1;

import java.util.Scanner;

public class SchoolSupplies {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int pencils = Integer.parseInt(scanner.nextLine());
        int markers = Integer.parseInt(scanner.nextLine());
        double wash = Double.parseDouble(scanner.nextLine());
        int percentOff = Integer.parseInt(scanner.nextLine());

        double pricePencils = pencils * 5.80;
        double priceMarkers = markers * 7.20;
        double priceWash = wash * 1.20;

        double priceAll = priceMarkers + pricePencils + priceWash;

        double total = priceAll - (priceAll*percentOff/100);

        System.out.printf("%.3f",total);

    }
}

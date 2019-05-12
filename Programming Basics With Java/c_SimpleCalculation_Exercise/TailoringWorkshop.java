package c_SimpleCalculation_Exercise;

import java.util.Scanner;

public class TailoringWorkshop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int tables = Integer.parseInt(scanner.nextLine());
        double lenght = Double.parseDouble(scanner.nextLine());
        double width = Double.parseDouble(scanner.nextLine());

        double areaCover = (lenght + 2*0.3) * (width + 2*0.3);
        double totalsAreaCovers = tables*areaCover; // общо покривки

        double areaSquare = (lenght/2) * (lenght/2);
        double totalsSquareArea = tables * areaSquare; // общо карета

        double priceUSD = totalsAreaCovers * 7 + totalsSquareArea *9;
        double priceBGN = priceUSD*1.85;

        System.out.printf("%.2f USD%n", priceUSD);
        System.out.printf("%.2f BGN", priceBGN);



    }
}

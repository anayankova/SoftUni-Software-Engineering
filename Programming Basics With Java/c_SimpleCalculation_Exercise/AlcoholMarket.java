package c_SimpleCalculation_Exercise;

import java.util.Scanner;

public class AlcoholMarket {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double priceWhiskey = Double.parseDouble(scanner.nextLine());
        double litersBeer= Double.parseDouble(scanner.nextLine());
        double litersWine = Double.parseDouble(scanner.nextLine());
        double litersRakia = Double.parseDouble(scanner.nextLine());
        double litersWhiskey = Double.parseDouble(scanner.nextLine());

        double priceRakia = priceWhiskey/2;
        double priceWine = priceRakia - (priceRakia*0.4);
        double priceBeer = priceRakia - (priceRakia*0.8);

        double sumRakia = priceRakia * litersRakia;
        double sumWine = priceWine * litersWine;
        double sumBeer = priceBeer * litersBeer;
        double sumWhiskey = priceWhiskey * litersWhiskey;

        double total = sumBeer + sumRakia + sumWhiskey + sumWine;

        System.out.printf("%.2f",total);


    }
}

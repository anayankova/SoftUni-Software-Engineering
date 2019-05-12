package c_SimpleCalculation_Exercise;

import java.util.Scanner;

public class CharityCampaing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int days = Integer.parseInt(scanner.nextLine());
        int bakers = Integer.parseInt(scanner.nextLine());
        int cakes = Integer.parseInt(scanner.nextLine());
        int waffles = Integer.parseInt(scanner.nextLine());
        int pancakes = Integer.parseInt(scanner.nextLine());

        double priceCakes = cakes * 45;//един сладкар за 1 ден
        double priceWaffles = waffles * 5.80;
        double pricePancakes = pancakes * 3.20;

        double pricePerDay = (priceCakes+pricePancakes+priceWaffles)*bakers; //колко се печели от вс
        double totalPrice =  pricePerDay * days; //пари от цялата кампания

        double expences = totalPrice/8;
        double profit = totalPrice - expences; //печалба

        System.out.printf("%.2f",profit);


    }
}

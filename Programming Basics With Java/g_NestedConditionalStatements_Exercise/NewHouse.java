package g_NestedConditionalStatements_Exercise;

import java.util.Scanner;

public class NewHouse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //"Roses", "Dahlias", "Tulips", "Narcissus", "Gladiolus"
        String typeFlower = scanner.nextLine();
        int count = Integer.parseInt(scanner.nextLine());
        int budget = Integer.parseInt(scanner.nextLine());

        double priceRoses = 5;
        double priceDahlias = 3.80;
        double priceTulips = 2.80;
        double priceNarcissus = 3;
        double priceGladiolus = 2.50;

        double cost = 0; //крайна цена

        switch (typeFlower) {
            case "Roses":
                cost = count * priceRoses;
                break;
            case "Dahlias":
                cost = count * priceDahlias;
                break;
            case "Tulips":
                cost = count * priceTulips;
                break;
            case "Narcissus":
                cost = count * priceNarcissus;
                break;
            case "Gladiolus":
                cost = count * priceGladiolus;
                break;
        }

        if (count > 80 && typeFlower.equals("Roses")) {
            cost = cost - 0.10 * cost;
        } else if (count > 90 && typeFlower.equals("Dahlias")) {
            cost = cost - 0.15 * cost;
        } else if (count > 80 && typeFlower.equals("Tulips")) {
            cost = cost - 0.15 * cost;
        } else if (count < 120 && typeFlower.equals("Narcissus")) {
            cost = cost + 0.15 * cost;
        } else if (count < 80 && typeFlower.equals("Gladiolus")) {
            cost = cost + 0.20 * cost;
        }

        if(budget >= cost){
            double left = budget - cost;
            System.out.printf("Hey, you have a great garden with %d %s and %.2f leva left.", count, typeFlower, left);
        }else{
            double need = cost - budget;
            System.out.printf("Not enough money, you need %.2f leva more.", need);
        }

    }
}

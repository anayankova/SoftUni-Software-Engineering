package n_Exams1;

import java.util.Scanner;

public class EnergyBooster {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String fruit = scanner.nextLine();
        String size = scanner.nextLine();
        int count = Integer.parseInt(scanner.nextLine());

        double pricePer1set = 0;

        switch (fruit) {
            case "Watermelon":
                if (size.equals("small")) {
                    pricePer1set = 2 * 56;
                }else if (size.equals("big")){
                    pricePer1set = 5 * 28.7;
                }
                break;
            case "Mango":
                if (size.equals("small")) {
                    pricePer1set = 2 * 36.66;
                }else if (size.equals("big")){
                    pricePer1set = 5 * 19.6;
                }
                break;
            case "Pineapple":
                if (size.equals("small")) {
                    pricePer1set = 2 * 42.1;
                }else if (size.equals("big")){
                    pricePer1set = 5 * 24.8;
                }
                break;
            case "Raspberry":
                if (size.equals("small")) {
                    pricePer1set = 2 * 20;
                }else if (size.equals("big")){
                    pricePer1set = 5 * 15.2;
                }
                break;
        }

        double price = count * pricePer1set;
        double priceFinal = 0;

        if (price >= 400 && price <= 1000){
            priceFinal = price - 0.15 * price;
        }else if (price > 1000){
            priceFinal = price - 0.5 * price;
        }else {
            priceFinal = price;
        }

        System.out.printf("%.2f lv.",priceFinal);

    }
}

package o_ExamSample;

import java.util.Scanner;

public class SushiTime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String sushi = scanner.nextLine();
        String restaurant = scanner.nextLine();
        int count = Integer.parseInt(scanner.nextLine());
        char symbol = scanner.nextLine().charAt(0);

        double price = 0;
        boolean isRestaurant = false;

        switch (sushi) {
            case "sashimi":
                if (restaurant.equals("Sushi Zone")) {
                    price = count * 4.99;
                } else if (restaurant.equals("Sushi Time")) {
                    price = count * 5.49;
                } else if (restaurant.equals("Sushi Bar")) {
                    price = count * 5.25;
                } else if (restaurant.equals("Asian Pub")) {
                    price = count * 4.50;
                } else {
                    isRestaurant = true;
                    break;
                }
                break;
            case "maki":
                if (restaurant.equals("Sushi Zone")) {
                    price = count * 5.29;
                } else if (restaurant.equals("Sushi Time")) {
                    price = count * 4.69;
                } else if (restaurant.equals("Sushi Bar")) {
                    price = count * 5.55;
                } else if (restaurant.equals("Asian Pub")) {
                    price = count * 4.80;
                } else {
                    isRestaurant = true;
                    break;
                }
                break;
            case "uramaki":
                if (restaurant.equals("Sushi Zone")) {
                    price = count * 5.99;
                } else if (restaurant.equals("Sushi Time")) {
                    price = count * 4.49;
                } else if (restaurant.equals("Sushi Bar")) {
                    price = count * 6.25;
                } else if (restaurant.equals("Asian Pub")) {
                    price = count * 5.50;
                } else {
                    isRestaurant = true;
                    break;
                }
                break;
            case "temaki":
                if (restaurant.equals("Sushi Zone")) {
                    price = count * 4.29;
                } else if (restaurant.equals("Sushi Time")) {
                    price = count * 5.19;
                } else if (restaurant.equals("Sushi Bar")) {
                    price = count * 4.75;
                } else if (restaurant.equals("Asian Pub")) {
                    price = count * 5.50;
                } else {
                    isRestaurant = true;
                    break;
                }
                break;
            default:
                break;
        }

        if (symbol == 'Y') {
            price = price + 0.2 * price;
        }

        if (isRestaurant){
            System.out.printf("%s is invalid restaurant!", restaurant);
        }else{
            System.out.printf("Total price: %.0f lv.",Math.ceil(price));
        }

    }
}

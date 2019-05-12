package g_NestedConditionalStatements_Exercise;

import java.util.Scanner;

public class HotelRoom {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String month = scanner.nextLine();
        int countNight = Integer.parseInt(scanner.nextLine());

        double studioNight = 0;
        double apartmentNight = 0;

        double priceApartment = 0;
        double priceStudio = 0;
        double discountStudio = 1;
        double discountApartment = 1;

        if (month.equals("May") || month.equals("October")){
            studioNight = 50;
            apartmentNight = 65;
            if (countNight > 7 && countNight < 14){
                discountStudio = 0.95;
            }else if (countNight > 14){
                discountStudio = 0.70;
                discountApartment = 0.90;
            }

        }else if (month.equals("June") || month.equals("September")){
            studioNight = 75.2;
            apartmentNight = 68.7;
            if (countNight > 14){
                discountStudio = 0.80;
                discountApartment = 0.90;
            }

        }else  if (month.equals("July") || month.equals("August")){
            studioNight = 76;
            apartmentNight = 77;
            if (countNight > 14){
                discountApartment = 0.90;
            }

        }

        priceApartment = countNight * apartmentNight * discountApartment;
        priceStudio = countNight * studioNight * discountStudio;

        System.out.printf("Apartment: %.2f lv.%n",priceApartment);
        System.out.printf("Studio: %.2f lv.",priceStudio);

    }
}

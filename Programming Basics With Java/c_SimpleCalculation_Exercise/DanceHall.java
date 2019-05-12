package c_SimpleCalculation_Exercise;

import java.util.Scanner;

public class DanceHall {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double lenght = Double.parseDouble(scanner.nextLine());
        double width = Double.parseDouble(scanner.nextLine());
        double sideWardrobe = Double.parseDouble(scanner.nextLine()); //страна на гардероба

        double areaHall = (lenght*100) * (width*100);
        double areaWardrobe = (sideWardrobe*100) * (sideWardrobe*100);
        double areaBench =  areaHall/10;

        double freeSpace = areaHall - areaWardrobe - areaBench;
        double dancers = Math.floor(freeSpace/7040);

        System.out.printf("%.0f", dancers);

    }
}

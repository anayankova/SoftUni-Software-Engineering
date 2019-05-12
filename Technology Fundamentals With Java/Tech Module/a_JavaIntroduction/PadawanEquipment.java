package a_JavaIntroduction;

import java.util.Scanner;

public class PadawanEquipment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double money = Double.parseDouble(scanner.nextLine());
        int students = Integer.parseInt(scanner.nextLine());
        double lightsabers = Double.parseDouble(scanner.nextLine());
        double robes = Double.parseDouble(scanner.nextLine());
        double belts = Double.parseDouble(scanner.nextLine());

        double price1 = lightsabers * (students + Math.ceil(0.1 * students));
        double price2 = robes * students;
        double price3 = belts * (students - Math.floor(students * 1.0 / 6));

        double price = price1 + price2 + price3;

        if (price <= money) {
            System.out.printf("The money is enough - it would cost %.2flv.", price);
        } else {
            System.out.printf("Ivan Cho will need %.2flv more.", price - money);
        }

    }
}

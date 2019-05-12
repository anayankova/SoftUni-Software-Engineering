package n_Exams1;

import java.util.Scanner;

public class SchoolTrip {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int days = Integer.parseInt(scanner.nextLine());
        int allFood = Integer.parseInt(scanner.nextLine());
        double food1dog = Double.parseDouble(scanner.nextLine());
        double food2dog = Double.parseDouble(scanner.nextLine());
        double food3dog = Double.parseDouble(scanner.nextLine());

        double totalFood = days * (food1dog + food2dog + food3dog);

        if (allFood >= totalFood) {
            System.out.printf("%.0f kilos of food left.", Math.floor(allFood - totalFood));
        }else {
            System.out.printf("%.0f more kilos of food are needed.",Math.ceil(totalFood - allFood));
        }

    }
}

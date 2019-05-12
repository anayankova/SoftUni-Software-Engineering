package l_NestedLoop_Lab;

import java.util.Scanner;

public class Travelling2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String destination = scanner.nextLine();

            if (destination.equals("End")) {
                break;
            }

            double budget = Double.parseDouble(scanner.nextLine());
            double sum = 0;

            while (true) {
                double money = Double.parseDouble(scanner.nextLine());
                sum += money;
                if (sum >= budget) {
                    System.out.println("Going to " + destination + "!");
                    break;

                }
            }

        }
    }
}

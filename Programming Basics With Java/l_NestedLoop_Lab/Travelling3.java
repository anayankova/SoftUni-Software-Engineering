package l_NestedLoop_Lab;

import java.util.Scanner;

public class Travelling3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String destination = scanner.nextLine();

        do {
            int budget = Integer.parseInt(scanner.nextLine());
            int sum = 0;

            while (true) {
                int money = Integer.parseInt(scanner.nextLine());
                sum += money;
                if (sum >= budget) {
                    System.out.println("Going to " + destination + "!");
                    break;
                }
            }
            destination = scanner.nextLine();

        } while (!destination.equals("End"));


    }
}

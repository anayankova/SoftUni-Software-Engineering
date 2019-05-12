package h_WhileLoop_Lab;

import java.util.Scanner;

public class AccountBalance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfTransaction = Integer.parseInt(scanner.nextLine());
        int counter = 0;
        double sum = 0;

        while (numberOfTransaction > counter){
            counter++;
            double income = Double.parseDouble(scanner.nextLine());
            if (income < 0){
                System.out.println("Invalid operation!");
                break;
            }
            sum += income;
            System.out.printf("Increase: %.2f%n",income);
        }
        System.out.printf("Total: %.2f",sum);

    }
}

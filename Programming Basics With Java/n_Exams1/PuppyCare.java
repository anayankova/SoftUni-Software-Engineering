package n_Exams1;

import java.util.Scanner;

public class PuppyCare {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int food = Integer.parseInt(scanner.nextLine());
        int allFood = food * 1000;
        int sum = 0;

        while (true) {
            String input = scanner.nextLine();
            if (input.equals("Adopted")){
                break;
            }
            int grams = Integer.parseInt(input);
            sum += grams;
        }

        if (sum <= allFood) {
            System.out.printf("Food is enough! Leftovers: %d grams.", allFood - sum);
        } else {
            System.out.printf("Food is not enough. You need %d grams more.", sum - allFood);
        }
    }
}

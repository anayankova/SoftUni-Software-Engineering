package p_Exammm;

import java.util.Scanner;

public class ChristmasDecoration {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int budget = Integer.parseInt(scanner.nextLine());
        int sum = 0;

        while (true) {
            String text = scanner.nextLine();
            if (text.equals("Stop")) {
                System.out.printf("Money left: %d", budget - sum);
                break;
            }
            for (int i = 0; i < text.length(); i++) {
                char letter = text.charAt(i);
                sum += letter;
            }
            if (sum <= budget) {
                System.out.println("Item successfully purchased!");
            } else {
                System.out.println("Not enough money!");
                break;
            }
        }

    }
}

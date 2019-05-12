package i_WhileLoop_Exercise;

import java.util.Scanner;

public class Cake {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int width = Integer.parseInt(scanner.nextLine());
        int length = Integer.parseInt(scanner.nextLine());
        int area = width * length;
        int pieces = 0;
        int sum = 0;

        while (true) {
            String command = scanner.nextLine();
            if (command.equals("STOP")) {
                if (sum < area) {
                    System.out.printf("%d pieces are left.", area - sum);
                    break;
                }
            }

            pieces = Integer.parseInt(command);
            sum += pieces;
            if (sum > area) {
                System.out.printf("No more cake left! You need %d pieces more.", sum - area);
                break;
            }

        }
    }
}
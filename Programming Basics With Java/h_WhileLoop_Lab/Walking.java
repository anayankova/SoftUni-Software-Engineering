package h_WhileLoop_Lab;

import java.util.Scanner;

public class Walking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int steps = 0;
        int sum = 0;

        while (true) {
            String walks = scanner.nextLine();
            if (walks.equals("Going home")) {
                steps = Integer.parseInt(scanner.nextLine());
                sum += steps;
                if (sum < 10000) {
                    int difference = 10000 - sum;
                    System.out.printf("%d more steps to reach goal.", difference);
                }else {
                    System.out.println("Goal reached! Good job!");
                }
                break;
            }

            steps = Integer.parseInt(walks);
            sum += steps;
            if (sum >= 10000) {
                System.out.println("Goal reached! Good job!");
                break;
            }
        }

    }
}

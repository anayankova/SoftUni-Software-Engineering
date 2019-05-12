package m_NestedLoop_Exercise;

import java.util.Scanner;

public class Fishing2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int quota = Integer.parseInt(scanner.nextLine());
        double price = 0;
        int sumChar = 0;
        double toPay = 0;
        double toGet = 0;
        int count = 0;

        String input = scanner.nextLine();

        while (!input.equals("Stop")) {

            for (int i = (input.length() - 1); i >= 0; i--) {
                char a = input.charAt(i);
                sumChar += a;
            }

            double kilo = Double.parseDouble(scanner.nextLine());

            price = sumChar / kilo;

            sumChar = 0;

            if ((count + 1) % 3 != 0 || (count + 1) == 1) {
                toPay += price;
            }else if ( (count + 1) % 3 == 0){
                toGet += price;
            }

            count++;

            if ( count < (quota )) {
                input = scanner.nextLine();
            }else {
                break;
            }
        }

        if (count == quota) {
            System.out.println("Lyubo fulfilled the quota!");
        }

        double result = toGet - toPay;
        if (toGet > toPay) {
            System.out.printf("Lyubo's profit from %d fishes is %.2f leva.", count, result);
        }else if (toGet < toPay) {
            System.out.printf("Lyubo lost %.2f leva today.", Math.abs(result));
        }

    }
}

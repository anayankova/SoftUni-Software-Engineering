package m_NestedLoop_Exercise;

import java.util.Scanner;

public class Fishing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        double pay = 0;
        double get = 0;
        int count = 0;

        for (int i = 1; i <= n; i++) {
            String name = scanner.nextLine();
            if (name.equals("Stop")){
                break;
            }
            double kg = Double.parseDouble(scanner.nextLine());
            double priceFish = 0;
            count++;
            for (int j = 0; j < name.length(); j++) {
                char symbol = name.charAt(j);
                priceFish += symbol / kg;
            }
            if (i % 3 == 0) {
                get += priceFish;
            } else {
                pay += priceFish;
            }
        }

        if (get > pay && count == n) {
            System.out.println("Lyubo fulfilled the quota!");
            System.out.printf("Lyubo's profit from %d fishes is %.2f leva.", count, get - pay);
        } else if (get > pay && count != n){
            System.out.printf("Lyubo's profit from %d fishes is %.2f leva.", count, get - pay);
        }else {
            System.out.printf("Lyubo lost %.2f leva today.", pay - get);
        }

    }
}

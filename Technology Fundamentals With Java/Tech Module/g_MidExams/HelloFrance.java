package g_MidExams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class HelloFrance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> items = Arrays.stream(scanner.nextLine().split("\\|"))
                .collect(Collectors.toList());

        double budget = Double.parseDouble(scanner.nextLine());
        double profit = 0;
        List<Double> dataNew = new ArrayList<>();
        double BudgetNew = 0;

        for (int i = 0; i < items.size(); i++) {
            List<String> data = Arrays.stream(items.get(i).split("\\-\\>"))
                    .collect(Collectors.toList());


            String item = data.get(0);
            double price = Double.parseDouble(data.get(1));

            if (budget >= price) {


                if (item.equals("Clothes")) {
                    if (price <= 50) {
                        budget -= price;
                        dataNew.add(price + 0.4 * price);
                        profit += 0.4 * price;
                    }
                } else if (item.equals("Shoes")) {
                    if (price <= 35) {
                        budget -= price;
                        dataNew.add(price + 0.4 * price);
                        profit += 0.4 * price;
                    }
                } else if (item.equals("Accessories")) {
                    if (price <= 20.50) {
                        budget -= price;
                        dataNew.add(price + 0.4 * price);
                        profit += 0.4 * price;
                    }
                }
            }

        }

        double sum = 0;

        for (int i = 0; i < dataNew.size(); i++) {
            sum += dataNew.get(i);
            System.out.printf("%.2f ", dataNew.get(i));
        }
        BudgetNew = budget + sum;
        System.out.println();
        System.out.printf("Profit: %.2f", profit);
        System.out.println();

        if (BudgetNew >= 150){
            System.out.println("Hello, France!");
        }else {
            System.out.println("Time to go.");
        }


    }
}

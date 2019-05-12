package n_Exams1;

import java.util.Scanner;

public class WeddingDecoration {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        double sum = 0;
        boolean isMoney = false;
        int countBalloons = 0;
        int countFlowers = 0;
        int countCandles = 0;
        int countRibbon = 0;

        while (budget > sum) {
            String text = scanner.nextLine();
            if (text.equals("stop")) {
                isMoney = true;
                break;
            }
            int count = Integer.parseInt(scanner.nextLine());
            switch (text) {
                case "balloons":
                    sum += count * 0.1;
                    countBalloons += count;
                    break;
                case "flowers":
                    sum += count * 1.5;
                    countFlowers += count;
                    break;
                case "candles":
                    sum += count * 0.5;
                    countCandles += count;
                    break;
                case "ribbon":
                    sum += count * 2;
                    countRibbon += count;
                    break;
            }

        }

        if (budget <= sum){
            System.out.println("All money is spent!");
        }else if (budget > sum && isMoney){
            System.out.printf("Spend money: %.2f%nMoney left: %.2f%n",sum,budget-sum);
        }

        System.out.printf("Purchased decoration is %d balloons, %d m ribbon, %d flowers and %d candles.",
                countBalloons,countRibbon,countFlowers,countCandles);

    }
}

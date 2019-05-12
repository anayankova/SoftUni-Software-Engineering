package i_WhileLoop_Exercise;

import java.util.Scanner;

public class Vacation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double needMoney = Double.parseDouble(scanner.nextLine());
        double availableMoney = Double.parseDouble(scanner.nextLine());

        int spendDays = 0;
        int totalDays = 0;

        while (true){
            String action = scanner.nextLine();
            double sum = Double.parseDouble(scanner.nextLine());
            totalDays++;
            if(action.equals("save")){
                availableMoney += sum;
                spendDays = 0;
            }else if(action.equals("spend")){
                availableMoney -= sum;
                if(availableMoney < 0){
                    availableMoney = 0;
                }
                spendDays++;
            }

            if (spendDays == 5){
                System.out.printf("You can't save the money.%n%d",totalDays);
                break;
            }

            if (availableMoney >= needMoney){
                System.out.printf("You saved the money for %d days.",totalDays);
                break;
            }


        }

    }
}

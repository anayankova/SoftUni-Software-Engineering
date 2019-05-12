package f_NestedConditionalStatements_Lab;

import java.util.Scanner;

public class TradeCommissions {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String town = scanner.nextLine().toLowerCase();
        double sales = Double.parseDouble(scanner.nextLine());

        double commission = -1;
        double percentCommission = 0;

        if (town.equals("sofia")) {
            if (sales >= 0 && sales <= 500) {
                percentCommission = 0.05;
                commission = percentCommission*sales;
            } else if (sales > 500 && sales <= 1000) {
                percentCommission = 0.07;
                commission = percentCommission*sales;
            } else if (sales > 1000 && sales <= 10000) {
                percentCommission = 0.08;
                commission = percentCommission*sales;
            } else if (sales > 10000) {
                percentCommission = 0.12;
                commission = percentCommission*sales;
            }
        } else if (town.equals("varna")) {
            if (sales >= 0 && sales <= 500) {
                percentCommission = 0.045;
                commission = percentCommission*sales;
            } else if (sales > 500 && sales <= 1000) {
                percentCommission = 0.075;
                commission = percentCommission*sales;
            } else if (sales > 1000 && sales <= 10000) {
                percentCommission = 0.10;
                commission = percentCommission*sales;
            } else if (sales > 10000) {
                percentCommission = 0.13;
                commission = percentCommission*sales;
            }
        }else if (town.equals("plovdiv")){
            if (sales >= 0 && sales <= 500) {
                percentCommission = 0.055;
                commission = percentCommission*sales;
            } else if (sales > 500 && sales <= 1000) {
                percentCommission = 0.08;
                commission = percentCommission*sales;
            } else if (sales > 1000 && sales <= 10000) {
                percentCommission = 0.12;
                commission = percentCommission*sales;
            } else if (sales > 10000) {
                percentCommission = 0.145;
                commission = percentCommission*sales;
            }
        }



        if (commission == -1){
            System.out.println("error");
        }else {
            System.out.printf("%.2f",commission);
        }

    }
}

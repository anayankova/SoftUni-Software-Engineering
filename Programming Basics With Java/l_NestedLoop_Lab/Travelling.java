package l_NestedLoop_Lab;

import java.util.Scanner;

public class Travelling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while(true)
        {
            String country = scanner.nextLine();
            if(country.equals("End"))
            {
                break;
            }
            double budget = Double.parseDouble(scanner.nextLine());
            double sum = 0;
            while(budget > sum){
                double money = Double.parseDouble(scanner.nextLine());
                sum += money;
            }
            System.out.printf("Going to %s!\n", country);
        }

    }
}

package e_ConditionStatements_Exercise;

import java.util.Scanner;

public class demo1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double a = Double.parseDouble(scanner.nextLine());
        double b = Double.parseDouble(scanner.nextLine());
        double c = Double.parseDouble(scanner.nextLine());
        double d = Double.parseDouble(scanner.nextLine());

        boolean check = a>b;
        boolean check1 = c>d;
        if(check && check1){
            System.out.println("a>b");
        }


    }
}

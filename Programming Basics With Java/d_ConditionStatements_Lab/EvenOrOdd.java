package d_ConditionStatements_Lab;

import java.util.Scanner;

public class EvenOrOdd {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double num = Double.parseDouble(scanner.nextLine());

        if (num % 2 == 0){
            System.out.println("even");
        }else {
            System.out.println("odd");
        }

    }
}

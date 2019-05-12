package d_ConditionStatements_Lab;

import java.util.Scanner;

public class ExcellentGrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double num = Double.parseDouble(scanner.nextLine());

        if (num >= 5.5){
            System.out.println("Excellent!");
        }else {
            System.out.println("Not excellent!");
        }

    }
}

package h_WhileLoop_Lab;

import java.util.Scanner;

public class Graduation2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        double score = 0;
        double counter = 1;
        int times = 0;

        while (counter <= 12){
            double grade = Double.parseDouble(scanner.nextLine());
            if (grade < 4){
                times++;
                if (times == 2){
                    break;
                }
            }else if (grade >= 4){
                score += grade;
                counter++;
            }
        }
        if (times == 2){
            System.out.printf("%s has been excluded at %.0f grade",name,counter);
        }else {
            double averageGrade = score / 12;
            System.out.printf("%s graduated. Average grade: %.2f", name, averageGrade);
        }
    }
}

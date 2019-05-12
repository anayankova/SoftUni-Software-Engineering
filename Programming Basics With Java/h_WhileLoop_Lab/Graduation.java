package h_WhileLoop_Lab;

import java.util.Scanner;

public class Graduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        double score = 0;
        double counter = 1;

        while (counter <= 12){
            double grade = Double.parseDouble(scanner.nextLine());
            if (grade >= 4){
                score += grade;
                counter++;
            }
        }
        double averageGrade = score / 12;
        System.out.printf("%s graduated. Average grade: %.2f",name,averageGrade);
    }
}

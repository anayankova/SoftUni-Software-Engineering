package e_ConditionStatements_Exercise;

import java.util.Scanner;

public class Scholarship {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double income = Double.parseDouble(scanner.nextLine());
        double averageSuccess = Double.parseDouble(scanner.nextLine());
        double minimalSalary = Double.parseDouble(scanner.nextLine());

        double socialScholarship = 0.35*minimalSalary;
        double excellentScholarship = 25*averageSuccess;

        if (income > minimalSalary && averageSuccess < 5.50){
            System.out.println("You cannot get a scholarship!");
            }else if (income <= minimalSalary && averageSuccess < 4.50){
            System.out.println("You cannot get a scholarship!");
             }else if (income > minimalSalary && averageSuccess >= 5.50){
                System.out.printf("You get a scholarship for excellent results %.0f BGN",
                        Math.floor(excellentScholarship));
            }else if (income <= minimalSalary && averageSuccess >= 4.50 && averageSuccess < 5.50){
                System.out.printf("You get a Social scholarship %.0f BGN", Math.floor(socialScholarship));
            }else  if(income <= minimalSalary && averageSuccess >= 5.50) {
                if (socialScholarship > excellentScholarship) {
                    System.out.printf("You get a Social scholarship %.0f BGN", Math.floor(socialScholarship));
                } else {
                    System.out.printf("You get a scholarship for excellent results %.0f BGN",
                            Math.floor(excellentScholarship));
                }

            }


    }
}

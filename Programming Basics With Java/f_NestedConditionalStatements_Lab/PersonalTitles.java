package f_NestedConditionalStatements_Lab;

import java.util.Scanner;

public class PersonalTitles {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double age = Double.parseDouble(scanner.nextLine());
        char gender = scanner.nextLine().charAt(0);

        if (gender == 'f'){
            if (age >= 16){
                System.out.println("Ms.");
            }else {
                System.out.println("Miss");
            }
        }else {
            if(age >=16){
                System.out.println("Mr.");
            }else{
                System.out.println("Master");
            }
        }

    }
}

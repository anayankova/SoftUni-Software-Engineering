package d_ConditionStatements_Lab;

import java.util.Scanner;

public class EqualsWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
        String b = scanner.nextLine();

        if(a.equalsIgnoreCase(b)){
            System.out.println("yes");
        }else{
            System.out.println("no");
        }



    }
}

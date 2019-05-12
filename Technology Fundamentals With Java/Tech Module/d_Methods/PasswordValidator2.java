package d_Methods;

import java.util.Scanner;

public class PasswordValidator2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String password = scanner.nextLine();

        if(!isInRange(password)){
            System.out.println("Password must be between 6 and 10 characters");
        }

        if(!isLetterOrDigit(password)){
            System.out.println("Password must consist only of letters and digits");
        }

        if(!hasAtLeastTwoDigit(password)){
            System.out.println("Password must have at least 2 digits");
        }

        if (isLetterOrDigit(password) && isInRange(password) &&
        hasAtLeastTwoDigit(password)){
            System.out.println("Password is valid");
        }

    }

    private static boolean hasAtLeastTwoDigit(String password){
        int count = 0;
        for (int i = 0; i < password.length() ; i++) {
            if(Character.isDigit(password.charAt(i))){
                count++;
            }
        }
        if (count < 2){
            return false;
        }
        return true;
    }

    private static boolean isLetterOrDigit(String password){
        for (int i = 0; i < password.length() ; i++) {
            if(!Character.isLetterOrDigit(password.charAt(i))){
                return false;
            }
        }
        return true;
    }

    private static boolean isInRange(String password){
        if (password.length() >= 6 && password.length() <= 10){
            return true;
        }
        return false;
    }
}

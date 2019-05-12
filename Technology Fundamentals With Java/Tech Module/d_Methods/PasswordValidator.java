package d_Methods;

import java.util.Scanner;

public class PasswordValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int count = 0;
        int countLetter = 0;
        int countSymbols = 0;

        for (int i = 0; i < input.length(); i++) {
            count++;
            char symbol = input.charAt(i);
            if ((symbol >= '0' && symbol <= '9') ||
                    (symbol >= 'A' && symbol <= 'Z') ||
                    (symbol >= 'a' && symbol <= 'z')) {
                countSymbols++;
            }
            if (symbol >= '0' && symbol <= '9'){
                countLetter++;
            }
        }

        if ((count >= 6 && count <= 10) && (countSymbols == input.length()) && countLetter >=2 ){
            System.out.println("Password is valid");
        }

        if ((count < 6 || count > 10)){
            System.out.println("Password must be between 6 and 10 characters");
        }

        if (countSymbols != input.length()){
            System.out.println("Password must consist only of letters and digits");
        }

        if (countLetter < 2){
            System.out.println("Password must have at least 2 digits");
        }

    }
}
